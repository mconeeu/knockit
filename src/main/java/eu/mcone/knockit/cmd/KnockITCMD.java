/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.cmd;

import eu.mcone.coresystem.api.bukkit.command.CoreCommand;
import eu.mcone.knockit.KnockIT;
import org.bukkit.command.CommandSender;

public class KnockITCMD extends CoreCommand {

    public KnockITCMD() {
        super("knockit");
    }

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        KnockIT.getInstance().getMessenger().sendSimple(sender, "§8§m---------- §r§a§lMCONE-KnockIT §8§m----------" +
                "\n§7Entwickelt von §fMarvio§7, §frufi§7 und §fDiserDominik" +
                "\n§r" +
                "\n§7§oWir bemühen uns darum alle Systeme und Spielmodi so effizient wie möglich zu gestalten." +
                "\n§7§oDeshalb sind auch alle von uns verwendeten Plugins ausschließlich selbst entwickelt!" +
                "\n§8§m---------- §r§a§lMCONE-KnockIT §8§m----------");
        return true;
    }
}
