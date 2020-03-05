/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.gadgets;

import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

@Getter
public enum Gadget {

    GRENADE(
            "§cGranate",
            new ItemBuilder(Material.EGG)
                    .displayName("§cGranate")
                    .lore("§7§oDieses Gadget kostet", "§7§o3 Killstreaks")
                    .enchantment(Enchantment.PROTECTION_EXPLOSIONS, 1)
                    .itemFlags(ItemFlag.HIDE_ENCHANTS)
                    .create(),
            10,
            3
    ),

    PLAYER_SWAP(
            "§eSpieler tauscher",
            new ItemBuilder(Material.COMPASS)
                    .displayName("§eSpielertauscher")
                    .lore("§7§oDieses Gadget kostet", "§7§o3 Killstreaks")
                    .create(),
            10,
            3
    ),

    ROCKET(
            "§7Rakete",
            new ItemBuilder(Material.FIREWORK)
                    .displayName("§7Rakete")
                    .lore("§7§oDieses Gadget kostet", "§7§o2 Killstreaks")
                    .create(),
            10,
            2
    );

    private String displayName;
    private ItemStack item;
    private int coins, level;

    Gadget(String displayName, ItemStack item, int coins, int level) {
        this.displayName = displayName;
        this.item = item;
        this.coins = coins;
        this.level = level;
    }

}
