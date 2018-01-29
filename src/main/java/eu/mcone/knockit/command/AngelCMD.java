package eu.mcone.knockit.command;

import eu.mcone.bukkitcoresystem.CoreSystem;
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
            if (!CoreSystem.getInstance().getCooldownSystem().canExecute(this.getClass(), p)) return true;
            CoreSystem.getInstance().getCooldownSystem().addPlayer(p.getUniqueId(), this.getClass());

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
