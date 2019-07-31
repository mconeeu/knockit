/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.gadgets.event;

import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.gadgets.Gadgets;
import eu.mcone.knockit.profile.KnockITPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Random;

public class PlayerSwapListener implements Listener {

    @EventHandler
    public void on(PlayerInteractEvent e) {
        if (e.getItem() != null) {
            if (e.getItem().equals(Gadgets.PLAYER_SWAP.getItem())) {
                Player player = e.getPlayer();
                KnockITPlayer knockITPlayer = KnockIT.getInstance().getKnockITPlayer(e.getPlayer().getUniqueId());

                int playerSize = Bukkit.getOnlinePlayers().size();

                if (playerSize > 1) {
                    Random random = new Random();
                    Player target = null;
                    int playerID = random.nextInt(playerSize);
                    int i = 0;
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (i == playerID) {
                            target = all;
                            break;
                        }

                        i++;
                    }

                    if (target != null) {
                        knockITPlayer.removeGadget(Gadgets.PLAYER_SWAP);

                        Location targetLocation = target.getLocation();
                        Location playerLocation = player.getLocation();

                        target.playSound(targetLocation, Sound.ENDERMAN_TELEPORT, 1, 1);
                        player.playSound(playerLocation, Sound.ENDERMAN_TELEPORT, 1, 1);

                        target.teleport(playerLocation);
                        player.teleport(targetLocation);

                        KnockIT.getInstance().getMessager().send(target, "§2Du wurdest mit dem Spieler §f" + player.getName() + " §2getauscht.");
                        KnockIT.getInstance().getMessager().send(player, "§2Du wurdest mit dem Spieler §f" + target.getName() + " §2getauscht.");
                    } else {
                        KnockIT.getInstance().getMessager().send(player, "§cEs ist ein Fehler aufgetreten, melde dies bitte einem Teammitglied.");
                    }
                } else {
                    KnockIT.getInstance().getMessager().send(player, "§cEs sind momentan nicht genügend Spieler online um das Item benutzen zu können!");
                }
            }
        }
    }
}
