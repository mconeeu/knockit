package de.Dominik.KnockbackFFA.Listener.de;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.util.Vector;

/**
 * 
 * @author Dominik Lippl ©
 * 
 * @copyright You do not have the permission to decompile this plugin ©
 * @copyright All right are at the developer with me: Dominik Lippl ©
 * @copyright You can not change the source code ©
 *
 */

public class LISTENER_Enterhaken
  implements Listener
{
  @EventHandler
  public void onPlayerFish(PlayerFishEvent e)
  {
    try
    {
      Player p = e.getPlayer();
      Fish h = e.getHook();
      if (((e.getState().equals(PlayerFishEvent.State.IN_GROUND)) || 
        (e.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY)) || 
        (e.getState().equals(PlayerFishEvent.State.FAILED_ATTEMPT))) && 
        (p.getItemInHand().getItemMeta().getDisplayName().equals("§8§ §7Enterhaken (Rechtsklick)")) && 
        (Bukkit.getWorld(e.getPlayer().getWorld().getName())
        .getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1, 
        h.getLocation().getBlockZ())
        .getType() != Material.AIR)) {
        if (Bukkit.getWorld(e.getPlayer().getWorld().getName())
          .getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1, 
          h.getLocation().getBlockZ())
          .getType() != Material.STATIONARY_WATER)
        {
          Location lc = p.getLocation();
          Location to = e.getHook().getLocation();
          
          lc.setY(lc.getY() + 0.5D);
          p.teleport(lc);
          
          double g = -0.08D;
          double d = to.distance(lc);
          double t = d;
          double v_x = (1.0D + 0.07D * t) * (to.getX() - lc.getX()) / t;
          double v_y = (1.0D + 0.03D * t) * (to.getY() - lc.getY()) / t - 0.5D * g * t;
          double v_z = (1.0D + 0.07D * t) * (to.getZ() - lc.getZ()) / t;
          
          Vector v = p.getVelocity();
          v.setX(v_x);
          v.setY(v_y);
          v.setZ(v_z);
          p.setVelocity(v);
        }
      }
    }
    catch (Exception localException) {}
  }
}
