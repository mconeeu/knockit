/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.inventory;

import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventoryOption;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.coresystem.api.bukkit.item.Skull;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;

public class KitHandlerInventory extends CoreInventory {

    public KitHandlerInventory(Player player) {
        super("§8» §e§lHändler §8| §fKits", player, InventorySlot.ROW_3, InventoryOption.FILL_EMPTY_SLOTS);

        setItem(InventorySlot.ROW_1_SLOT_5, Skull.fromUrl("http://textures.minecraft.net/texture/5163dafac1d91a8c91db576caac784336791a6e18d8f7f62778fc47bf146b6", 1).toItemBuilder().displayName("§e§lHändler").lore("§7§oBeim Händler kannst ausgewählte", "§7§oGadgets oder Kits für kaufen.", "§7§oDie meisten Items erhälst du", "§7§onur durch Coins!").create());

        setItem(InventorySlot.ROW_2_SLOT_3, new ItemBuilder(Material.STICK, 1, 0).displayName("§cGadgets kaufen").enchantment(Enchantment.KNOCKBACK, 1).itemFlags(ItemFlag.HIDE_ENCHANTS).create(),
                e -> new GadgetsInventory(player));

        setItem(InventorySlot.ROW_2_SLOT_7, new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1, 0).displayName("§cKits kaufen").create(),
                e -> new KitsInventory(player));

        setItem(InventorySlot.ROW_3_SLOT_5, new ItemBuilder(Material.CHEST, 1).displayName("§2Kits sortieren").create(), e -> new SortKitsInventory(player));

        openInventory();
    }
}

