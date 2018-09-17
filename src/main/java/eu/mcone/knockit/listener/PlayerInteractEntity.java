/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.kitinventorys.MainKitInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerInteractEntity implements Listener {


    @EventHandler
    public void on(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();

        if (e.getRightClicked() instanceof Player) {
            Player t = (Player) e.getRightClicked();
            CoreWorld world = CoreSystem.getInstance().getCorePlayer(p).getWorld();

            if (KnockIT.getInstance().getWorld().getNPC("Kit").getUuid().equals(t.getUniqueId())) {
                new MainKitInventory(p);



            }
        }
    }
}