package eu.mcone.knockit.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItem implements Listener {

    @EventHandler
    public void on(PlayerDropItemEvent e)
    {
    e.setCancelled(true);
    }

}
