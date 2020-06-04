/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.gamemode.Gamemode;
import eu.mcone.coresystem.api.bukkit.world.BuildSystem;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import eu.mcone.gameapi.api.GamePlugin;
import eu.mcone.gameapi.api.Option;
import eu.mcone.knockit.cmd.KnockITCommand;
import eu.mcone.knockit.cmd.ShopCMD;
import eu.mcone.knockit.gadgets.event.GrenadeListener;
import eu.mcone.knockit.gadgets.event.PlayerSwapListener;
import eu.mcone.knockit.gadgets.event.RocketListener;
import eu.mcone.knockit.kit.Kit;
import eu.mcone.knockit.listener.*;
import eu.mcone.knockit.player.KnockItPlayer;
import lombok.Getter;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class KnockIT extends GamePlugin {

    public KnockIT() {
        super(Gamemode.KNOCKIT, "knockit.prefix", Option.KIT_MANAGER_APPLY_KITS_ONCE, Option.KIT_MANAGER_CLEAR_INVENTORY_ON_KIT_SET);
    }

    @Getter
    private static KnockIT instance;
    @Getter
    private BuildSystem buildSystem;

    @Getter
    private List<KnockItPlayer> players;

    @Override
    public void onGameEnable() {
        instance = this;
        players = new ArrayList<>();

        sendConsoleMessage("§aInitiating BuildSystem...");
        buildSystem = CoreSystem.getInstance().initialiseBuildSystem(BuildSystem.BuildEvent.BLOCK_BREAK, BuildSystem.BuildEvent.BLOCK_PLACE);
        buildSystem.addFilter(BuildSystem.BuildEvent.BLOCK_PLACE, Material.QUARTZ_BLOCK.getId());

        getMapManager()
                .getMapRotationHandler()
                .setRotationInterval(600)
                .startRotation();

        getKitManager().registerKits(
                Kit.DEFAULT, Kit.ARCHER, Kit.KNOCKBACK, Kit.GRAPLING_HOOK, Kit.ENDERMAN
        );
        getKitManager().setDefaultKit(Kit.DEFAULT);

        sendConsoleMessage("§aRegistering Commands and Listeners...");
        registerCommands(
                new KnockITCommand(),
                new ShopCMD());
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
                new WeatherChangeListener()
        );

        sendConsoleMessage("§aVersion §f" + this.getDescription().getVersion() + "§a enabled...");
    }

    @Override
    public void onGameDisable() {
        for (KnockItPlayer knockITPlayer : getOnlineKnockITPlayers()) {
            knockITPlayer.saveData();
        }

        sendConsoleMessage("§cPlugin disabled!");
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
