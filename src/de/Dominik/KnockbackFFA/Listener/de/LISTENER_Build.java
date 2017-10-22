package de.Dominik.KnockbackFFA.Listener.de;

import java.io.File;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;

import de.Dominik.KnockbackFFA.Command.de.CMD_build;
import de.Dominik.KnockbackFFA.Main.de.KnockFFA;

/**
 * 
 * @author Dominik Lippl ©
 * 
 * @copyright You do not have the permission to decompile this plugin ©
 * @copyright All right are at the developer with me: Dominik Lippl ©
 * @copyright You can not change the source code ©
 *
 */

public class LISTENER_Build
  implements Listener
{
  @EventHandler
  public void onBreak(BlockBreakEvent e)
  {
    if (!CMD_build.allow.contains(e.getPlayer())) {
      e.setCancelled(true);
    } else {
      e.setCancelled(false);
    }
  }
  
  @EventHandler
  public void onPlace(final BlockPlaceEvent e)
  {
    Player p = e.getPlayer();
    double y = p.getLocation().getY();
    File file = new File("plugins/" + KnockFFA.main.getName(), "frieden.yml");
    if (!file.exists()) {
      return;
    }
    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    if (!CMD_build.allow.contains(e.getPlayer())) {
      e.setCancelled(true);
    }
    if (y < cfg.getDouble("frieden.y"))
    {
      if (!CMD_build.allow.contains(e.getPlayer()))
      {
        if (e.getBlock().getType() == Material.QUARTZ_BLOCK) {
          e.setCancelled(false);
        }
        new BukkitRunnable()
        {
          public void run()
          {
            if (e.getBlock().getType() == Material.QUARTZ_BLOCK) {
              e.getBlock().setType(Material.AIR);
            }
          }
        }.runTaskLater(KnockFFA.main, 60L);
      }
    }
    else if (y > cfg.getDouble("frieden.y")) {
      if (CMD_build.allow.contains(e.getPlayer())) {
        e.setCancelled(false);
      } else {
        e.setCancelled(true);
      }
    }
  }
}
