package eu.mcone.knockit.listener;

import eu.mcone.gamesystem.api.game.event.GamePlayerBoughtKitEvent;
import eu.mcone.gamesystem.api.game.manager.kit.Kit;
import eu.mcone.gamesystem.api.game.player.GamePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class GamePlayerBoughtKitListener implements Listener {

    @EventHandler
    public void on(GamePlayerBoughtKitEvent e) {
        GamePlayer gamePlayer = e.getPlayer();
        Player player = gamePlayer.getCorePlayer().bukkit();
        Kit kit = e.getKit();

        if (gamePlayer.hasCurrentKit()) {
            Kit currentKit = gamePlayer.getCurrentKit();
            List<ItemStack> otherItems = new ArrayList<>();

            for (ItemStack itemStack : player.getInventory().getContents()) {
                if (itemStack != null && !kit.getItems().contains(itemStack) && !currentKit.getItems().contains(itemStack)) {
                    otherItems.add(itemStack);
                }
            }

            player.getInventory().clear();

            gamePlayer.setKit(kit);

            for (ItemStack itemStack : otherItems) {
                player.getInventory().addItem(itemStack);
            }
        } else {
            gamePlayer.setKit(kit);
        }
    }
}
