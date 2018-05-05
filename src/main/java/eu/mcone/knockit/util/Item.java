/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.util;

import eu.mcone.coresystem.api.bukkit.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public enum Item {

    KNOCKBACK_STICK(0, new ItemBuilder(Material.STICK, 1, 0).displayName("§8» §5§lKnockback-Stick").enchantment(Enchantment.KNOCKBACK, 1).create(), null),
    FISHING_ROD(1, new ItemBuilder(Material.FISHING_ROD, 1, 0).displayName("§8» §f§lEnterhaken").create(), "Item-Angel"),
    MLG_BLOCK(8, new ItemBuilder(Material.QUARTZ_BLOCK, 3, 0).displayName("§8» §6§lMLG-Block").create(), "Item-MLG");

    private int slot;
    private ItemStack item;
    private String configValue;

    Item(int slot, ItemStack item, String configValue) {
        this.slot = slot;
        this.item = item;
        this.configValue = configValue;
    }

    public static void setItems(Player p) {
        Inventory i = p.getInventory();

        for (Item item : values()) {
            i.setItem(item.getSlot(), item.getItem());
        }
    }

    public int getSlot() {
        return slot;
    }

    public ItemStack getItem() {
        return item;
    }

    public String getConfigValue() {
        return configValue;
    }
}
