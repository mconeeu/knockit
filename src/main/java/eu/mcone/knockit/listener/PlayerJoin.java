package eu.mcone.knockit.listener;

import eu.mcone.bukkitcoresystem.CoreSystem;
import eu.mcone.bukkitcoresystem.player.CorePlayer;
import eu.mcone.bukkitcoresystem.util.ItemFactory;
import eu.mcone.bukkitcoresystem.util.LocationFactory;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.util.Objective;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent e){
        Player p = e.getPlayer();
        CorePlayer cp = CoreSystem.getCorePlayer(p);

        e.setJoinMessage(KnockIT.config.getConfigValue("System-Prefix") + "§7§ " + p.getDisplayName() + " §7ist dem Spiel beigetreten");

        p.getInventory().clear();
        p.setHealth(20.0D);
        p.setLevel(0);
        p.setGameMode(GameMode.SURVIVAL);

        p.getInventory().setItem(0, ItemFactory.createEnchantedItem(Material.STICK, Enchantment.KNOCKBACK, 1, 0, 1, "§8» §6Knockback-Stick", true));
        if (KnockIT.config.getBooleanConfigValue("Item-Angel")) {
            p.getInventory().setItem(1, ItemFactory.createItem(Material.FISHING_ROD, 0, 1, "§8» §7Enterhaken (Rechtsklick)", true));
        }
        if (KnockIT.config.getBooleanConfigValue("Item-MLG")) {
            p.getInventory().setItem(8, ItemFactory.createItem(Material.QUARTZ_BLOCK, 0, 3, "§8§ §cBlock-MLG", false));
        }

        Location spawn = LocationFactory.getConfigLocation(KnockIT.config, "Location-Spawn");
        if (spawn != null) {
            p.teleport(spawn);
        } else if(p.hasPermission("group.admin")) {
            p.sendMessage(KnockIT.config.getConfigValue("System-Prefix") + "§4Der Spawn wurde noch nicht gesetzt!");
        }

        cp.getScoreboard().setNewObjective(new Objective(cp));
    }

}
