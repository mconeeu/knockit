/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.inventory;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventoryOption;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.gadgets.Gadgets;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class GadgetsInventory extends CoreInventory {

    GadgetsInventory(Player player) {
        super("§8» §e§lHändler §8| §cGadgets", player, InventorySlot.ROW_3, InventoryOption.FILL_EMPTY_SLOTS);

        setItem(InventorySlot.ROW_2_SLOT_3, Gadgets.GRENADE.getItem(), e -> buyItem(Gadgets.GRENADE));

        setItem(InventorySlot.ROW_2_SLOT_5, Gadgets.PLAYER_SWAP.getItem(), e -> {
            if (Bukkit.getOnlinePlayers().size() >= 1) {
                KnockIT.getInstance().getMessager().send(player, "§cEs sind momentan nicht genügend Spieler online damit du dieses Item bnutzen kannst.");
            } else {
                buyItem(Gadgets.PLAYER_SWAP);
            }
        });

        setItem(InventorySlot.ROW_2_SLOT_7, Gadgets.ROCKET.getItem(), e -> buyItem(Gadgets.ROCKET));

        setItem(InventorySlot.ROW_3_SLOT_9, new ItemBuilder(Material.IRON_DOOR, 1).displayName("§7Zurück").create(), e -> new KitHandlerInventory(player));

        openInventory();
    }

    private void buyItem(Gadgets gadgets) {
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(player);

        if ((cp.getCoins() - gadgets.getCoins()) >= 0) {
            cp.removeCoins(gadgets.getCoins());
            player.getInventory().clear();

            KnockIT.getInstance().getKnockITPlayer(player.getUniqueId()).setGadget(gadgets);

            KnockIT.getInstance().getMessager().send(player, "§2Du hast das dir das Gadget §7" + gadgets.getDisplayName() + " §2erfolgreich für §7" + gadgets.getCoins() + " §2Coins gekauft");
            player.closeInventory();
        } else {
            KnockIT.getInstance().getMessager().send(player, "§cDu hast nicht genügend Coins!");
            player.closeInventory();
        }
    }
}

