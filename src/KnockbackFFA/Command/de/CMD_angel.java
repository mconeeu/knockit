package KnockbackFFA.Command.de;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import KnockbackFFA.Main.de.KnockFFA;

public class CMD_angel implements CommandExecutor{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    Player p = (Player)sender;
    if (p.hasPermission("system.admin")) {
      if (KnockFFA.getAngel()){
        KnockFFA.setAngel(false);
        Bukkit.broadcastMessage(
          KnockFFA.main.sy + "§cDie §eAngel §cwurde von §e" + p.getName() + " §cDEAKTIVIERT");
      }else{
        KnockFFA.setAngel(true);
        Bukkit.broadcastMessage(
          KnockFFA.main.sy + "§cDie §eAngel §cwurde von §e" + p.getName() + " §aAKTIVIERT");
      }
    }
    return false;
  }
}
