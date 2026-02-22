package com.juzizhen.potioncoreremastered.mixin;

import com.juzizhen.potioncoreremastered.attribute.ModAttribute;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ViewerCountManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.VehicleInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.network.listener.ServerPlayPacketListener;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.resource.SynchronousResourceReloader;
import net.minecraft.screen.ForgingScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

public class ReachMixin {

    @Mixin(ClientPlayerInteractionManager.class)
    abstract static class ClientPlayerInteractionManagerMixin {
        @Shadow @Final private MinecraftClient client;

        @ModifyConstant(
                method = "getReachDistance()F",
                require = 2, allow = 2, constant = { @Constant(floatValue = 5.0F), @Constant(floatValue = 4.5F) })
        private float getActualReachDistance(final float reachDistance) {
            if (this.client.player != null) {
                return (float) ModAttribute.getReachDistance(this.client.player, reachDistance);
            }
            return reachDistance;
        }
    }

    @Mixin(GameRenderer.class)
    abstract static class GameRendererMixin implements SynchronousResourceReloader/*, AutoCloseable*/ {
        @Shadow @Final MinecraftClient client;

        @ModifyConstant(
                method = "updateTargetedEntity(F)V",
                require = 1, allow = 1, constant = @Constant(doubleValue = 6.0))
        private double getActualReachDistance(final double reachDistance) {
            if (this.client.player != null) {
                return ModAttribute.getReachDistance(this.client.player, reachDistance);
            }
            return reachDistance;
        }

        @ModifyConstant(method = "updateTargetedEntity(F)V", constant = @Constant(doubleValue = 3.0))
        private double getActualAttackRange0(final double attackRange) {
            if (this.client.player != null) {
                return ModAttribute.getAttackRange(this.client.player, attackRange);
            }
            return attackRange;
        }

        @ModifyConstant(method = "updateTargetedEntity(F)V", constant = @Constant(doubleValue = 9.0))
        private double getActualAttackRange1(final double attackRange) {
            if (this.client.player != null) {
                return ModAttribute.getSquaredAttackRange(this.client.player, attackRange);
            }
            return attackRange;
        }
    }

    @Mixin(ViewerCountManager.class)
    abstract static class ChestStateManagerMixin {
        @Shadow
        protected abstract boolean isPlayerViewing(final PlayerEntity player);

        @Redirect(
                method = "updateViewerCount(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V",
                require = 1, allow = 1,
                at = @At(value = "INVOKE", opcode = Opcodes.INVOKEVIRTUAL,
                        target = "Lnet/minecraft/block/entity/ViewerCountManager;getInRangeViewerCount(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)I"))
        private int getReachAccountingOpenCount(final ViewerCountManager manager, final World world, final BlockPos pos) {
            return ModAttribute.getPlayersWithinReach(this::isPlayerViewing, world, pos.getX(), pos.getY(), pos.getZ(), 5.0).size();
        }
    }

    @Mixin(ForgingScreenHandler.class)
    abstract static class ForgingScreenHandlerMixin extends ScreenHandler {
        ForgingScreenHandlerMixin(final ScreenHandlerType<?> type, final int id) {
            super(type, id);
        }

        @ModifyConstant(
                method = "method_24924(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)Ljava/lang/Boolean;",
                require = 1, allow = 1, constant = @Constant(doubleValue = 64.0))
        private double getActualReachDistance(final double reachDistance, final PlayerEntity player) {
            return ModAttribute.getSquaredReachDistance(player, reachDistance);
        }
    }

    @Mixin(value = Inventory.class)
    interface InventoryValidationMixin {
        @Inject(
                method = "canPlayerUse(Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/player/PlayerEntity;I)Z",
                require = 1, allow = 1,
                at = @At(shift = At.Shift.BEFORE, value = "INVOKE", target = "Lnet/minecraft/util/math/BlockPos;getX()I"),
                locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
        private static void checkWithinActualReach(final BlockEntity blockEntity, final PlayerEntity player, final int reachDistance, final CallbackInfoReturnable<Boolean> cir, final World world, final BlockPos pos) {
            if (player.squaredDistanceTo(pos.toCenterPos()) <= ModAttribute.getSquaredReachDistance(player, reachDistance * reachDistance)) {
                cir.setReturnValue(true);
            }
        }
    }

    @Mixin(Item.class)
    abstract static class ItemMixin implements ItemConvertible {
        @ModifyConstant(
                method = "raycast(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/world/RaycastContext$FluidHandling;)Lnet/minecraft/util/hit/BlockHitResult;",
                require = 4, allow = 4, constant = @Constant(doubleValue = 5.0))
        private static double getActualReachDistance(final double reachDistance, final World world, final PlayerEntity player) {
            return ModAttribute.getReachDistance(player, reachDistance);
        }
    }

    @Mixin(LivingEntity.class)
    abstract static class LivingEntityMixin extends Entity {
        LivingEntityMixin(final EntityType<?> type, final World world) {
            super(type, world);
        }

