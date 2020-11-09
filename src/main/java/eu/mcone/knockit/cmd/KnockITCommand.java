/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.cmd;

import eu.mcone.coresystem.api.bukkit.command.CoreCommand;
import eu.mcone.knockit.KnockIT;
import org.bukkit.command.CommandSender;

public class KnockITCommand extends CoreCommand {

    public KnockITCommand() {
        super("knockit");
    }

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        KnockIT.getInstance().getMessenger().sendSender(sender, "§8§m---------- §r§a§lMCONE-KnockIT §8§m----------");
        KnockIT.getInstance().getMessenger().sendSender(sender, "§7Entwickelt von fMarvio, §fDiserDominik und §fRufi");
        KnockIT.getInstance().getMessenger().sendSender(sender, "§r");
        KnockIT.getInstance().getMessenger().sendSender(sender, "§7§oWir bemühen uns darum alle Systeme und Spielmodi so effizient wie möglich zu gestalten.");
        KnockIT.getInstance().getMessenger().sendSender(sender, "§7§oDeshalb sind auch alle von uns verwendeten Plugins ausschließlich selbst entwickelt!");
        KnockIT.getInstance().getMessenger().sendSender(sender, "§8§m---------- §r§a§lMCONE-KnockIT §8§m----------");

        return true;
    }
}
