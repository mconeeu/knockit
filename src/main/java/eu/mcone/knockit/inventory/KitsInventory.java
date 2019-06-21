/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.inventory;

import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.knockit.kit.Kit;
import eu.mcone.knockit.kit.KitManager;
import org.bukkit.entity.Player;


public class KitsInventory extends CoreInventory {

    public KitsInventory(Player p) {
        super("§8» §e§lHändler §8| §fKits", p, 9 * 3, CoreInventory.Option.FILL_EMPTY_SLOTS);

        setItem(InventorySlot.ROW_2_SLOT_3, Kit.ARCHER.getItem(), e -> {
            KitManager.setKit(p, Kit.ARCHER);
            p.closeInventory();
        });

        setItem(InventorySlot.ROW_2_SLOT_5, Kit.KNOCKBACK.getItem(), e -> {
            KitManager.setKit(p, Kit.KNOCKBACK);
            p.closeInventory();

        });


        setItem(InventorySlot.ROW_2_SLOT_7, Kit.ENDERMAN.getItem(), e -> {
            KitManager.setKit(p, Kit.ENDERMAN);
            p.closeInventory();
        });

        openInventory();
    }


}
