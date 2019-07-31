/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.kit.Kit;
import eu.mcone.knockit.profile.KnockITPlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class InventoryClickListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void on(org.bukkit.event.inventory.InventoryClickEvent e) {
        Inventory inventory = e.getInventory();
        Player player = (Player) e.getWhoClicked();
        if (e.getCurrentItem() != null && e.getRawSlot() < inventory.getSize()) {
            if (e.getCurrentItem() != null && !e.getSlotType().equals(InventoryType.SlotType.OUTSIDE)) {
                if (KnockIT.getInstance().getSorting().containsKey(player)) {
                    if (inventory.getTitle().equalsIgnoreCase("§8» " + KnockIT.getInstance().getSorting().get(player).getDisplayName())) {
                        if (e.getRawSlot() < inventory.getSize()) {
                            e.setCancelled(false);
                        } else {
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void on(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();
        Inventory inventory = e.getInventory();

        if (KnockIT.getInstance().getSorting().containsKey(player)) {
            Kit kit = KnockIT.getInstance().getSorting().get(player);
            if (inventory.getTitle().equalsIgnoreCase("§8» " + kit.getDisplayName())) {
                KnockITPlayer knockITPlayer = KnockIT.getInstance().getKnockITPlayer(player.getUniqueId());

                HashMap<String, Double> sortedItems = new HashMap<>();
                int slot = 0;
                for (ItemStack itemStack : inventory.getContents()) {
                    if (itemStack != null) {
                        if (itemStack.getType() != null && itemStack.getType() != Material.AIR) {
                            sortedItems.put(Integer.toString(slot), kit.getKitItemID(itemStack));
                        }
                    }

                    slot++;
                }

                knockITPlayer.modifyInventory(kit, sortedItems);

                KnockIT.getInstance().getMessager().send(player, "§2Du hast die items für das Kit §f" + kit.getDisplayName() + " §2erfolgreich gesetzt!");
            }
        }
    }
}
