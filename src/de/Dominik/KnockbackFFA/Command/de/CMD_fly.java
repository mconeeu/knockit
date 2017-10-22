package de.Dominik.KnockbackFFA.Command.de;

import java.util.ArrayList;
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

public class CMD_fly implements CommandExecutor{
  public static ArrayList<Player> fly = new ArrayList();
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    Player p = (Player)sender;
    if (p.hasPermission("system.knockbackffa.fly") || p.hasPermission("system.knockbackffa.*") || p.hasPermission("system.*")) {
      if (p.getAllowFlight()){
        p.setFlying(false);
        p.setAllowFlight(false);
        p.sendMessage(KnockFFA.main.sy + "§7Du du bist nun nicht mehr im §eFlymode");
      }else{
        p.setAllowFlight(true);
        p.sendMessage(KnockFFA.main.sy + "§7Du du bist nun im §eFlymode");
      }
    }else{
      p.sendMessage(KnockFFA.main.noPermission);
    }
    return false;
  }
}
