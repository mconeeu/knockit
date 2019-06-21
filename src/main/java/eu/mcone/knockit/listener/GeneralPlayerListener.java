/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.kit.Kit;
import eu.mcone.knockit.kit.KitManager;
import eu.mcone.knockit.util.SidebarObjective;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class GeneralPlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
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
                .title("§2§lKnockIT")
                .subTitle("§7§oSchlage alle Gegner runter!")
                .stay(5)
                .fadeIn(1)
                .fadeOut(1)
                .send(p);

        KitManager.setKit(p, Kit.DEFAULT);

        cp.getScoreboard().setNewObjective(new SidebarObjective());
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        e.setCancelled(!KnockIT.getInstance().getBuildSystem().hasBuildModeEnabled((Player) e.getWhoClicked()));
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e)
    {
        e.setCancelled(true);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7 " + e.getPlayer().getDisplayName() + " §7hat das Spiel verlassen");
    }

}