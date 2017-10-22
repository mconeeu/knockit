package de.Dominik.KnockbackFFA.Command.de;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Dominik.KnockbackFFA.Main.de.KnockFFA;
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

public class CMD_setspawn implements CommandExecutor{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    Player p = (Player)sender;
    if (p.hasPermission("system.knockbackffa.setspawn") || p.hasPermission("system.knockbackffa.*") || p.hasPermission("system.*")) {
      if (args.length != 0){
        p.sendMessage(KnockFFA.main.pr + "§7Benutze §e/setspawn");
        return true;
      }
      try{
        API_Location.setLocation("spawn", p);
        p.sendMessage(KnockFFA.main.pr + "§7Du hast den §eSpawn §7gesetzt");
      }catch (Exception e){
        p.sendMessage(KnockFFA.main.pr + "§cBei der Speicherung einer Location (Spawn- Lobby) ist etwas schief gelaufen! Kontaktiere den §bDeveloper §c- §bTwinsterHD");
      }
    }else{
      p.sendMessage(KnockFFA.main.noPermission);
    }
    return true;
  }
}
