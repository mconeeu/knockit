/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.util.SidebarObjective;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerJoin implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent e){
        Player p = e.getPlayer();
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        e.setJoinMessage("§8[§7§l!§8] §2KnockIt §8» §f" + p.getDisplayName() + " §7ist dem Spiel beigetreten");

        p.setExp(1);
        p.getInventory().clear();
        p.setHealth(20.00);
        p.setLevel(0);
        p.setGameMode(GameMode.SURVIVAL);

        KnockIT.getInstance().getWorld().teleport(p, "spawn");


        CoreSystem.getInstance().createTitle()
                .title("§3§lKNOCKIT")
                .subTitle("§c§lSchlage alle Gegner runter!")
                .stay(5)
                .fadeIn(1)
                .fadeOut(1)
                .send(p);

        p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
        p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
        p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
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



        p.getInventory().setItem(0, i1);
        p.getInventory().setItem(1, i2);
        p.getInventory().setItem(2, i3);

        cp.getScoreboard().setNewObjective(new SidebarObjective());
    }

}
