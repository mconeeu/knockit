package eu.mcone.knockit.listener;

import eu.mcone.knockit.KnockIT;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;


public class EntityDamageByEntity implements Listener {

    @EventHandler
    public void on(EntityDamageByEntityEvent e) {
        Entity ent = e.getEntity();
        Entity byEnt = e.getDamager();

        if (ent instanceof Player && byEnt instanceof Player) {
            Player p = (Player) ent;

            if (p.getLocation().getY() > 80) {
                e.setCancelled(true);
                byEnt.sendMessage(KnockIT.config.getConfigValue("System-Prefix") + "§4Du darfst am Spawn nicht kämpfen!");
            } else {
                e.setDamage(0.0D);
            }
        }
    }

}
