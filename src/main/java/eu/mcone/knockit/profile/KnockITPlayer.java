/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.profile;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.plugin.GamePlayerData;
import eu.mcone.gamesystem.api.game.manager.kit.Kit;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.gadgets.Gadgets;
import lombok.Getter;

public class KnockITPlayer extends GamePlayerData<KnockITPlayerProfile> {

    @Getter
    private transient Kit currentKit;
    @Getter
    private transient Gadgets currentGadget;

    public KnockITPlayer(CorePlayer player) {
        super(player);
        KnockIT.getInstance().registerKnockITPlayer(this);
    }

    @Override
    public KnockITPlayerProfile reload() {
        return super.reload();
    }

    @Override
    protected KnockITPlayerProfile loadData() {
        return KnockIT.getInstance().loadGameProfile(corePlayer.bukkit(), KnockITPlayerProfile.class);
    }

    @Override
    public void saveData() {
        KnockIT.getInstance().saveGameProfile(new KnockITPlayerProfile(corePlayer.bukkit()));
    }

    public void setGadget(Gadgets gadget) {
        currentGadget = gadget;
        corePlayer.bukkit().getInventory().addItem(gadget.getItem());
    }

    public void removeGadget(Gadgets gadgets) {
        corePlayer.bukkit().getInventory().remove(gadgets.getItem());
    }
}
