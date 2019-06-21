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

    public KitsInventory() {
        super("§8» §e§lHändler §8| §fKits",InventorySlot.ROW_3, CoreInventory.Option.FILL_EMPTY_SLOTS);
    }

    public void createInventory(Player player) {
        setItem(InventorySlot.ROW_2_SLOT_2, Kit.ARCHER.getItem(), e -> {
            KitManager.setKit(player, Kit.ARCHER);
            player.closeInventory();
        });

        setItem(InventorySlot.ROW_2_SLOT_4, Kit.KNOCKBACK.getItem(), e -> {
            KitManager.setKit(player, Kit.KNOCKBACK);
            player.closeInventory();

        });

        setItem(InventorySlot.ROW_2_SLOT_6, Kit.GRAPPLING_HOOK.getItem(), e -> {
            KitManager.setKit(player, Kit.GRAPPLING_HOOK);
            player.closeInventory();
        });


        setItem(InventorySlot.ROW_2_SLOT_8, Kit.ENDERMAN.getItem(), e -> {
            KitManager.setKit(player, Kit.ENDERMAN);
            player.closeInventory();
        });

        openInventory(player);
    }


}
