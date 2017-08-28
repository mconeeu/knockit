package KnockbackFFA.Listener.de;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import KnockbackFFA.Hologramm.de.PlayerHoloListener;
import KnockbackFFA.Main.de.KnockFFA;

public class LISTENER_Quit
  implements Listener
{
  @EventHandler
  public void onQuit(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    
    e.setQuitMessage(KnockFFA.pr + "§7§ " + p.getDisplayName() + " §7hat das Spiel verlassen");
    for(Player p1 : Bukkit.getOnlinePlayers()){
  		PlayerHoloListener.Holo(p1);
  	  }
    KnockFFA.main.utils.clearPlayer(p);
    KnockFFA.main.ingame.remove(p);
  }
}
