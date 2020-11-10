package eu.mcone.knockit.gadgets.event;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class StickListener implements Listener {

    @EventHandler
    public void on(EntityDamageByEntityEvent e) {
        Player hitter = (Player) e.getDamager();
        if (hitter.getItemInHand().hasItemMeta()) {
            if (hitter.getItemInHand().getType().equals(Material.BLAZE_ROD)) {

                hitter.getInventory().remove(hitter.getItemInHand());
                hitter.playSound(hitter.getLocation(), Sound.PIG_DEATH, 1, 1);

            }
        }
    }
}
