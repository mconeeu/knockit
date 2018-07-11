/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.gamesystem.api.GameSystemAPI;
import eu.mcone.knockit.KnockIT;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    @EventHandler
    public void on(PlayerDeathEvent e) {
        final Player p = e.getEntity();
        final CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);
        final Player k = p.getKiller() != null ? p.getKiller() : GameSystemAPI.getInstance().getDamageLogger().getKiller(p);

        e.setDeathMessage(null);
        e.setKeepInventory(false);
        e.setKeepLevel(false);
        e.getDrops().clear();
        p.spigot().respawn();

        if (k != null) {
            KnockIT.getInstance().getMessager().send(k, "§7Du hast " + p.getDisplayName() + " §7getötet §8[§a+3 Coins§8]");
            KnockIT.getInstance().getMessager().send(k, "§7Du hast §f1 §7Coin erhalten");

            KnockIT.getInstance().getStatsAPI().addKills(k.getUniqueId(), 1);
            CoreSystem.getInstance().getCorePlayer(k).addCoins(3);
            k.getWorld().playSound(k.getLocation(), Sound.LEVEL_UP, 1, 1);

            KnockIT.getInstance().getMessager().send(p, "§7Du wurdest von §c" + k.getDisplayName() + " §7getötet §8[§c-1 Coins§8]");
            KnockIT.getInstance().getStatsAPI().addDeaths(p.getUniqueId(), 1);

            if (cp.getCoins() > 0) {
                cp.removeCoins(1);
                KnockIT.getInstance().getMessager().send(p, "§7Dir wurde §f1 §7Coin abgezogen");
            }
            k.getWorld().playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);

            k.setLevel(k.getLevel() + 1);
        } else {
            KnockIT.getInstance().getMessager().send(p, "§7Du bist gestorben");
            p.getWorld().playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);
        }
    }

}
