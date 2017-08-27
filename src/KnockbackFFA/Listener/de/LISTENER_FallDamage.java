package KnockbackFFA.Listener.de;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

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
