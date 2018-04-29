/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.command;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.knockit.KnockIT;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AngelCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!CoreSystem.getInstance().getCooldownSystem().addAndCheck(CoreSystem.getInstance(), this.getClass(), p.getUniqueId())) return false;

            if (p.hasPermission("knockit.angel")) {
                if (KnockIT.config.getBooleanConfigValue("Item-Angel")) {
                    KnockIT.config.updateMySQLConfig("Item-Angel", false);
                    Bukkit.broadcastMessage(KnockIT.config.getConfigValue("System-Prefix") + "§cDie §eAngel §cwurde von §e" + p.getName() + " §cDEAKTIVIERT");
                } else {
                    KnockIT.config.updateMySQLConfig("Item-Angel", true);
                    Bukkit.broadcastMessage(KnockIT.config.getConfigValue("System-Prefix") + "§cDie §eAngel §cwurde von §e" + p.getName() + " §aAKTIVIERT");
                }
            }
        }
        return false;
    }

}
