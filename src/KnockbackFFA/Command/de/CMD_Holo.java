package KnockbackFFA.Command.de;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import KnockbackFFA.Main.de.KnockFFA;
import KnockbackFFA.api.de.API_Location;

public class CMD_Holo implements CommandExecutor{
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	    Player p = (Player)sender;
	    if(cmd.getName().equalsIgnoreCase("setholo")){
	    	if(p.hasPermission("system.admin")){
	    		p.sendMessage(KnockFFA.pr + "§7Du hast das §eHologramm §7gesetzt");
	    		API_Location.setLocation("holo", p);
	    	}
	    }
		return true;
	  }
}
