package eu.mcone.knockit.gadgets.event;

import eu.mcone.coresystem.api.bukkit.facades.Sound;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class StickListener implements Listener {

    @EventHandler
    public void on(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player hitter = (Player) e.getDamager();
            if (hitter.getItemInHand().hasItemMeta()) {
                if (hitter.getItemInHand().getType().equals(Material.BLAZE_ROD)) {

                    hitter.getInventory().remove(hitter.getItemInHand());
                    Sound.play(hitter, org.bukkit.Sound.PIG_DEATH);
                }
            }
        }
    }
}
