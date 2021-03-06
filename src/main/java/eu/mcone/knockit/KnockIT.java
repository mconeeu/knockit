/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.gamemode.Gamemode;
import eu.mcone.coresystem.api.bukkit.world.BuildSystem;
import eu.mcone.gameapi.api.GamePlugin;
import eu.mcone.gameapi.api.Option;
import eu.mcone.knockit.cmd.KnockITCMD;
import eu.mcone.knockit.cmd.ShopCMD;
import eu.mcone.knockit.gadgets.event.GrenadeListener;
import eu.mcone.knockit.gadgets.event.PlayerSwapListener;
import eu.mcone.knockit.gadgets.event.RocketListener;
import eu.mcone.knockit.gadgets.event.StickListener;
import eu.mcone.knockit.kit.Kit;
import eu.mcone.knockit.listener.*;
import eu.mcone.knockit.player.KnockItPlayer;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class KnockIT extends GamePlugin {

    public KnockIT() {
        super(Gamemode.KNOCKIT, "knockit.prefix", Option.KIT_MANAGER_CLEAR_INVENTORY_ON_KIT_SET, Option.KIT_MANAGER_ALLOW_AUTO_BUY_KIT, Option.KIT_MANAGER_SET_CURRENT_KIT_ON_JOIN);
    }

    @Getter
    private static KnockIT instance;
    @Getter
    private BuildSystem buildSystem;

    @Getter
    private List<KnockItPlayer> players;
    @Getter
    public ArrayList<Player> isInFishingRodCooldown = new ArrayList<>();

    @Override
    public void onGameEnable() {
        instance = this;
        players = new ArrayList<>();

        sendConsoleMessage("┬žaInitiating BuildSystem...");
        buildSystem = CoreSystem.getInstance().initialiseBuildSystem(BuildSystem.BuildEvent.BLOCK_BREAK, BuildSystem.BuildEvent.BLOCK_PLACE);
        buildSystem.addFilter(BuildSystem.BuildEvent.BLOCK_PLACE, Material.QUARTZ_BLOCK.getId());

        getMapManager()
                .getMapRotationHandler()
                .setRotationInterval(600)
                .startRotation();

        getKitManager().registerKits(
                Kit.DEFAULT, Kit.ARCHER, Kit.KNOCKBACK, Kit.GRAPLING_HOOK, Kit.JETPACK, Kit.ENDERMAN, Kit.BIG_HITTER
        );
        getKitManager().setDefaultKit(Kit.DEFAULT);


        sendConsoleMessage("┬žaRegistering Commands and Listeners...");
        registerCommands(
                new KnockITCMD(),
                new ShopCMD()
        );
        registerEvents(
                new PlayerHeightListener(),
                new RocketListener(),
                new PlayerSwapListener(),
                new GrenadeListener(),
                new FishingRodListener(),
                new GeneralPlayerListener(),
                new MlgBlockListener(),
                new NpcListener(),
                new PlayerDeathListener(),
                new KillStreakListener(),
                new PlayerUpdateListener(),
                new WeatherChangeListener(),
                new StickListener()
        );

        sendConsoleMessage("┬žaVersion ┬žf" + this.getDescription().getVersion() + "┬ža enabled...");
    }

    @Override
    public void onGameDisable() {
        for (KnockItPlayer knockITPlayer : getOnlineKnockITPlayers()) {
            knockITPlayer.saveData();
        }

        sendConsoleMessage("┬žcPlugin disabled!");
    }

    public KnockItPlayer getKnockITPlayer(UUID uuid) {
        for (KnockItPlayer kp : players) {
            if (kp.getCorePlayer().getUuid().equals(uuid)) {
                return kp;
            }
        }
        return null;
    }

    public KnockItPlayer getKnockITPlayer(String name) {
        for (KnockItPlayer kp : players) {
            if (kp.getCorePlayer().getName().equals(name)) {
                return kp;
            }
        }
        return null;
    }

    public Collection<KnockItPlayer> getOnlineKnockITPlayers() {
        return new ArrayList<>(players);
    }

    public void registerKnockITPlayer(KnockItPlayer kp) {
        players.add(kp);
    }

    public void unregisterKnockITPlayer(KnockItPlayer gp) {
        players.remove(gp);
    }

}
