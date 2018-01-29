package eu.mcone.knockit.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

    @EventHandler
    public void on(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        
    }

}
