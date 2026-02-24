package com.juzizhen.potioncoreremastered.mixin;

import com.juzizhen.potioncoreremastered.PotionCoreRemastered;
import com.juzizhen.potioncoreremastered.attribute.ModAttributes;
import com.juzizhen.potioncoreremastered.util.EffectClassifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
@Environment(EnvType.CLIENT)
public abstract class InGameHudMixin {

    @Unique
    private static final Identifier ICON = new Identifier(PotionCoreRemastered.MOD_ID, "textures/gui/magic_shield_test.png");
    @Unique
    int extraX = EffectClassifier.safeParseInt(PotionCoreRemastered.CONFIG.MagicShieldHUDextraX, 0);
    @Unique
    int extraY = EffectClassifier.safeParseInt(PotionCoreRemastered.CONFIG.MagicShieldHUDextraY, 0);

    @Inject(method = "renderStatusBars(Lnet/minecraft/client/gui/DrawContext;)V", at = @At("TAIL"))
    private void renderMagicShieldBar(DrawContext drawContext, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;
        if (player == null) return;

        int magicShield = (int) player.getAttributeValue(ModAttributes.MAGIC_SHIELD);

        if (magicShield <= 0 || player.isCreative() || player.isSpectator()) return;

        // ==================== 位置计算（和原版一致） ====================
        int screenWidth = client.getWindow().getScaledWidth();
        int screenHeight = client.getWindow().getScaledHeight();

        int hungerY = screenHeight - 39;
        if (player.getAir() < player.getMaxAir()) {
            hungerY -= 10;
        }
        int y = hungerY - 10;
        int x = screenWidth / 2 + 91;
        // =================================================================

        if (extraX != 0) x += extraX;
        if (extraY != 0) y += extraY;

        int layers = magicShield / 20;
        int remainder = magicShield % 20;
        int maxSlots = 10;

        // ==================== 计算最后两层（关键：支持 r==0） ====================
        int topLayerRaw = layers;
        int bottomLayerRaw = layers - 1;
        if (remainder == 0 && layers > 0) {
            topLayerRaw = layers - 1;   // 当前完整层变为顶层（全满）
            bottomLayerRaw = layers - 2;
        }
        int bottomLayer = bottomLayerRaw >= 0 ? bottomLayerRaw : -1;
        int topLayer = Math.max(topLayerRaw, 0);

        for (int i = 0; i < maxSlots; i++) {
            int offsetX = x - i * 8 - 9;     // i=0 最右边

            // 1. 空槽
            drawContext.drawTexture(ICON, offsetX, y, 0, 0, 9, 9, 64, 64);

            // 2. 底层完整图标
            if (bottomLayer >= 0) {
                int[] uv = getFullUv(bottomLayer);
                drawContext.drawTexture(ICON, offsetX, y, uv[0], uv[1], 9, 9, 64, 64);
            }

            // 3. 顶层（半/满/完整）
            if (remainder > 0) {
                // 有进度时只在右侧槽位绘制半/满
                if (remainder > i * 2) {
                    boolean isFull = remainder > i * 2 + 1;
                    int[] uv = isFull ? getFullUv(topLayer) : getHalfUv(topLayer);
                    drawContext.drawTexture(ICON, offsetX, y, uv[0], uv[1], 9, 9, 64, 64);
                }
            } else {
                // 整层完成时，顶层全满绘制在所有槽位
                int[] uv = getFullUv(topLayer);
                drawContext.drawTexture(ICON, offsetX, y, uv[0], uv[1], 9, 9, 64, 64);
            }
        }

        // 显示数值
        String text = String.valueOf(magicShield);
        drawContext.drawText(client.textRenderer, text, x + 2, y + 2, 0xFFFFFF, true);
    }

    // 第n层的半个图标 UV
    @Unique
    private int[] getHalfUv(int layer) {
        int mod = layer % 7;   // 7种循环
        return switch (mod) {
            case 0 -> new int[]{9, 0};
            case 1 -> new int[]{27, 0};
            case 2 -> new int[]{45, 0};
            case 3 -> new int[]{0, 9};
            case 4 -> new int[]{18, 9};
            case 5 -> new int[]{36, 9};
            case 6 -> new int[]{54, 9};
            default -> new int[]{0, 0};
        };
    }

    @Unique
    private int[] getFullUv(int layer) {
        int mod = layer % 7;   // 7种循环
        return switch (mod) {
            case 0 -> new int[]{18, 0};
            case 1 -> new int[]{36, 0};
            case 2 -> new int[]{54, 0};
            case 3 -> new int[]{9, 9};
            case 4 -> new int[]{27, 9};
            case 5 -> new int[]{45, 9};
            case 6 -> new int[]{0, 18};
            default -> new int[]{0, 0};
        };
    }
}