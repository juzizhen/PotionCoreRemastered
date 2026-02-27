# ✨ PotionCoreRemastered

> Adds a lot of potion effects to the game.

![Header Image](https://i.ibb.co/q351946C/mcmod-icon.png)

---

## 📖 Introduction
- Some inspiration and certain textures come from [PotionCore](https://github.com/Tmtravlr/PotionCore), but none of its open-source code was used.
  - Improvements have been made based on PotionCore.
  - This mod does not include crafting (brewing) recipes; if needed, you can create your own using [KubeJS](https://github.com/KubeJS-Mods/KubeJS).
  - This repository is licensed under **GPL-3.0**.

---

## 🧪 Effects Overview

### ✅ Positive Effect
|         Name         | Effect Description                                                                                                                                                                                                                                              |      Target       |
|:--------------------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:-----------------:|
|     **Antidote**     | Automatically removes poison effects from the body and grants immunity to poison.                                                                                                                                                                               |      Entity       |
| **Improve Accuracy** | Increases projectile damage by **3** points per level.                                                                                                                                                                                                          |      Entity       |
|      **Bless**       | Grants **effect level x 1** type of positive effect lasting 1 minute per Tick.                                                                                                                                                                                  |      Entity       |
|      **Burst**       | Releases an impact with strength of **effect level * 2** to cause knockback and damage to entities, does not harm players, and does not destroy terrain.                                                                                                        |      Entity       |
|      **Climb**       | Allows climbing walls like a spider by walking forward against them.                                                                                                                                                                                            |      Player       |
|       **Cure**       | Removes all negative effects per Tick.                                                                                                                                                                                                                          |      Entity       |
|   **Diamond Skin**   | Increases armor toughness by **4** points per level.                                                                                                                                                                                                            |      Entity       |
|    **Extension**     | If this buff level ≥ number of other status effects, the duration of other status effects will not decrease until this buff disappears.<br/>If this buff level < number of other status effects, other status effects will take turns extending their duration. |      Entity       |
|      **Repair**      | Restores **effect level** points of durability to main hand/off-hand/four armor slots every 5 seconds.<br/>Note: The effect disappearance CD will not reset!                                                                                                    |      Player       |
|     **Revival**      | Grants immunity to one death after obtaining the effect; upon activation, this effect disappears and restores **effect level × 4** health points.<br/>Note: Some special damages cannot be defended, such as instant kill circle artifacts.                     |      Player       |
|     **Step Up**      | Increases step height by **0.5** points per level. Step height: The height that can be walked up without jumping.                                                                                                                                               |      Entity       |
|  **Teleport Spawn**  | With this potion effect, if not moving for 10 seconds, you will be teleported to the spawn point (can teleport across dimensions), producing a large number of particles during teleportation; movement cancels it.                                             |      Player       |
|      **Purity**      | Automatically removes wither effects from the body and grants immunity to wither.                                                                                                                                                                               |      Entity       |
|    **Solid Core**    | Increases knockback immunity by **100%** per level.                                                                                                                                                                                                             |      Entity       |
|   **Magic Focus**    | Increases potion damage by **75%** per level. Note: Invalid for poison potions!                                                                                                                                                                                 |      Entity       |
|      **Flight**      | Same as creative mode flight.                                                                                                                                                                                                                                   |      Player       |
|       **Love**       | Puts animals into love mode, same as feeding animals, but does not force breeding ignoring cooldowns. Note: This effect cannot make players fall in love!                                                                                                       | Non-Player Entity |
| **Teleport Surface** | Upon obtaining this effect, regardless of location, you will be teleported to the nearest surface.                                                                                                                                                              |      Entity       |
|      **Reach**       | Increases the reach radius and attack distance of the entity with this potion effect (**effect level × 1** block).                                                                                                                                              |      Player       |
|    **Iron Skin**     | Increases armor by **2** points per level.                                                                                                                                                                                                                      |      Entity       |
|   **Magic Shield**   | Increases magic shield by **4** points per level. Renewing the potion before the effect ends can stack the potion duration; see **[Special Gameplay](#special-gameplay)** below for magic shield usage.                                                         |      Player       |
|  **Counterattack**   | When injured with this effect, deals **received damage x effect level x 25%** counter damage to the damage source; counter damage will not be countered again, and counter damage is magic damage.                                                              |      Entity       |
|   **Orderliness**    | With this effect, inventory items will be automatically sorted periodically, excluding hotbar, armor slots, and main/off-hand; default cycle **30** seconds, adjustable in config.                                                                              |      Player       |

---

### ❌ Negative Effects
|         Name         | Effect Description                                                                                                                                                       | Target |
|:--------------------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:------:|
|   **Broken Armor**   | Every level reduces **2.5** armor points.                                                                                                                                | Entity |
|      **Curse**       | Every Tick, gain **effect level x 1** type of negative effect lasting 1 minute.                                                                                          | Entity |
| **Disorganization**  | Every Tick, randomly shuffles hotbar and inventory items.                                                                                                                | Player |
|      **Dispel**      | Every Tick, removes all positive effects.                                                                                                                                | Entity |
|      **Drown**       | Can breathe normally underwater, but breathing on land consumes the oxygen bar.                                                                                          | Entity |
|     **Explode**      | Every Tick, generates an explosion with strength **effect level x 2**, damages players, and destroys terrain.                                                            | Entity |
|    **Combustion**    | Every Tick, sets the entity on fire for **effect level x 10** seconds.                                                                                                   | Entity |
|  **Loss Accuracy**   | Every level reduces **4** projectile damage.                                                                                                                             | Entity |
|    **Vulnerable**    | Every level increases **50%** damage taken.                                                                                                                              | Entity |
|       **Rust**       | Every second, subtracts **effect level** durability from all equipped items. Also effective on main hand and off-hand items.                                             | Entity |
|      **Mirror**      | This effect reverses operations. Effects:<br/>Left move <-> Right move; Forward move <-> Backward move; Look up <-> Look down; Left turn <-> Right turn; Sneak <-> Jump. | Player |
| **Magic Inhibition** | Every level reduces **30%** potion damage. Note: Invalid for poison potions!                                                                                             | Entity |
|   **Broken Magic**   | Every level reduces **10% of total magic shield** magic shield. See **[Special Gameplay](#special-gameplay)** below for magic shield usage.                              | Player |
|       **Spin**       | Every Tick, offsets the player's view to a random direction by **effect level x 2~10** degrees.                                                                          | Player |
|      **Weight**      | Every level reduces **5%** movement speed and **3%** jump height.                                                                                                        | Entity |
| **Random Teleport**  | Every 5 Ticks, attempts a teleport once, and teleports when the destination is safe.                                                                                     | Entity |
|    **Lightning**     | Every **5 - effect level** seconds, generates a lightning bolt at the location.                                                                                          | Entity |
|      **Launch**      | At effect level **I**, launch height is **6** blocks; each additional level increases launch height to **effect level x 6 + 2** blocks.                                  | Entity |
| **Potion Sickness**  | This effect has no potion form. Usage see **[Special Gameplay](#special-gameplay)** below. (Only effect)                                                                 | Player |
|    **No Flight**     | Prohibits player creative flight and elytra flight; prohibits flight for all entities except the Ender Dragon.                                                           | Entity |
|    **Depletion**     | Every level reduces **4** max health points.                                                                                                                             | Entity |

---

### ⚖️ Neutral Effects
|    Name    | Effect Description                                                                                                                                                                       | Target |
|:----------:|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:------:|
| **Chance** | Every Tick, gain **effect level x 1** random positive or negative effect lasting 1 minute.                                                                                               | Entity |
| **Invert** | Inverts all invertible effects on the body; remaining time unchanged after inversion. Details see **[Invert Effect Correspondence Table](#Inverted-Effect-Correspondence-Table)** below. | Entity |

---

### Special Gameplay
|        Name         | Description                                                                                                                                                                                                    |
|:-------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|  **Magic Shield**   | Magic shield can reduce corresponding magic damage (including counterattack). Additional magic resistance gained during the Magic Shield effect will stack the magic shield value until the effect disappears. |
| **Potion Sickness** | When there are too many positive buffs, random debuffs will be applied. Disabled by default; can be enabled in the config file, and the probability can also be set in the config file.                        |
---

## Inverted Effect Correspondence Table

|     Beneficial     |      Harmful       |
|:------------------:|:------------------:|
|      Antidote      |       Poison       |
|  Improve Accuracy  |   Loss Accuracy    |
|       Bless        |       Curse        |
|     Iron Skin      |    Broken Armor    |
|    Magic Shield    |    Broken Magic    |
|        Cure        |       Dispel       |
|  Water Breathing   |       Drown        |
|  Fire Resistance   |     Combustion     |
|    Magic Focus     |  Magic Inhibition  |
|       Repair       |        Rust        |
|    Slow Falling    |     Levitation     |
|     Resistance     |     Vulnerable     |
|     Jump Boost     |       Weight       |
|    Night Vision    |     Blindness      |
|       Haste        |   Mining Fatigue   |
|     Saturation     |       Hunger       |
|   Instant Health   |   Instant Damage   |
|    Regeneration    |       Wither       |
|       Speed        |      Slowness      |
|      Strength      |      Weakness      |
|        Luck        |       Unluck       |
|    Orderliness     |  Disorganization   |
|    Health Boost    |     Depletion      |
|       Flight       |     No Flight      |