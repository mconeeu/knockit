/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.gamemode.Gamemode;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.gameapi.api.GameAPI;
import eu.mcone.gameapi.api.damage.DamageLogger;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.kit.Kit;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class PlayerDeathListener implements Listener {

    private static final DamageLogger DAMAGE_LOGGER = GameAPI.getInstance().constructDamageLogger();

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        final Player p = e.getEntity();
        final CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);
        final Player k = p.getKiller() != null ? p.getKiller() : DAMAGE_LOGGER.getKiller(p);

        e.setDeathMessage(null);
        e.setKeepInventory(false);
        e.getDrops().clear();
        p.setLevel(0);

        p.setVelocity(new Vector(0, 0, 0));
        p.spigot().respawn();

        if (k != null) {
            final CorePlayer ck = CoreSystem.getInstance().getCorePlayer(k);

            KnockIT.getInstance().getMessager().send(k, "§7Du hast §6" + p.getDisplayName() + " §7getötet §8[§a+3 Coins§8]");
            ck.getStats(Gamemode.KNOCKIT).addKills(1);
            ck.addCoins(3);
            k.getWorld().playSound(k.getLocation(), Sound.LEVEL_UP, 1, 1);
            k.setLevel(k.getLevel() + 1);
            k.addPotionEffect(PotionEffectType.REGENERATION.createEffect(20*20, 3));

            KnockIT.getInstance().getMessager().send(p, "§7Du wurdest von §c" + k.getDisplayName() + " §7getötet §8[§c-1 Coins§8]");
            if (cp.getCoins() > 5) cp.removeCoins(5);
        } else {
            KnockIT.getInstance().getMessager().send(p, "§7Du bist gestorben");
        }

        p.playSound(p.getLocation(), Sound.VILLAGER_HIT, 1, 1);
        cp.getStats(Gamemode.KNOCKIT).addDeaths(1);
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();

        p.getInventory().clear();
        p.setExp(1);

        Bukkit.getScheduler().runTask(KnockIT.getInstance(), () ->
                GameAPI.getInstance().getGamePlayer(p).setKit(Kit.DEFAULT));

        CoreSystem.getInstance().createActionBar()
                .message("§c§oDu bist gestorben")
                .send(p);
    }

}
