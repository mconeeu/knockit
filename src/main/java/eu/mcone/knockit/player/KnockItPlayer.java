package eu.mcone.knockit.player;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.plugin.GamePlayerInventory;
import eu.mcone.coresystem.api.bukkit.player.profile.PlayerDataProfile;
import eu.mcone.coresystem.api.bukkit.player.profile.PlayerInventoryProfile;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.gadgets.Gadget;
import lombok.Getter;

public class KnockItPlayer extends GamePlayerInventory<PlayerInventoryProfile> {

    static {
        PlayerDataProfile.preventTeleport(true);
    }

    @Getter
    private Gadget currentGadget;

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

    public void setGadget(Gadget gadget) {
        currentGadget = gadget;
        corePlayer.bukkit().getInventory().addItem(gadget.getItem());
    }

    public void removeGadget(Gadget gadgets) {
        currentGadget = null;
        corePlayer.bukkit().getInventory().remove(gadgets.getItem());
    }

    public boolean hasGadget() {
        return currentGadget != null;
    }

}
