package eu.mcone.knockit.listener;

import eu.mcone.knockit.KnockIT;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {

    @EventHandler
    public void on(final BlockPlaceEvent e) {
        Player p = e.getPlayer();

        if (p.getGameMode().equals(GameMode.CREATIVE)) {
            e.setCancelled(false);
        } else if (e.getBlockPlaced().getType().equals(Material.QUARTZ_BLOCK) && p.getLocation().getY() < 80) {
            Bukkit.getScheduler().runTaskLater(KnockIT.getInstance(), () -> {
                if (e.getBlock().getType() == Material.QUARTZ_BLOCK) {
                    e.getBlock().setType(Material.AIR);
                }
            }, 60L);
        } else {
            e.setCancelled(true);
        }
    }

}
