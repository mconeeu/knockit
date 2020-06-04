package eu.mcone.knockit.cmd;

import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import eu.mcone.knockit.inventory.GadgetsInventory;
import org.bukkit.entity.Player;

public class ShopCMD extends CorePlayerCommand {

    public ShopCMD() {
        super("shop");
    }

    @Override
    public boolean onPlayerCommand(Player player, String[] strings) {
        new GadgetsInventory(player, false);
        return false;
    }
}
