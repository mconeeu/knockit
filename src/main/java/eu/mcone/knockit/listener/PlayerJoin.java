/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.BukkitCorePlayer;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.util.Item;
import eu.mcone.knockit.util.Objective;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent e){
        Player p = e.getPlayer();
        BukkitCorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        e.setJoinMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + "§7§ " + p.getDisplayName() + " §7ist dem Spiel beigetreten");

        p.getInventory().clear();
        p.setHealth(20.0D);
        p.setLevel(0);
        p.setGameMode(GameMode.SURVIVAL);

        Item.setItems(p);
        KnockIT.getInstance().getLocationManager().teleport(p, "spawn");

        cp.getScoreboard().setNewObjective(new Objective());
    }

}
