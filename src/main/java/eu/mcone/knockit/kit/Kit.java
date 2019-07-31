/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.kit;

import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public enum Kit {

    DEFAULT(
            "§7Standard-Kit",
            1,
            new ItemBuilder(Material.LEATHER_CHESTPLATE).create(),
            new KitItem[]{
                    new KitItem(1.1, new ItemBuilder(Material.WOOD_SWORD).displayName("§8» §b§lHolz Schwert").enchantment(Enchantment.DAMAGE_ALL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create()),
                    new KitItem(1.2, new ItemBuilder(Material.FISHING_ROD).displayName("§8» §f§lAngel").unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create()),
                    new KitItem(1.3, new ItemBuilder(Material.STICK).displayName("§8» §5§lKnockback-Stick").enchantment(Enchantment.KNOCKBACK, 1).create()),
                    new KitItem(1.4, new ItemBuilder(Material.QUARTZ_BLOCK, 3).displayName("§8» §6§lMLG-Block").create())
            },
            0
    ),
    ARCHER(
            "§2Bogenschützen-Kit",
            2,
            new ItemBuilder(Material.IRON_CHESTPLATE)
                    .displayName("§aBogenschützen-Kit")
                    .lore(
                            "",
                            "§f§oMit diesem Kit erhälst du",
                            "§f§ofolgende Items:",
                            "",
                            "§6» §7Stein Schwert",
                            "§6» §7Angel",
                            "§6» §7Knockback-Stick",
                            "§6» §7Bogen",
                            "§6» §7Pfeile (3 Stück)",
                            "",
                            "§f§oKosten 100 Coins",
                            "",
                            "§4§lACHTUNG DU HAST DIESES KIT NUR EIN MAL!"
                    ).create(),
            new KitItem[]{
                    new KitItem(2.1, new ItemBuilder(Material.STONE_SWORD).displayName("§8» §b§lStein Schwert").enchantment(Enchantment.DAMAGE_ALL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create()),
                    new KitItem(2.2, new ItemBuilder(Material.FISHING_ROD).displayName("§8» §f§lAngel").unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create()),
                    new KitItem(2.3, new ItemBuilder(Material.STICK).displayName("§8» §5§lKnockback-Stick").enchantment(Enchantment.KNOCKBACK, 1).create()),
                    new KitItem(2.4, new ItemBuilder(Material.BOW).displayName("§8» §d§lBogen").create()),
                    new KitItem(2.5, new ItemBuilder(Material.ARROW, 3, 0).displayName("§8» §6§lPfeile").create())
            },
            100
    ),
    KNOCKBACK(
            "§5Knockback-Kit",
            3,
            new ItemBuilder(Material.CHAINMAIL_CHESTPLATE)
                    .displayName("§5Knockback-Kit")
                    .lore(
                            "",
                            "§f§oMit diesem Kit erhälst du",
                            "§f§ofolgende Items:",
                            "",
                            "§6» §7Stein Schwert (Lv. 1)",
                            "§6» §7Knockback-Stick (Lv. 2)",
                            "§6» §7Angel",
                            "",
                            "§f§oKosten 100 Coins",
                            "",
                            "§4§lACHTUNG DU HAST DIESES KIT NUR EIN MAL!"
                    ).create(),
            new KitItem[]{
                    new KitItem(3.1, new ItemBuilder(Material.STONE_SWORD).displayName("§8» §b§lStein Schwert").enchantment(Enchantment.DAMAGE_ALL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create()),
                    new KitItem(3.2, new ItemBuilder(Material.STICK).displayName("§8» §5§lKnockback-Stick").enchantment(Enchantment.KNOCKBACK, 2).create()),
                    new KitItem(3.3, new ItemBuilder(Material.FISHING_ROD).displayName("§8§ §f§lAngel").unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create())
            },
            100
    ),
    GRAPPLING_HOOK(
            "§dEnterhacken-Kit",
            4,
            new ItemBuilder(Material.GOLD_CHESTPLATE)
                    .displayName("§dEnterhacken-Kit")
                    .lore(
                            "",
                            "§f§oMit diesem Kit erhälst du",
                            "§f§ofolgende Kit:",
                            "",
                            "§6» §7Stein Schwert",
                            "§6» §7Enterhacken",
                            "§6» §7Knockback-Stick",
                            "",
                            "§f§oKosten 125 Coins",
                            "",
                            "§4§lACHTUNG DU HAST DIESES KIT NUR EIN MAL!"
                    ).create(),
            new KitItem[]{
                    new KitItem(4.1, new ItemBuilder(Material.STONE_SWORD).displayName("§8» §b§lStein Schwert").unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).enchantment(Enchantment.DAMAGE_ALL, 2).create()),
                    new KitItem(4.2, new ItemBuilder(Material.FISHING_ROD).displayName("§6» §7Enterhacken").unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create()),
                    new KitItem(4.3, new ItemBuilder(Material.STICK).displayName("§8» §5§lKnockback-Stick").enchantment(Enchantment.KNOCKBACK, 2).create())
            },
            125
    ),
    ENDERMAN(
            "§bEnderman-Kit",
            5,
            new ItemBuilder(Material.DIAMOND_CHESTPLATE)
                    .displayName("§5Enderman-Kit")
                    .lore(
                            "",
                            "§f§oMit diesem Kit erhälst du",
                            "§f§ofolgende Kit:",
                            "",
                            "§6» §7Stein Schwert",
                            "§6» §7Angel",
                            "§6» §7Knockback-Stick",
                            "§6» §7Enderperle",
                            "",
                            "§f§oKosten 150 Coins",
                            "",
                            "§4§lACHTUNG DU HAST DIESES KIT NUR EIN MAL!"
                    ).create(),
            new KitItem[]{
                    new KitItem(4.1, new ItemBuilder(Material.STONE_SWORD).displayName("§8» §b§lStein Schwert").enchantment(Enchantment.DAMAGE_ALL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create()),
                    new KitItem(4.2, new ItemBuilder(Material.FISHING_ROD).displayName("§8» §f§lAngel").unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create()),
                    new KitItem(4.3, new ItemBuilder(Material.STICK).displayName("§8» §5§lKnockback-Stick").enchantment(Enchantment.KNOCKBACK, 1).create()),
                    new KitItem(4.4, new ItemBuilder(Material.ENDER_PEARL).displayName("§8§ §d§lEnderperle").create())
            },
            150
    );

    @Getter
    private final String displayName;
    @Getter
    private final int kitID;
    @Getter
    private final ItemStack item;
    @Getter
    private final KitItem[] kitItems;
    @Getter
    private final int coins;

    Kit(final String displayName, final int kitID, final ItemStack item, final KitItem[] kitItems, final int coins) {
        this.displayName = displayName;
        this.kitID = kitID;
        this.item = item;
        this.kitItems = kitItems;
        this.coins = coins;
    }

    public KitItem getKitItem(final double kitItemID) {
        for (KitItem kitItem : kitItems) {
            if (kitItem.getKitItemID() == kitItemID) {
                return kitItem;
            }
        }

        return null;
    }

    public double getKitItemID(ItemStack itemStack) {
        for (KitItem kitItem : kitItems) {
            if (kitItem.getItemStack().equals(itemStack)) {
                return kitItem.getKitItemID();
            }
        }

        return 0;
    }

    public static class KitItem {

        @Getter
        private final double kitItemID;
        @Getter
        private final ItemStack itemStack;

        KitItem(final double kitItemID, final ItemStack itemStack) {
            this.kitItemID = kitItemID;
            this.itemStack = itemStack;
        }
    }
}
