/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.gameapi.api.backpack.defaults.DefaultItem;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.kit.Kit;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class FishingRodListener implements Listener {

    @EventHandler
    public void on(PlayerFishEvent e) {
        Player p = e.getPlayer();

        FishHook h = e.getHook();


        if (!KnockIT.getInstance().isInFishingRodCooldown.contains(p)) {
            if (((e.getState().equals(PlayerFishEvent.State.IN_GROUND)) ||
                    (e.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY)) ||
                    (e.getState().equals(PlayerFishEvent.State.FAILED_ATTEMPT))) &&
                    (p.getItemInHand().getType().equals(Material.FISHING_ROD) &&
                            (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§8§ §d§lEnterhaken"))) &&
                    (Bukkit.getWorld(e.getPlayer().getWorld().getName())
                            .getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1,
                                    h.getLocation().getBlockZ())
                            .getType() != Material.AIR)) {
                if (Bukkit.getWorld(e.getPlayer().getWorld().getName())
                        .getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1,
                                h.getLocation().getBlockZ())
                        .getType() != Material.STATIONARY_WATER) {
                    Location lc = p.getLocation();
                    Location to = e.getHook().getLocation();

                    lc.setY(lc.getY() + 0.7D);
                    p.teleport(lc);

                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 3, 3);
                    double g = -0.08D;
                    double t = to.distance(lc);
                    double v_x = (1.0D + 0.07D * t) * (to.getX() - lc.getX()) / t;
                    double v_y = (1.0D + 0.03D * t) * (to.getY() - lc.getY()) / t - 0.5D * g * t;
                    double v_z = (1.0D + 0.07D * t) * (to.getZ() - lc.getZ()) / t;

                    Vector v = p.getVelocity();
                    v.setX(v_x);
                    v.setY(v_y);
                    v.setZ(v_z);
                    p.setVelocity(v);

                    int heldItemSlot = p.getInventory().getHeldItemSlot();
                    p.getInventory().setItem(heldItemSlot, new ItemBuilder(Material.INK_SACK, 1).displayName("Lädt...").create());

                    KnockIT.getInstance().isInFishingRodCooldown.add(p);

                    Bukkit.getScheduler().runTaskLater(
                            KnockIT.getInstance(),
                            () -> {
                                if (KnockIT.getInstance().isInFishingRodCooldown.contains(p)) {
                                    KnockIT.getInstance().isInFishingRodCooldown.remove(p);
                                    p.playSound(p.getLocation(), Sound.ORB_PICKUP, 3, 3);

                                    p.getInventory().setItem(heldItemSlot, new ItemBuilder(Material.FISHING_ROD)
                                            .displayName("§8§ §d§lEnterhaken")
                                            .lore("§d§oEnterhaken-Kit")
                                            .unbreakable(true)
                                            .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                                            .enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
                                            .itemFlags(ItemFlag.HIDE_ENCHANTS)
                                            .create());
                                }
                            }, 120);
                }
            }
        }
    }
}
