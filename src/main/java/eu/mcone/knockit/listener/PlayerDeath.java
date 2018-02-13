/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.bukkit.api.CoinsAPI;
import eu.mcone.gameapi.GameAPI;
import eu.mcone.knockit.KnockIT;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static eu.mcone.coresystem.bukkit.CoreSystem.statsSkypvp;

public class PlayerDeath implements Listener {

    @EventHandler
    public void on(PlayerDeathEvent e) {
        final Player p = e.getEntity();
        final Player k = p.getKiller() != null ? p.getKiller() : GameAPI.getInstance().getDamageLogger().getKiller(p);

        e.setDeathMessage(null);
        e.setKeepInventory(false);
        e.setKeepLevel(false);
        e.getDrops().clear();
        p.spigot().respawn();

        if (k != null) {
            k.sendMessage(KnockIT.config.getConfigValue("System-Prefix") + "§7Du hast " + p.getDisplayName() + " §7getötet §8[§a+3 Coins§8]");
            k.sendMessage(KnockIT.config.getConfigValue("System-Prefix") + "§7Du hast §f1 §7Coin erhalten");
            statsSkypvp.addKills(k.getUniqueId(), 1);
            CoinsAPI.addCoins(k.getUniqueId(), 3);
            KnockIT.playSound(k.getLocation(), Sound.LEVEL_UP);

            p.sendMessage(KnockIT.config.getConfigValue("System-Prefix") + "§7Du wurdest von §c" + k.getDisplayName() + " §7getötet §8[§c-2 Coins§8]");
            statsSkypvp.addDeaths(p.getUniqueId(), 1);

            int coins2 = CoinsAPI.getCoins(p.getUniqueId()) - 1;
            if (coins2 > -1) {
                CoinsAPI.removeCoins(p.getUniqueId(), 1);
                p.sendMessage(KnockIT.config.getConfigValue("System-Prefix") + "§7Dir wurde §f1 §7Coin abgezogen");
            }
            KnockIT.playSound(p.getLocation(), Sound.ANVIL_LAND);

            k.setLevel(k.getLevel() + 1);
        } else {
            p.sendMessage(KnockIT.config.getConfigValue("System-Prefix") + "§7Du bist gestorben");
            KnockIT.playSound(p.getLocation(), Sound.ANVIL_LAND);
        }
    }
}
