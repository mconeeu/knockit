package eu.mcone.knockit.listener;

import eu.mcone.gamesystem.api.game.event.GamePlayerLoadedEvent;
import eu.mcone.knockit.util.Kits;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GamePlayerLodadedListener implements Listener {

    @EventHandler
    public void on(GamePlayerLoadedEvent e) {
        if (e.getReason().equals(GamePlayerLoadedEvent.Reason.JOINED)) {
            e.getPlayer().setKit(Kits.DEFAULT.getName());
        }
    }
}
