package de.Dominik.KnockbackFFA.Listener.de;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * 
 * @author Dominik Lippl ©
 * 
 * @copyright You do not have the permission to decompile this plugin ©
 * @copyright All right are at the developer with me: Dominik Lippl ©
 * @copyright You can not change the source code ©
 *
 */

public class LISTENER_FallDamage
  implements Listener
{
  @EventHandler
  public void onDamage(EntityDamageEvent e)
  {
    e.setDamage(0.0D);
    if (!(e.getEntity() instanceof Player)) {
      return;
    }
    if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
      e.setCancelled(true);
    }
  }
}
