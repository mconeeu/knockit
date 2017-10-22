package de.Dominik.KnockbackFFA.Listener.de;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

import de.Dominik.BukkitCoreSystem.Main.Main;
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

public class LISTENER_Killstreak implements Listener{
	
  static de.Dominik.BukkitCoreSystem.API.CoinsAPI CoinsAPI = new de.Dominik.BukkitCoreSystem.API.CoinsAPI("KnockbackFFA", Main.mysql2);
	
  @EventHandler
  public void onLevelChange(PlayerLevelChangeEvent e){
    Player p = e.getPlayer();
    try{
      if (e.getNewLevel() == 3){
        for (Player all : Bukkit.getOnlinePlayers()){
          all.sendTitle("§a3er Killstreak", "§fvon " + p.getDisplayName());
          p.sendMessage(KnockFFA.sy + "§7Du hast §a3 §7Coins erhalten");
          CoinsAPI.addCoins(p.getPlayer(), 3);
          all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
          for(Player p1 : Bukkit.getOnlinePlayers()){
      		PlayerHoloListener.Holo(p1);
      	 }
        }
        Bukkit.broadcastMessage(
          KnockFFA.main.pr + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §a3er Killstreak!");
        return;
      }else if (e.getNewLevel() == 6){
        for (Player all : Bukkit.getOnlinePlayers()){
          all.sendTitle("§66er Killstreak", "§fvon " + p.getDisplayName());
          p.sendMessage(KnockFFA.sy + "§7Du hast §a3 §7Coins erhalten");
          CoinsAPI.addCoins(p.getPlayer(), 3);
          all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
          for(Player p1 : Bukkit.getOnlinePlayers()){
      		PlayerHoloListener.Holo(p1);
      	 }
        }
        Bukkit.broadcastMessage(
          KnockFFA.main.pr + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §66er Killstreak!");
        return;
      }else if (e.getNewLevel() == 9){
        for (Player all : Bukkit.getOnlinePlayers())
        {
          all.sendTitle("§c9er Killstreak", "§fvon " + p.getDisplayName());
          p.sendMessage(KnockFFA.sy + "§7Du hast §a3 §7Coins erhalten");
          CoinsAPI.addCoins(p.getPlayer(), 3);
          all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
          for(Player p1 : Bukkit.getOnlinePlayers()){
      		PlayerHoloListener.Holo(p1);
      	  }
        }
        Bukkit.broadcastMessage(
          KnockFFA.main.pr + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §c9er Killstreak!");
        return;
      }else if (e.getNewLevel() == 12){
        for (Player all : Bukkit.getOnlinePlayers())
        {
          all.sendTitle("§412er Killstreak", "§fvon " + p.getDisplayName());
          p.sendMessage(KnockFFA.sy + "§7Du hast §a3 §7Coins erhalten");;
          CoinsAPI.addCoins(p.getPlayer(), 3);
          all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
          for(Player p1 : Bukkit.getOnlinePlayers()){
      		PlayerHoloListener.Holo(p1);
      	  }
        }
        Bukkit.broadcastMessage(
          KnockFFA.main.pr + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §412er Killstreak!");
        return;
        }else if (e.getNewLevel() == 15){
        for (Player all : Bukkit.getOnlinePlayers())
        {
          all.sendTitle("§415er Killstreak", "§fvon " + p.getDisplayName());
          p.sendMessage(KnockFFA.sy + "§7Du hast §a3 §7Coins erhalten");
          CoinsAPI.addCoins(p.getPlayer(), 3);
          all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
          for(Player p1 : Bukkit.getOnlinePlayers()){
      		PlayerHoloListener.Holo(p1);
      	  }
        }
        Bukkit.broadcastMessage(
          KnockFFA.main.pr + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §415er Killstreak!");
        return;
      }else if (e.getNewLevel() == 18){
        for (Player all : Bukkit.getOnlinePlayers())
        {
          all.sendTitle("§518er Killstreak", "§fvon " + p.getDisplayName());
          all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
          p.sendMessage(KnockFFA.sy + "§7Du hast §a6 §7Coins erhalten");
          CoinsAPI.addCoins(p.getPlayer(), 6);
          for(Player p1 : Bukkit.getOnlinePlayers()){
      		PlayerHoloListener.Holo(p1);
      	 }
        }
        Bukkit.broadcastMessage(
          KnockFFA.main.pr + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §518er Killstreak!");
        return;
      }else if (e.getNewLevel() == 21){
        for (Player all : Bukkit.getOnlinePlayers())
        {
          all.sendTitle("§521er Killstreak", "§fvon " + p.getDisplayName());
          all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
          p.sendMessage(KnockFFA.sy + "§7Du hast §a6 §7Coins erhalten");
          CoinsAPI.addCoins(p.getPlayer(), 6);
          for(Player p1 : Bukkit.getOnlinePlayers()){
      		PlayerHoloListener.Holo(p1);
      	}
        }
        Bukkit.broadcastMessage(
          KnockFFA.main.pr + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §521er Killstreak!");
        return;
      }else if (e.getNewLevel() == 24){
        for (Player all : Bukkit.getOnlinePlayers()){
          all.sendTitle("§124er Killstreak", "§fvon " + p.getDisplayName());
          all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
          p.sendMessage(KnockFFA.sy + "§7Du hast §a6 §7Coins erhalten");
          CoinsAPI.addCoins(p.getPlayer(), 6);
        }
        Bukkit.broadcastMessage(
          KnockFFA.main.pr + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §124er Killstreak!");
        return;
      }else if (e.getNewLevel() == 27){
        for (Player all : Bukkit.getOnlinePlayers())
        {
          all.sendTitle("§b27er Killstreak", "§fvon " + p.getDisplayName());
          all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
          p.sendMessage(KnockFFA.sy + "§7Du hast §a6 §7Coins erhalten");
          CoinsAPI.addCoins(p.getPlayer(), 6);
          for(Player p1 : Bukkit.getOnlinePlayers()){
      		PlayerHoloListener.Holo(p1);
      	 }
        }
        Bukkit.broadcastMessage(
          KnockFFA.main.pr + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §b27er Killstreak!");
        return;
      }else if (e.getNewLevel() == 30){
        for (Player all : Bukkit.getOnlinePlayers())
        {
          all.sendTitle("§030er Killstreak", "§fvon " + p.getDisplayName());
          p.sendMessage(KnockFFA.sy + "§7Du hast §a6 §7Coins erhalten");
          all.getLocation().getWorld().playSound(all.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
          CoinsAPI.addCoins(p.getPlayer(), 6);
          for(Player p1 : Bukkit.getOnlinePlayers()){
      		PlayerHoloListener.Holo(p1);
      	  }
        }
        Bukkit.broadcastMessage(
          KnockFFA.main.pr + "§7Der Spieler §e" + p.getDisplayName() + " §7hat eine §030er Killstreak!");
        return;
      }
    }catch (Exception e1){
      e1.getMessage();
    }
  }
}
