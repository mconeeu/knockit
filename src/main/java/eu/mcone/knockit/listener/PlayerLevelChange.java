/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.knockit.KnockIT;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class PlayerLevelChange implements Listener {

    @EventHandler
    public void onPlayerLevelChange(PlayerLevelChangeEvent e) {
        Player p = e.getPlayer();

        if (e.getNewLevel() != 0 && (e.getNewLevel() % 3) == 0) {
            int coins = e.getNewLevel() / 2;

            for (Player player : Bukkit.getOnlinePlayers()) {
                CoreSystem.getInstance().createTitle().title("§a" + e.getNewLevel() + "er Killstreak").subTitle("§fvon " + p.getDisplayName()).stay(5).send(player);
                player.getLocation().getWorld().playSound(p.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);

                if (player != p) {
                    KnockIT.getInstance().getMessager().send(player, "§7Der Spieler §f" + p.getDisplayName() + " §7hat einen §e" + e.getNewLevel() + "§7er Killstreak!");
                } else {
                    KnockIT.getInstance().getMessager().send(player, "§7Du hast einen §e" + e.getNewLevel() + "er Killstreak! §8[§a+" + coins + " Coins§8]");
                    CoreSystem.getInstance().getCorePlayer(p).addCoins(coins);
                }
            }
        }
    }
}
