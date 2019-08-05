/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.gamesystem.api.game.player.GamePlayer;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.profile.KnockITPlayer;
import eu.mcone.knockit.util.Kits;
import eu.mcone.knockit.util.SidebarObjective;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class GeneralPlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);
        GamePlayer gamePlayer = KnockIT.getInstance().getGamePlayer(p);

        KnockIT.getInstance().getMessager().send(p, "§f" + p.getDisplayName() + " §7ist dem Spiel beigetreten");

        new KnockITPlayer(cp);

        p.setExp(1);
        p.getInventory().clear();
        p.setHealth(20.00);
        p.setLevel(0);
        p.setGameMode(GameMode.SURVIVAL);

        p.teleport(KnockIT.getInstance().getCurrentWorld().getLocation("spawn"));

        CoreSystem.getInstance().createTitle()
                .title("§2§lKnockIT")
                .subTitle("§7§oSchlage alle Gegner runter!")
                .stay(5)
                .fadeIn(1)
                .fadeOut(1)
                .send(p);

        gamePlayer.setKit(Kits.DEFAULT.getName());

        cp.getScoreboard().setNewObjective(new SidebarObjective());
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if ((e.getRawSlot() < e.getInventory().getSize()) && (e.getCurrentItem() != null)) {
            e.setCancelled(!KnockIT.getInstance().getBuildSystem().hasBuildModeEnabled((Player) e.getWhoClicked()));
        }
    }

    @EventHandler
    public void on(PlayerItemDamageEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onQuit(PlayerQuitEvent e) {
        KnockIT.getInstance().getMessager().send(e.getPlayer(), "§7 " + e.getPlayer().getDisplayName() + " §7hat das Spiel verlassen");

        KnockITPlayer sp = KnockIT.getInstance().getKnockITPlayer(e.getPlayer().getUniqueId());
        sp.saveData();
        KnockIT.getInstance().unregisterKnockITPlayer(sp);
    }
}
