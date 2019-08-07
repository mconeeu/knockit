/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.gamesystem.api.game.player.GamePlayer;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.cmd.KnockITCommand;
import eu.mcone.knockit.util.Kits;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void on(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        GamePlayer gamePlayer = KnockIT.getInstance().getGamePlayer(player);

        Location deathLocation = KnockIT.getInstance().getCurrentWorld().getLocation("deathHigh");
        if (!KnockITCommand.setup.contains(player)) {
            if (deathLocation != null && deathLocation.getY() > e.getPlayer().getLocation().getY()) {
                player.setVelocity(new Vector(0, 0, 0));
                player.setHealth(0.0D);
                player.spigot().respawn();

                gamePlayer.setKit(Kits.DEFAULT.getName());
                player.playSound(e.getPlayer().getLocation(), Sound.HURT_FLESH, 1, 1);
            }
        }
    }
}
