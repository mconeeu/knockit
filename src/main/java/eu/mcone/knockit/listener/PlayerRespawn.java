package eu.mcone.knockit.listener;

import eu.mcone.bukkitcoresystem.util.ItemFactory;
import eu.mcone.bukkitcoresystem.util.LocationFactory;
import eu.mcone.knockit.KnockIT;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener {

    @EventHandler
    public void on(PlayerRespawnEvent e) {
        Player p = e.getPlayer();

        p.getInventory().setItem(0, ItemFactory.createEnchantedItem(Material.STICK, Enchantment.KNOCKBACK, 1, 0, 1, "§8» §6Knockback-Stick", true));
        if (KnockIT.config.getBooleanConfigValue("Item-Angel")) {
            p.getInventory().setItem(1, ItemFactory.createItem(Material.FISHING_ROD, 0, 1, "§8» §7Enterhaken (Rechtsklick)", true));
        }
        if (KnockIT.config.getBooleanConfigValue("Item-MLG")) {
            p.getInventory().setItem(8, ItemFactory.createItem(Material.QUARTZ_BLOCK, 0, 3, "§8§ §cBlock-MLG", false));
        }

        Location respawnLocation = LocationFactory.getConfigLocation(KnockIT.config, "Location-Spawn");
        if (respawnLocation != null) {
            e.setRespawnLocation(respawnLocation);
        } else {
            p.sendMessage(KnockIT.config.getConfigValue("System-Prefix") + "§4Du konntest nicht zum Spawn teleportiert werden, da der Spawn nicht eingespeichert ist!");
        }
    }

}
