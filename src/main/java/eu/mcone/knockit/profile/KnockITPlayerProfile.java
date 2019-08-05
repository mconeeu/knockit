/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.profile;

import eu.mcone.coresystem.api.bukkit.player.profile.PlayerDataProfile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.entity.Player;

@NoArgsConstructor
@Getter
@Setter
public class KnockITPlayerProfile extends PlayerDataProfile {

    KnockITPlayerProfile(Player p) {
        super(p);
    }

    @Override
    public void doSetData(Player p) {
        super.doSetData(p);
    }
}
