package eu.mcone.knockit.listener;

import eu.mcone.knockit.KnockIT;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class MlgBlockListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();

        if (!KnockIT.getInstance().getBuildSystem().hasBuildModeEnabled(p) && e.getBlock().getType().equals(Material.QUARTZ_BLOCK)) {
            Block block = e.getBlockPlaced();

            Bukkit.getScheduler().runTaskLater(
                    KnockIT.getInstance(),
                    () -> block.setType(Material.AIR),
                    60
            );
        }

    }

}
