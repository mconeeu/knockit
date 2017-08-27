package KnockbackFFA.Listener.de;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import KnockbackFFA.Command.de.CMD_spectate;

public class EVENT_Vanish
  implements Listener
{
  @EventHandler
  public void onDamage(EntityDamageByEntityEvent e)
  {
    try
    {
      Player p = (Player)e.getEntity();
      if (CMD_spectate.vanish.contains(p.getName())) {
        e.setCancelled(true);
      } else {
        e.setCancelled(false);
      }
    }
    catch (Exception localException) {}
  }
  
  @EventHandler
  public void onLoseFeed(FoodLevelChangeEvent e)
  {
    Player p = (Player)e.getEntity();
    if (CMD_spectate.vanish.contains(p.getName())) {
      e.setCancelled(true);
    } else {
      e.setCancelled(false);
    }
  }
  
  @EventHandler
  public void onJoin(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    for (Player all : Bukkit.getOnlinePlayers()) {
      if (CMD_spectate.vanish.contains(all.getName())) {
        p.hidePlayer(all);
      }
    }
  }
}
