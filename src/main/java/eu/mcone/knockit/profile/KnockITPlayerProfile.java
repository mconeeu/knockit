/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.profile;

import eu.mcone.coresystem.api.bukkit.player.profile.PlayerDataProfile;
import eu.mcone.knockit.kit.CustomKit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class KnockITPlayerProfile extends PlayerDataProfile {

    private Map<String, CustomKit> customKits = new HashMap<>();

    KnockITPlayerProfile(Player p, Map<String, CustomKit> customKits) {
        super(p);

        this.customKits = customKits;
    }

    @Override
    public void doSetData(Player p) {
        super.doSetData(p);
    }
}
