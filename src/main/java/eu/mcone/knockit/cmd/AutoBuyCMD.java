package eu.mcone.knockit.cmd;

import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.kit.Kit;
import org.bukkit.entity.Player;

public class AutoBuyCMD extends CorePlayerCommand {

    public AutoBuyCMD() {
        super("autobuy");
    }

    @Override
    public boolean onPlayerCommand(Player player, String[] strings) {
        GamePlayer gamePlayer = KnockIT.getInstance().getGamePlayer(player);

        if (gamePlayer.getCurrentKit() != Kit.DEFAULT && KnockIT.getInstance().getKitMap().containsKey(player)) {
            KnockIT.getInstance().getKitMap().remove(player);
            KnockIT.getInstance().getMessenger().sendSuccess(player, "§4Wenn du das nächste mal §cstirbst§4. Kaufst du nicht mehr §cautomatisch dein aktuelles Kit erneut§4!");

            KnockIT.getInstance().isKitAutoBuyDisabled.add(player);
        } else {
            KnockIT.getInstance().getMessenger().sendSuccess(player, "§4Du hat das Standard Kit ausgewählt!");
        }

        return false;
    }
}
