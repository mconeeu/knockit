/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.inventory;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventoryOption;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.gadgets.Gadget;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;

public class GadgetsInventory extends CoreInventory {

    public GadgetsInventory(Player p) {
        this(p, true);
    }

    public GadgetsInventory(Player p, boolean setBackItem) {
        super("§8» §e§lHändler §8| §cGadgets", p, InventorySlot.ROW_3, InventoryOption.FILL_EMPTY_SLOTS);

        setItem(InventorySlot.ROW_2_SLOT_3, Gadget.GRENADE.getItem(), e -> buyItem(Gadget.GRENADE));
        setItem(InventorySlot.ROW_2_SLOT_5, Gadget.PLAYER_SWAP.getItem(), e -> buyItem(Gadget.PLAYER_SWAP));
        setItem(InventorySlot.ROW_2_SLOT_7, Gadget.ROCKET.getItem(), e -> buyItem(Gadget.ROCKET));

        if (setBackItem) {
            setItem(InventorySlot.ROW_3_SLOT_9, BACK_ITEM, e -> new TraderInventory(p));
        }

        openInventory();
    }

    private void buyItem(Gadget gadget) {
        if (player.getLevel() >= gadget.getLevel()) {
            player.setLevel(player.getLevel() - gadget.getLevel());
            CoreSystem.getInstance().getCorePlayer(player).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();

            KnockIT.getInstance().getKnockITPlayer(player.getUniqueId()).setGadget(gadget);
            KnockIT.getInstance().getMessenger().send(player, "§2Du hast das Gadget §a" + gadget.getDisplayName() + "§2 erfolgreich für §f" + gadget.getCoins() + " Killstreaks§2 gekauft");
            player.closeInventory();
        } else {
            KnockIT.getInstance().getMessenger().send(player, "§4Du hast nicht genügend Killstreaks!");
            player.closeInventory();
        }
    }
}

