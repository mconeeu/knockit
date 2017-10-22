package de.Dominik.KnockbackFFA.Command.de;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

public class CMD_angel implements CommandExecutor{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    Player p = (Player)sender;
    if (p.hasPermission("system.knockbackffa.angel") || p.hasPermission("system.knockbackffa.*") || p.hasPermission("system.*")) {
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
