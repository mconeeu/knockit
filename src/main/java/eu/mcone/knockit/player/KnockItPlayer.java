package eu.mcone.knockit.player;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.plugin.GamePlayerInventory;
import eu.mcone.coresystem.api.bukkit.player.profile.PlayerInventoryProfile;
import eu.mcone.knockit.KnockIT;

public class KnockItPlayer extends GamePlayerInventory<PlayerInventoryProfile> {

    public KnockItPlayer(CorePlayer player) {
        super(player);
        KnockIT.getInstance().registerKnockITPlayer(this);
    }

    @Override
    public PlayerInventoryProfile loadData() {
        return KnockIT.getInstance().loadGameProfile(corePlayer.bukkit(), PlayerInventoryProfile.class);
    }

    @Override
    public void saveData() {
        KnockIT.getInstance().saveGameProfile(new PlayerInventoryProfile(corePlayer.bukkit(), enderchest));
    }

    public void unregister() {
        KnockIT.getInstance().unregisterKnockITPlayer(this);
    }

}
