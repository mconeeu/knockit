package KnockbackFFA.Command.de;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import KnockbackFFA.Main.de.KnockFFA;
import KnockbackFFA.api.de.API_Location;

public class CMD_setspawn implements CommandExecutor{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    Player p = (Player)sender;
    if (p.hasPermission("system.admin")){
      if (args.length != 0){
        p.sendMessage(KnockFFA.main.pr + "§7Benutze §e/setspawn");
        return true;
      }
      try{
        API_Location.setLocation("spawn", p);
        p.sendMessage(KnockFFA.main.pr + "§7Du hast den §eSpawn §7gesetzt");
      }catch (Exception e){
        p.sendMessage(KnockFFA.main.pr + "§cBei der Speicherung einer Location (Spawn- Lobby) ist etwas schief gelaufen! Kontaktiere den §bDeveloper §c- §bxXTwinsterHDXx");
      }
    }else{
      p.sendMessage(KnockFFA.main.noPermission);
    }
    return true;
  }
}
