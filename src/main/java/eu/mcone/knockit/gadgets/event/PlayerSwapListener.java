/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.gadgets.event;

import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.gadgets.Gadget;
import eu.mcone.knockit.listener.PlayerHeightListener;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class PlayerSwapListener implements Listener {

    private static final Random RANDOM = new Random();

    @EventHandler
    public void on(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            ItemStack i = e.getItem();
            if ((i == null) || (!i.hasItemMeta()) || (!i.getItemMeta().hasDisplayName())) {
                return;
            }

            if (i.equals(Gadget.PLAYER_SWAP.getItem())) {
                if (PlayerHeightListener.isOnSpawn(p.getLocation())) {
                    KnockIT.getInstance().getMessager().send(p, "§4Du kannst am Spawn keine Spieler tauschen!");
                } else {
                    int playerSize = Bukkit.getOnlinePlayers().size();

                    if (playerSize > 1) {
                        Player target = null;
                        int playerID = RANDOM.nextInt(playerSize);
                        int x = 0;
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            if (x == playerID) {
                                target = all;
                                break;
                            }

                            x++;
                        }

                        if (target != null) {
                            KnockIT.getInstance().getKnockITPlayer(e.getPlayer().getUniqueId()).removeGadget(Gadget.PLAYER_SWAP);

                            Location targetLocation = target.getLocation();
                            Location playerLocation = p.getLocation();

                            target.playSound(targetLocation, Sound.ENDERMAN_TELEPORT, 1, 1);
                            p.playSound(playerLocation, Sound.ENDERMAN_TELEPORT, 1, 1);

                            target.teleport(playerLocation);
                            p.teleport(targetLocation);

                            KnockIT.getInstance().getMessager().send(target, "§2Du wurdest mit dem Spieler §f" + p.getName() + " §2getauscht.");
                            KnockIT.getInstance().getMessager().send(p, "§2Du wurdest mit dem Spieler §f" + target.getName() + " §2getauscht.");
                        } else {
                            KnockIT.getInstance().getMessager().send(p, "§cEs ist ein Fehler aufgetreten, melde dies bitte einem Teammitglied.");
                        }
                    } else {
                        KnockIT.getInstance().getMessager().send(p, "§cEs sind momentan nicht genügend Spieler online um das Item benutzen zu können!");
                    }
                }
            }
        }
    }

}
