/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.cmd;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import eu.mcone.knockit.KnockIT;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class KnockITCommand extends CorePlayerCommand {

    public static List<Player> setup = new ArrayList<>();

    public KnockITCommand() {
        super("knockit");
    }

    @Override
    public boolean onPlayerCommand(Player player, String[] args) {
        if (args.length == 0) {
            KnockIT.getInstance().getMessager().send(player, "§8§m---------- §r§a§lMCONE-KnockIT §8§m----------");
            KnockIT.getInstance().getMessager().send(player, "§7Entwickelt von §fTwinsterHD, §fDrMarv und §fRufi");
            KnockIT.getInstance().getMessager().send(player, "§r");
            KnockIT.getInstance().getMessager().send(player, "§7§oWir bemühen uns darum alle Systeme und Spielmodi so effizient wie möglich zu gestalten.");
            KnockIT.getInstance().getMessager().send(player, "§7§oDeshalb sind auch alle von uns verwendeten Plugins ausschließlich selbst entwickelt!");
            KnockIT.getInstance().getMessager().send(player, "§8§m---------- §r§a§lMCONE-KnockIT §8§m----------");
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("help")) {
                KnockIT.getInstance().getMessager().send(player, "§8§m---------- §r§a§lMCONE-KnockIT §8§m----------");
                KnockIT.getInstance().getMessager().send(player, "§7/knockit set spawnHigh | Setzt die Schutzhöhe");
                KnockIT.getInstance().getMessager().send(player, "§7/knockit set deathHigh | Setzte die Todeshöhe");
                KnockIT.getInstance().getMessager().send(player, "§8§m---------- §r§a§lMCONE-KnockIT §8§m----------");
            } else if (args[0].equalsIgnoreCase("setup")) {
                if (player.hasPermission("knockit.setup")) {
                    if (setup.contains(player)) {
                        setup.remove(player);
                        KnockIT.getInstance().getMessager().send(player, "§cDu bist nun nicht mehr im Setup");
                    } else {
                        setup.add(player);
                        KnockIT.getInstance().getMessager().send(player, "§2Du bist nun im Setup modus!");
                    }
                } else {
                    KnockIT.getInstance().getMessager().send(player, "§cDu hast keine Permissions für /knockit setup");
                }
            }
        } else if (args.length == 2) {
            if (player.hasPermission("knockit.setup")) {
                if (args[0].equalsIgnoreCase("set")) {
                    if (args[1].equalsIgnoreCase("spawnHigh")) {
                        CoreSystem.getInstance().getWorldManager().getWorld(player.getWorld()).setLocation("spawnHigh", player.getLocation()).save();
                        KnockIT.getInstance().getMessager().send(player, "§aDu hast die Schutzhöhe auf §7§o" + Math.round(player.getLocation().getY()) + " §agesetzt.");
                    } else if (args[1].equalsIgnoreCase("deathHigh")) {
                        CoreSystem.getInstance().getWorldManager().getWorld(player.getWorld()).setLocation("deathHigh", player.getLocation()).save();
                        KnockIT.getInstance().getMessager().send(player, "§aDu hast die Todeshöhe auf §7§o" + Math.round(player.getLocation().getY()) + " §agesetzt.");
                    } else {
                        KnockIT.getInstance().getMessager().send(player, "§cBitte benutze /knockit set {spawnHigh/deathHigh}");
                    }
                }
            } else {
                KnockIT.getInstance().getMessager().send(player, "§cDu hast keine Permissions für diesen Command!");
            }
        } else {
            KnockIT.getInstance().getMessager().send(player, "§cBitte benutze /knockit help");
        }

        return false;
    }
}
