/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class PlayerLevelChange implements Listener {

    @EventHandler
    public void on(PlayerLevelChangeEvent e) {
        Player p = e.getPlayer();

        if (e.getNewLevel() == 3) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§a3er Killstreak", "§fvon " + p.getDisplayName());
                p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Du hast §a3 §7Coins erhalten");
                CoreSystem.getInstance().getCoinsAPI().addCoins(p.getUniqueId(), 3);
                all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
            }
            Bukkit.broadcastMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §a3er Killstreak!");
        } else if (e.getNewLevel() == 6) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§66er Killstreak", "§fvon " + p.getDisplayName());
                p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Du hast §a3 §7Coins erhalten");
                CoreSystem.getInstance().getCoinsAPI().addCoins(p.getUniqueId(), 3);
                all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
            }
            Bukkit.broadcastMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §66er Killstreak!");
        } else if (e.getNewLevel() == 9) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§c9er Killstreak", "§fvon " + p.getDisplayName());
                p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Du hast §a3 §7Coins erhalten");
                CoreSystem.getInstance().getCoinsAPI().addCoins(p.getUniqueId(), 3);
                all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
            }
            Bukkit.broadcastMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §c9er Killstreak!");
        } else if (e.getNewLevel() == 12) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§412er Killstreak", "§fvon " + p.getDisplayName());
                p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Du hast §a3 §7Coins erhalten");
                ;
                CoreSystem.getInstance().getCoinsAPI().addCoins(p.getUniqueId(), 3);
                all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
            }
            Bukkit.broadcastMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §412er Killstreak!");
        } else if (e.getNewLevel() == 15) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§415er Killstreak", "§fvon " + p.getDisplayName());
                p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Du hast §a3 §7Coins erhalten");
                CoreSystem.getInstance().getCoinsAPI().addCoins(p.getUniqueId(), 3);
                all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
            }
            Bukkit.broadcastMessage(
                    CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §415er Killstreak!");
        } else if (e.getNewLevel() == 18) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§518er Killstreak", "§fvon " + p.getDisplayName());
                all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
                p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Du hast §a6 §7Coins erhalten");
                CoreSystem.getInstance().getCoinsAPI().addCoins(p.getUniqueId(), 6);
            }
            Bukkit.broadcastMessage(
                    CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §518er Killstreak!");
        } else if (e.getNewLevel() == 21) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§521er Killstreak", "§fvon " + p.getDisplayName());
                all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
                p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Du hast §a6 §7Coins erhalten");
                CoreSystem.getInstance().getCoinsAPI().addCoins(p.getUniqueId(), 6);
            }
            Bukkit.broadcastMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §521er Killstreak!");
        } else if (e.getNewLevel() == 24) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§124er Killstreak", "§fvon " + p.getDisplayName());
                all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
                p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Du hast §a6 §7Coins erhalten");
                CoreSystem.getInstance().getCoinsAPI().addCoins(p.getUniqueId(), 6);
            }
            Bukkit.broadcastMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §124er Killstreak!");
        } else if (e.getNewLevel() == 27) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§b27er Killstreak", "§fvon " + p.getDisplayName());
                all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
                p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Du hast §a6 §7Coins erhalten");
                CoreSystem.getInstance().getCoinsAPI().addCoins(p.getUniqueId(), 6);
            }
            Bukkit.broadcastMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §b27er Killstreak!");
        } else if (e.getNewLevel() == 30) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§030er Killstreak", "§fvon " + p.getDisplayName());
                p.sendMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Du hast §a6 §7Coins erhalten");
                all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
                CoreSystem.getInstance().getCoinsAPI().addCoins(p.getUniqueId(), 6);
            }
            Bukkit.broadcastMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §030er Killstreak!");
        }
    }
}
