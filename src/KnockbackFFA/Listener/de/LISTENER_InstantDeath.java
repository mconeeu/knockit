package KnockbackFFA.Listener.de;

import java.io.File;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import KnockbackFFA.Main.de.KnockFFA;

public class LISTENER_InstantDeath
  implements Listener
{
  @EventHandler
  public void onMove(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    double y = p.getLocation().getY();
    File file = new File("plugins/" + KnockFFA.main.getName(), "deathborder.yml");
    if (!file.exists()) {
      return;
    }
    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    if ((y < cfg.getDouble("deathborder.y")) && (!p.isDead()))
    {
      p.setHealth(0.0D);
      e.setCancelled(true);
    }
  }
}
