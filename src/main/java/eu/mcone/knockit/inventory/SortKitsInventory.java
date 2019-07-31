/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.inventory;

import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventoryOption;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.knockit.kit.Kit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class SortKitsInventory extends CoreInventory {

    public SortKitsInventory(Player player) {
        super("§8» §e§lKits sortieren", player, InventorySlot.ROW_3, InventoryOption.FILL_EMPTY_SLOTS);

        int slot = InventorySlot.ROW_2_SLOT_3;
        for (Kit kit : Kit.values()) {
            setItem(slot, new ItemBuilder(kit.getItem().getType()).displayName(kit.getItem().getItemMeta().getDisplayName()).create(), e -> new SortKitInventory(player, kit));
            slot++;
        }

        setItem(InventorySlot.ROW_3_SLOT_9, new ItemBuilder(Material.IRON_DOOR, 1).displayName("§7Zurück").create(), e -> new KitHandlerInventory(player));

        openInventory();
    }
}
