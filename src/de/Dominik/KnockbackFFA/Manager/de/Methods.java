package de.Dominik.KnockbackFFA.Manager.de;

import org.bukkit.entity.Player;

import de.Dominik.KnockbackFFA.api.de.API_Location;

/**
 * 
 * @author Dominik Lippl ©
 * 
 * @copyright You do not have the permission to decompile this plugin ©
 * @copyright All right are at the developer with me: Dominik Lippl ©
 * @copyright You can not change the source code ©
 *
 */

public class Methods
{
  public static void TPtoMap(Player p)
  {
    p.teleport(API_Location.getLocation("spawn"));
  }
}
