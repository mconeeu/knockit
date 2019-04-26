/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
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
            for (Player player : Bukkit.getOnlinePlayers()) {
                CoreSystem.getInstance().createTitle().title("§a"+e.getNewLevel()+"er Killstreak").subTitle("§fvon " + p.getDisplayName()).stay(5).send(player);
            }

            CoreSystem.getInstance().getCorePlayer(p).addCoins(e.getNewLevel());
            KnockIT.getInstance().getMessager().send(p, "§7Du hast §a"+e.getNewLevel()+" §7Coins erhalten");
            p.getLocation().getWorld().playSound(p.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);

            Bukkit.broadcastMessage(CoreSystem.getInstance().getTranslationManager().get("knockit.prefix") + "§7Der Spieler §e" + p.getDisplayName() + " §7hat einen §a"+e.getNewLevel()+"er Killstreak!");
        }
    }

}
