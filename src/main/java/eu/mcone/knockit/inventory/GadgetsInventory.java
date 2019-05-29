/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.inventory;

import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.util.ItemBuilder;
import eu.mcone.knockit.kit.Kit;
import eu.mcone.knockit.kit.KitManager;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class GadgetsInventory extends CoreInventory {

    public GadgetsInventory(Player p) {
        super("§8» §e§lHändler §8| §cGadgets", p, 9 * 3, CoreInventory.Option.FILL_EMPTY_SLOTS);


        setItem(InventorySlot.ROW_2_SLOT_3, new ItemBuilder(Material.IRON_SWORD, 1, 0).displayName("§bDiamanten Klinge").lore("", "§fKosten 15 Coins").create(),
                e -> p.getInventory().setItem(0, new ItemBuilder(Material.IRON_SWORD).displayName("§8» §bDiamanten Klinge").enchantment(Enchantment.DAMAGE_ALL, 1).create()));


        openInventory();
    }

}

