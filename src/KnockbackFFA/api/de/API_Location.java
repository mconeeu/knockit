package KnockbackFFA.api.de;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import KnockbackFFA.Main.de.KnockFFA;

public class API_Location{
  public static void setLocation(String LocationName, Player p)
  {
    KnockFFA.main.getConfig().set(LocationName + ".X", Integer.valueOf(p.getLocation().getBlockX()));
    KnockFFA.main.getConfig().set(LocationName + ".Y", Integer.valueOf(p.getLocation().getBlockY()));
    KnockFFA.main.getConfig().set(LocationName + ".Z", Integer.valueOf(p.getLocation().getBlockZ()));
    KnockFFA.main.getConfig().set(LocationName + ".Yaw", Float.valueOf(p.getLocation().getYaw()));
    KnockFFA.main.getConfig().set(LocationName + ".Pitch", Float.valueOf(p.getLocation().getPitch()));
    KnockFFA.main.getConfig().set(LocationName + ".World", p.getWorld().getName());
    
    KnockFFA.main.saveConfig();
  }
  
  @SuppressWarnings("unused")
public static Location getLocation(String LocationName)
  {
    double x = KnockFFA.main.getConfig().getDouble(LocationName + ".X");
    double y = KnockFFA.main.getConfig().getDouble(LocationName + ".Y");
    double z = KnockFFA.main.getConfig().getDouble(LocationName + ".Z");
    double yaw = KnockFFA.main.getConfig().getDouble(LocationName + ".Yaw");
    double pitch = KnockFFA.main.getConfig().getDouble(LocationName + ".Pitch");
    String World = KnockFFA.main.getConfig().getString(LocationName + ".World");
    World w = Bukkit.getWorld(World);
    Location l = new Location(w, x, y, z);
    return l;
  }
}
