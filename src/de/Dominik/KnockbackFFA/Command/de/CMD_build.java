package de.Dominik.KnockbackFFA.Command.de;

import java.util.ArrayList;
import org.bukkit.GameMode;
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

public class CMD_build implements CommandExecutor{
  public static ArrayList<Player> allow = new ArrayList();
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    Player p = (Player)sender;
    if (p.hasPermission("system.knockbackffa.build") || p.hasPermission("system.knockbackffa.*") || p.hasPermission("system.*")) {
      if (allow.contains(p)){
        allow.remove(p);
        p.sendMessage(KnockFFA.main.sy + "§7Du kannst nun nicht mehr §ebauen");
        p.setGameMode(GameMode.SURVIVAL);
      }else{
        allow.add(p);
        p.sendMessage(KnockFFA.main.sy + "§7Du kannst nun §ebauen");
        p.setGameMode(GameMode.CREATIVE);
      }
    }else{
      p.sendMessage(KnockFFA.main.noPermission);
    }
    return false;
  }
}
