/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.gameapi.api.GameAPI;
import eu.mcone.gameapi.api.GamePlugin;
import eu.mcone.gameapi.api.damage.DamageLogger;
import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.cmd.KnockITCommand;
import eu.mcone.knockit.kit.Kit;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;

import javax.swing.*;

public class PlayerDeathListener implements Listener {

    private static final DamageLogger DAMAGE_LOGGER = GameAPI.getInstance().constructDamageLogger();

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        final Player p = e.getEntity();
        final Player k = p.getKiller() != null ? p.getKiller() : DAMAGE_LOGGER.getKiller(p);
        final CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        p.setLevel(0);

        e.setDeathMessage(null);
        e.setKeepInventory(false);
        e.getDrops().clear();

        KnockIT.getInstance().isInFishingRodCooldown.remove(p);

        p.spigot().respawn();

        if (k != null && !p.equals(k)) {
            final CorePlayer ck = CoreSystem.getInstance().getCorePlayer(k);

            KnockIT.getInstance().getMessenger().send(k, "§7Du hast §6" + cp.bukkit().getName() + " §7getötet §8[§a+3 Coins§8]");
            GameAPI.getInstance().getGamePlayer(k).addKills(1);
            ck.addCoins(3);
            k.getWorld().playSound(k.getLocation(), Sound.LEVEL_UP, 1, 1);
            k.setLevel(k.getLevel() + 1);
            k.addPotionEffect(PotionEffectType.REGENERATION.createEffect(20 * 20, 3));

            ck.getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();

            KnockIT.getInstance().getMessenger().send(p, "§7Du wurdest von §c" + ck.bukkit().getName() + " §7getötet §8[§c-1 Coins§8]");
            if (cp.getCoins() > 5) cp.removeCoins(5);
        } else {
            KnockIT.getInstance().getMessenger().send(p, "§7Du bist gestorben");
        }


        p.playSound(p.getLocation(), Sound.VILLAGER_HIT, 1, 1);
        GameAPI.getInstance().getGamePlayer(p).addDeaths(1);
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();

        Bukkit.getScheduler().runTaskLater(KnockIT.getInstance(), () -> {
            CorePlayer corePlayer = CoreSystem.getInstance().getCorePlayer(p);
            corePlayer.getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
        }, 21);

        CoreSystem.getInstance().createActionBar()
                .message("§c§oDu bist gestorben")
                .send(p);
    }

}