        @Inject(
                method = "createLivingAttributes()Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;",
                require = 1, allow = 1, at = @At("RETURN"))
        private static void addAttributes(final CallbackInfoReturnable<DefaultAttributeContainer.Builder> info) {
            info.getReturnValue().add(ModAttribute.REACH).add(ModAttribute.ATTACK_RANGE);
        }
    }

    @Mixin(targets = "net.minecraft.server.network.ServerPlayNetworkHandler$1")
    abstract static class PlayerEntityInteractionHandlerMixin implements PlayerInteractEntityC2SPacket.Handler {
        @Shadow(aliases = "field_28963") @Final private ServerPlayNetworkHandler field_28963;
        @Shadow(aliases = "field_28962") @Final private Entity field_28962;

        @Inject(method = "attack()V", at = @At("HEAD"), require = 1, allow = 1, cancellable = true)
        private void ensureWithinAttackRange(final CallbackInfo ci) {
            if (!ModAttribute.isWithinAttackRange(this.field_28963.player, this.field_28962)) {
                ci.cancel();
            }
        }
    }

    @Mixin(PlayerEntity.class)
    abstract static class PlayerEntityMixin extends LivingEntity {
        PlayerEntityMixin(final EntityType<? extends LivingEntity> type, final World world) {
            super(type, world);
        }

        @ModifyConstant(method = "attack(Lnet/minecraft/entity/Entity;)V", constant = @Constant(doubleValue = 9.0))
        private double getActualAttackRange(final double attackRange) {
            return ModAttribute.getSquaredAttackRange(this, attackRange);
        }
    }

    @Mixin(ScreenHandler.class)
    abstract static class ScreenHandlerMixin {
        @ModifyConstant(
                method = "method_17696(Lnet/minecraft/block/Block;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)Ljava/lang/Boolean;",
                require = 1, allow = 1, constant = @Constant(doubleValue = 64.0))
        private static double getActualReachDistance(final double reachDistance, final Block block, final PlayerEntity player) {
            return ModAttribute.getSquaredReachDistance(player, reachDistance);
        }
    }

    @Mixin(ServerPlayerInteractionManager.class)
    abstract static class ServerPlayerInteractionManagerMixin {
        @Shadow @Final protected ServerPlayerEntity player;

        @Redirect(
                method = "processBlockBreakingAction",
                at = @At(value = "FIELD", target = "Lnet/minecraft/server/network/ServerPlayNetworkHandler;MAX_BREAK_SQUARED_DISTANCE:D", opcode = Opcodes.GETSTATIC))
        private double getActualReachDistance() {
            return ModAttribute.getSquaredReachDistance(this.player, ServerPlayNetworkHandler.MAX_BREAK_SQUARED_DISTANCE);
        }
    }

    @Mixin(ServerPlayNetworkHandler.class)
    abstract static class ServerPlayNetworkHandlerMixin implements ServerPlayPacketListener {
        @Shadow public ServerPlayerEntity player;

        /**
         * Prevents players from interacting with entities that are too far away.
         *
         * <p>Attack range is further checked in {@link PlayerEntityInteractionHandlerMixin}.
         */
        @Redirect(
                method = "onPlayerInteractEntity(Lnet/minecraft/network/packet/c2s/play/PlayerInteractEntityC2SPacket;)V",
                at = @At(value = "FIELD", target = "Lnet/minecraft/server/network/ServerPlayNetworkHandler;MAX_BREAK_SQUARED_DISTANCE:D", opcode = Opcodes.GETSTATIC))
        private double getActualAttackRange() {
            return ModAttribute.getSquaredReachDistance(this.player, ServerPlayNetworkHandler.MAX_BREAK_SQUARED_DISTANCE);
        }

        @Redirect(
                method = "onPlayerInteractBlock(Lnet/minecraft/network/packet/c2s/play/PlayerInteractBlockC2SPacket;)V",
                at = @At(value = "FIELD", target = "Lnet/minecraft/server/network/ServerPlayNetworkHandler;MAX_BREAK_SQUARED_DISTANCE:D", opcode = Opcodes.GETSTATIC))
        private double getActualReachDistance() {
            return ModAttribute.getSquaredReachDistance(this.player, ServerPlayNetworkHandler.MAX_BREAK_SQUARED_DISTANCE);
        }

        @ModifyConstant(
                method = "onPlayerInteractBlock(Lnet/minecraft/network/packet/c2s/play/PlayerInteractBlockC2SPacket;)V",
                require = 1, allow = 1, constant = @Constant(doubleValue = 64.0))
        private double getActualReachDistance(final double reachDistance) {
            return ModAttribute.getSquaredReachDistance(this.player, reachDistance);
        }
    }

    @Mixin(VehicleInventory.class)
    interface VehicleInventoryValidationMixin {
        @ModifyConstant(
                method = "canPlayerAccess(Lnet/minecraft/entity/player/PlayerEntity;)Z",
                require = 1, allow = 1, constant = @Constant(doubleValue = 8.0))
        private static double getActualReachDistance(final double reachDistance, final PlayerEntity player) {
            return ModAttribute.getReachDistance(player, reachDistance);
        }
    }
}