/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.event.NpcInteractEvent;
import eu.mcone.knockit.inventory.KitHandlerInventory;
import net.minecraft.server.v1_8_R3.PacketPlayInUseEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NpcListener implements Listener {

    @EventHandler
    public void onNpcInteract(NpcInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getNpc().getData().getType().equals(EntityType.PLAYER) && e.getAction().equals(PacketPlayInUseEntity.EnumEntityUseAction.INTERACT)) {
            if (e.getNpc().getData().getDisplayname().equalsIgnoreCase("§2§lKits/Gadgets")) {
                new KitHandlerInventory(player);
            }
        }
    }
}
