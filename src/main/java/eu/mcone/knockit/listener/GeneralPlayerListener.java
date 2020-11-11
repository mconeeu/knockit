/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.gameapi.api.GamePlugin;
import eu.mcone.gameapi.api.event.player.GamePlayerLoadedEvent;
import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.kit.Kit;
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

import static com.mongodb.client.model.Filters.eq;

public class GeneralPlayerListener implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.setGameMode(GameMode.SURVIVAL);

        p.setFlying(false);
        p.setAllowFlight(false);

        e.setJoinMessage(null);
    }

    @EventHandler
    public void onGamePlayerLoaded(GamePlayerLoadedEvent e) {

        GamePlayer gamePlayer = KnockIT.getInstance().getGamePlayer(e.getBukkitPlayer());

        if (CoreSystem.getInstance().getMongoDB().getCollection("knockit_profile").find(eq("uuid", e.getBukkitPlayer().getUniqueId().toString())).first() == null) {
            KnockIT.getInstance().getMessenger().send(e.getBukkitPlayer(), "§7Du scheinst neu auf KnockIT zu sein! Du bekommst das Standart-Kit!");

            gamePlayer.setKit(Kit.DEFAULT, true);
        }


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

        KnockIT.getInstance().isInFishingRodCooldown.remove(e.getPlayer());

        e.setQuitMessage(null);
    }

}
