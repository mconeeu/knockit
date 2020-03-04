/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.gameapi.api.event.player.GamePlayerLoadedEvent;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.player.KnockItPlayer;
import eu.mcone.knockit.util.SidebarObjective;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class GeneralPlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.setGameMode(GameMode.SURVIVAL);

        e.setJoinMessage(null);

        CoreSystem.getInstance().createTitle()
                .title("§2§lKnockIT")
                .subTitle("§7§oSchlage alle Gegner runter!")
                .stay(5)
                .fadeIn(1)
                .fadeOut(1)
                .send(p);
    }

    @EventHandler
    public void onGamePlayerLoaded(GamePlayerLoadedEvent e) {
        new KnockItPlayer(e.getCorePlayer());
        e.getCorePlayer().getScoreboard().setNewObjective(new SidebarObjective());
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void on(PlayerItemDamageEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        Entity ent = e.getEntity();

        if (ent instanceof Player) {
            if (e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
                e.setCancelled(true);
            } else if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        KnockItPlayer kp = KnockIT.getInstance().getKnockITPlayer(e.getPlayer().getUniqueId());

        kp.saveData();
        kp.unregister();

        e.setQuitMessage(null);
    }

}
