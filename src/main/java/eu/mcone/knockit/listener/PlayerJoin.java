/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.bukkit.CoreSystem;
import eu.mcone.coresystem.bukkit.player.CorePlayer;
import eu.mcone.coresystem.bukkit.util.LocationFactory;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.util.Item;
import eu.mcone.knockit.util.Objective;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent e){
        Player p = e.getPlayer();
        CorePlayer cp = CoreSystem.getCorePlayer(p);

        e.setJoinMessage(KnockIT.config.getConfigValue("System-Prefix") + "§7§ " + p.getDisplayName() + " §7ist dem Spiel beigetreten");

        p.getInventory().clear();
        p.setHealth(20.0D);
        p.setLevel(0);
        p.setGameMode(GameMode.SURVIVAL);

        Item.setItems(p);

        Location spawn = LocationFactory.getConfigLocation(KnockIT.config, "Location-Spawn");
        if (spawn != null) {
            p.teleport(spawn);
        } else if(p.hasPermission("group.admin")) {
            p.sendMessage(KnockIT.config.getConfigValue("System-Prefix") + "§4Der Spawn wurde noch nicht gesetzt!");
        }

        cp.getScoreboard().setNewObjective(new Objective());
    }

}
