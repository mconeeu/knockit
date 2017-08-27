package KnockbackFFA.Manager.de;

import org.bukkit.entity.Player;

import KnockbackFFA.api.de.API_Location;

public class Methods
{
  public static void TPtoMap(Player p)
  {
    p.teleport(API_Location.getLocation("spawn"));
  }
}
