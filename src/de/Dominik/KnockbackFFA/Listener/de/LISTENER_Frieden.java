package de.Dominik.KnockbackFFA.Listener.de;

import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

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

public class LISTENER_Frieden
  implements Listener
{
  @EventHandler
  public void onMove(EntityDamageByEntityEvent e)
  {
    try
    {
      Player p = (Player)e.getEntity();
      double y = p.getLocation().getY();
      File file = new File("plugins/" + KnockFFA.main.getName(), "frieden.yml");
      if (!file.exists()) {
        return;
      }
      YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
      if (y > cfg.getDouble("frieden.y")) {
        e.setCancelled(true);
      }
    }
    catch (Exception e1)
    {
      e1.getMessage();
    }
  }
}
