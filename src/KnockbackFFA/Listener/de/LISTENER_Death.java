package KnockbackFFA.Listener.de;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import KnockbackFFA.Command.de.CMD_spectate;
import KnockbackFFA.Hologramm.de.PlayerHoloListener;
import KnockbackFFA.Main.de.KnockFFA;
import me.BukkitCoreSystem.API.de.CoinsAPI;
import me.BukkitCoreSystem.API.de.StatsAPI;

public class LISTENER_Death implements Listener{
  @EventHandler
  public void onDeath(PlayerDeathEvent e){
    try{
      final Player p = e.getEntity();
      Player k = p.getKiller();
      
      e.setDeathMessage(null);
      e.getDrops().clear();
      if (k != null){
        k.sendMessage(KnockFFA.main.pr + "§7Du hast " + p.getDisplayName() + " §7getötet");
        k.sendMessage(KnockFFA.sy + "§7Du hast §f1 §7Coin erhalten");
        StatsAPI.addKills(k.getPlayer().getUniqueId().toString(), k.getName(), 1);
        CoinsAPI.addCoins(k.getPlayer(), 1);
        KnockFFA.playSound(k.getLocation(), Sound.LEVEL_UP);
        for(Player p1 : Bukkit.getOnlinePlayers()){
    		PlayerHoloListener.Holo(p1);
    	}
        
        p.sendMessage(KnockFFA.main.pr + "§7Du wurdest von §c" + k.getDisplayName() + " §7getötet");
        StatsAPI.addDeaths(p.getPlayer().getUniqueId().toString(), p.getName(), 1);
        
        int coins2 = CoinsAPI.getCoins(p) - 1;
		 if(coins2 <= -1){
			 for(Player p1 : Bukkit.getOnlinePlayers()){
		    		PlayerHoloListener.Holo(p1);
		    	}
		 }else{
			 CoinsAPI.removeCoins(p.getPlayer(), 1); 
			 p.sendMessage(KnockFFA.sy + "§7Dir wurde §f1 §7Coin abgezogen");
			 for(Player p1 : Bukkit.getOnlinePlayers()){
		    		PlayerHoloListener.Holo(p1);
		    	}
		 }
        KnockFFA.playSound(p.getLocation(), Sound.ANVIL_LAND);
        for(Player p1 : Bukkit.getOnlinePlayers()){
    		PlayerHoloListener.Holo(p1);
    	}
        
        k.setLevel(k.getLevel() + 1);
        KnockFFA.main.utils.clearPlayer(p);
      }else{
        p.sendMessage(KnockFFA.main.pr + "§7Du bist gestorben");
        KnockFFA.playSound(p.getLocation(), Sound.ANVIL_LAND);
        KnockFFA.main.utils.clearPlayer(p);
    	PlayerHoloListener.Holo(p);
      }
      
      if (CMD_spectate.vanish.contains(p.getName())){
        CMD_spectate.vanish.remove(p.getName());
        KnockFFA.main.ingame.add(p);
        KnockFFA.main.utils.clearPlayer(p);
        p.sendMessage(KnockFFA.main.sy + "§7Der §eSpectator-Modus §7wurde §cdeaktiviert");
        p.setFlying(false);
        p.setAllowFlight(false);
        for (Player all : Bukkit.getOnlinePlayers()) {
          all.showPlayer(p);
        }
      }
      Bukkit.getScheduler().scheduleSyncDelayedTask(KnockFFA.main, new Runnable(){
        public void run(){
          p.spigot().respawn();
          for (Player all : Bukkit.getOnlinePlayers()) {
        	  PlayerHoloListener.Holo(all);
            }
        }
      }, 6L);
    }
    catch (Exception localException) {}
  }
}
