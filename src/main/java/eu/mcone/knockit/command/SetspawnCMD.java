/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.command;

import eu.mcone.coresystem.bukkit.CoreSystem;
import eu.mcone.coresystem.bukkit.util.LocationFactory;
import eu.mcone.knockit.KnockIT;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetspawnCMD implements CommandExecutor {
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(sender instanceof Player) {
            final Player p = (Player) sender;
            if (!CoreSystem.getInstance().getCooldownSystem().canExecute(this.getClass(), p)) return true;
            CoreSystem.getInstance().getCooldownSystem().addPlayer(p.getUniqueId(), this.getClass());

            if (p.hasPermission("knockit.spawn.set")) {
                if (args.length == 0) {
                    LocationFactory.updateConfigLocation(p.getLocation(), KnockIT.config, "Location-Spawn");
                    p.sendMessage(KnockIT.config.getConfigValue("System-Prefix") + "§7Der Spawn wurde erfolgreich gesetzt!");
                } else {
                    p.sendMessage(KnockIT.config.getConfigValue("System-Prefix") + "");
                }
            } else {
                p.sendMessage(KnockIT.config.getConfigValue("System-Prefix") + "§4Du hast keine Berechtigung für diesen Befehl!");
            }
        } else {
            sender.sendMessage(KnockIT.config.getConfigValue("System-Prefix") + KnockIT.config.getConfigValue("System-Konsolen-Sender"));
        }

        return true;
    }

}
