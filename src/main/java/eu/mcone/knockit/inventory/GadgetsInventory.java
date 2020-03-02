/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.inventory;

import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventoryOption;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import org.bukkit.entity.Player;

public class GadgetsInventory extends CoreInventory {

    public GadgetsInventory(Player p) {
        super("§8» §e§lHändler §8| §cGadgets", p, InventorySlot.ROW_3, InventoryOption.FILL_EMPTY_SLOTS);
        openInventory();
    }

}

