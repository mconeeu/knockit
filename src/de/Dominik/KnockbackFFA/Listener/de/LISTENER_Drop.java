package de.Dominik.KnockbackFFA.Listener.de;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

/**
 * 
 * @author Dominik Lippl ©
 * 
 * @copyright You do not have the permission to decompile this plugin ©
 * @copyright All right are at the developer with me: Dominik Lippl ©
 * @copyright You can not change the source code ©
 *
 */

public class LISTENER_Drop
  implements Listener
{
  @EventHandler
  public void onDrop(PlayerDropItemEvent e)
  {
    e.setCancelled(true);
  }
}
