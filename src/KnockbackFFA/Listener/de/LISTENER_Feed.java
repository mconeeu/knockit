package KnockbackFFA.Listener.de;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class LISTENER_Feed
  implements Listener
{
  @EventHandler
  public void onLoseFeed(FoodLevelChangeEvent e)
  {
    e.setCancelled(true);
  }
}
