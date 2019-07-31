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
import eu.mcone.knockit.kit.Kit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class KitsInventory extends CoreInventory {

    KitsInventory(Player player) {
        super("§8» §e§lHändler §8| §fKits", player, InventorySlot.ROW_3, InventoryOption.FILL_EMPTY_SLOTS);

        setItem(InventorySlot.ROW_2_SLOT_2, Kit.ARCHER.getItem(), e -> buyKit(Kit.ARCHER));

        setItem(InventorySlot.ROW_2_SLOT_4, Kit.KNOCKBACK.getItem(), e -> buyKit(Kit.KNOCKBACK));

        setItem(InventorySlot.ROW_2_SLOT_6, Kit.GRAPPLING_HOOK.getItem(), e -> buyKit(Kit.GRAPPLING_HOOK));

        setItem(InventorySlot.ROW_2_SLOT_8, Kit.ENDERMAN.getItem(), e -> buyKit(Kit.ENDERMAN));

        setItem(InventorySlot.ROW_3_SLOT_9, new ItemBuilder(Material.IRON_DOOR, 1).displayName("§7Zurück").create(), e -> new KitHandlerInventory(player));

        openInventory();
    }

    private void buyKit(Kit kit) {
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(player);

        if (kit != Kit.DEFAULT) {
            if ((cp.getCoins() - kit.getCoins()) >= 0) {
                cp.removeCoins(kit.getCoins());
                player.getInventory().clear();

                KnockIT.getInstance().getKnockITPlayer(player.getUniqueId()).setKit(kit);

                KnockIT.getInstance().getMessager().send(player, "§2Du hast das §7" + kit.getDisplayName() + " §2erfolgreich für §7" + kit.getCoins() + " §2Coins gekauft");
                player.closeInventory();
            } else {
                KnockIT.getInstance().getMessager().send(player, "§cDu hast nicht genügend Coins!");
                player.closeInventory();
            }
        }
    }
}
