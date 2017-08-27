package KnockbackFFA.Listener.de;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class LISTENER_Drop
  implements Listener
{
  @EventHandler
  public void onDrop(PlayerDropItemEvent e)
  {
    e.setCancelled(true);
  }
}
