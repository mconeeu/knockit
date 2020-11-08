/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.gadgets.event;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.gadgets.Gadget;
import eu.mcone.knockit.listener.PlayerHeightListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
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
                    KnockIT.getInstance().getMessenger().send(p, "§4Du kannst am Spawn keine Spieler tauschen!");
                } else {
                    if (!p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.AIR)
                            || !p.getLocation().subtract(0, 1, 0).getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.AIR)
                    ) {
                        if (Bukkit.getOnlinePlayers().size() > 1) {
                            List<Player> swapPlayers = new ArrayList<>();
                            for (Player player : Bukkit.getOnlinePlayers()) {
                                if (player != p && !PlayerHeightListener.isOnSpawn(player.getLocation())) {
                                    swapPlayers.add(player);
                                }
                            }

                            Player t = swapPlayers.get(RANDOM.nextInt(swapPlayers.size()));
                            if (t != null) {
                                t.playSound(t.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
                                p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);

                                t.teleport(p.getLocation());
                                p.teleport(t.getLocation());

                                KnockIT.getInstance().getKnockITPlayer(e.getPlayer().getUniqueId()).removeGadget(Gadget.PLAYER_SWAP);

                                CorePlayer corePlayer = CoreSystem.getInstance().getCorePlayer(p);
                                CorePlayer coreTarget = CoreSystem.getInstance().getCorePlayer(p);

                                KnockIT.getInstance().getMessenger().send(t, "§2Du wurdest mit dem Spieler §f" + corePlayer.getName() + " §2getauscht, da er das §aSwap-Gadget§2 benutzt hat.");
                                KnockIT.getInstance().getMessenger().send(p, "§2Du wurdest mit dem Spieler §f" + coreTarget.getName() + " §2getauscht.");
                                return;
                            }
                        }

                        KnockIT.getInstance().getMessenger().send(p, "§cEs sind momentan nicht genügend Spieler online um das Item benutzen zu können!");
                    } else {
                        KnockIT.getInstance().getMessenger().send(p, "§4Du kannst dieses Gadget nur am Boden benutzen!");
                    }
                }
            }
        }
    }

}
