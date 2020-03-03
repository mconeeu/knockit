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
                    .enchantment(Enchantment.PROTECTION_EXPLOSIONS, 1)
                    .itemFlags(ItemFlag.HIDE_ENCHANTS)
                    .create(),
            10
    ),

    PLAYER_SWAP(
            "§eSpieler tauscher",
            new ItemBuilder(Material.COMPASS)
                    .displayName("§eSpielertauscher")
                    .create(),
            10
    ),

    ROCKET(
            "§7Rakete",
            new ItemBuilder(Material.FIREWORK)
                    .displayName("§7Rakete")
                    .create(),
            10
    );

    private final String displayName;
    private final ItemStack item;
    private final int coins;

    Gadget(final String displayName, final ItemStack item, final int coins) {
        this.displayName = displayName;
        this.item = item;
        this.coins = coins;
    }

}
