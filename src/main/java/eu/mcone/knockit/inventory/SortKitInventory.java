/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.inventory;

import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.kit.Kit;
import eu.mcone.knockit.profile.KnockITPlayer;
import org.bukkit.entity.Player;

import java.util.Map;

public class SortKitInventory extends CoreInventory {

    SortKitInventory(Player player, Kit kit) {
        super("§8» " + kit.getDisplayName(), player, InventorySlot.ROW_1);
        KnockITPlayer knockITPlayer = KnockIT.getInstance().getKnockITPlayer(player.getUniqueId());

        KnockIT.getInstance().getSorting().put(player, kit);

        if (knockITPlayer.isKitModified(kit)) {
            for (Map.Entry<String, Double> itemEntry : knockITPlayer.getModifiedKit(kit).getCustomItems().entrySet()) {
                Kit.KitItem kitItem = kit.getKitItem(itemEntry.getValue());
                if (kitItem != null) {
                    setItem(Integer.valueOf(itemEntry.getKey()), kitItem.getItemStack());
                }
            }
        } else {
            int slot = 0;
            for (Kit.KitItem kitItem : kit.getKitItems()) {
                inventory.setItem(slot, kitItem.getItemStack());
                slot++;
            }
        }

        openInventory();
    }
}
