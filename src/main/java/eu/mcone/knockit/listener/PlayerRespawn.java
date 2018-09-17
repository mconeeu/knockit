/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.util.ItemBuilder;
import eu.mcone.knockit.KnockIT;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerRespawn implements Listener {

    @EventHandler
    public void on(PlayerRespawnEvent e) {
        Player p = e.getPlayer();


        p.getInventory().clear();

        p.setExp(1);
        e.setRespawnLocation(KnockIT.getInstance().getWorld().getLocation(KnockIT.getInstance().getWorld().getLocation("spawn")));

        p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
        p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
        p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
        p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));




        ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
        ItemMeta m1 = i1.getItemMeta();
        m1.setDisplayName("§8» §b§lHolz Schwerd");
        m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        i1.setItemMeta(m1);

        ItemStack i2 = new ItemStack(Material.FISHING_ROD);
        ItemMeta m2 = i2.getItemMeta();
        m2.setDisplayName("§8» §f§lEnterhaken");
        i2.setItemMeta(m2);

        ItemStack i3 = new ItemStack(Material.STICK);
        ItemMeta m3 = i3.getItemMeta();
        m3.setDisplayName("§8» §5§lKnockback-Stick");
        m3.addEnchant(Enchantment.KNOCKBACK, 1, true);
        i3.setItemMeta(m3);

        p.getInventory().setItem(1, new ItemBuilder(Material.ARROW, 3, 0).displayName("§8» §6§lPfeile").create());



        p.getInventory().setItem(0, i1);
        p.getInventory().setItem(1, i2);
        p.getInventory().setItem(2, i3);

        CoreSystem.getInstance().createActionBar()
                .message("§c§l§oDu bist gestorben")
                .send(p);

    }

}
