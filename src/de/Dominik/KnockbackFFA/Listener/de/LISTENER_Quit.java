package de.Dominik.KnockbackFFA.Listener.de;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.Dominik.KnockbackFFA.Hologramm.de.PlayerHoloListener;
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

public class LISTENER_Quit
  implements Listener
{
  @EventHandler
  public void onQuit(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    
    e.setQuitMessage(KnockFFA.pr + "§7 " + p.getDisplayName() + " §7hat das Spiel verlassen");
    for(Player p1 : Bukkit.getOnlinePlayers()){
  		PlayerHoloListener.Holo(p1);
  	  }
    KnockFFA.main.utils.clearPlayer(p);
    KnockFFA.main.ingame.remove(p);
  }
}
