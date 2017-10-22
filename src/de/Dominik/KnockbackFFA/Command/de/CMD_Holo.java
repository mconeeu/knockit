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

public class CMD_Holo implements CommandExecutor{
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	    Player p = (Player)sender;
	    if(cmd.getName().equalsIgnoreCase("setholo")){
	    	if (p.hasPermission("system.knockbackffa.setholo") || p.hasPermission("system.knockbackffa.*") || p.hasPermission("system.*")) {
	    		p.sendMessage(KnockFFA.pr + "§7Du hast das §eHologramm §7gesetzt");
	    		API_Location.setLocation("holo", p);
	    	}
	    }
		return true;
	  }
}
