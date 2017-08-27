package KnockbackFFA.Command.de;

import java.io.File;
import java.io.IOException;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import KnockbackFFA.Main.de.KnockFFA;

public class CMD_setdeathborder
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (!p.hasPermission("system.admin")) {
      return true;
    }
    File file = new File("plugins/" + KnockFFA.main.getName(), "deathborder.yml");
    if (!file.exists()) {
      try
      {
        file.createNewFile();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    Location loc = p.getLocation();
    
    double y = p.getLocation().getY();
    String weltname = loc.getWorld().getName();
    cfg.set("deathborder.y", Double.valueOf(y));
    cfg.set("deathborder.world", weltname);
    
    p.sendMessage(KnockFFA.main.pr + "§7Absofort stirbt man ab dieser §aHöhe");
    try
    {
      cfg.save(file);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return false;
  }
}
