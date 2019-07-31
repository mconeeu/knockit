/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.gamemode.Gamemode;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.profile.PlayerDataProfile;
import eu.mcone.coresystem.api.bukkit.world.BuildSystem;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import eu.mcone.gamesystem.api.GameTemplate;
import eu.mcone.knockit.cmd.KnockITCommand;
import eu.mcone.knockit.gadgets.event.GrenadeListener;
import eu.mcone.knockit.gadgets.event.PlayerSwapListener;
import eu.mcone.knockit.gadgets.event.RocketListener;
import eu.mcone.knockit.kit.Kit;
import eu.mcone.knockit.listener.*;
import eu.mcone.knockit.profile.KnockITPlayer;
import eu.mcone.knockit.util.SidebarObjective;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.*;

public class KnockIT extends GameTemplate {

    public KnockIT() {
        super("knockit", Gamemode.KNOCKIT, ChatColor.GREEN, "knockit.prefix", GameSystemOptions.USE_MAP_MANAGER);
    }

    @Getter
    private static KnockIT instance;
    private List<KnockITPlayer> players;
    @Getter
    private Map<Player, Kit> sorting;

    @Getter
    private BuildSystem buildSystem;

    @Override
    public void onGameEnable() {
        instance = this;
        CoreSystem.getInstance().getTranslationManager().loadCategories(this);
        players = new ArrayList<>();
        sorting = new HashMap<>();

        sendConsoleMessage("§aBuild-System wird initiiert...");
        buildSystem = CoreSystem.getInstance().initialiseBuildSystem(BuildSystem.BuildEvent.BLOCK_BREAK, BuildSystem.BuildEvent.BLOCK_PLACE);
        buildSystem.addFilter(BuildSystem.BuildEvent.BLOCK_PLACE, Material.QUARTZ_BLOCK.getId());

        sendConsoleMessage("§aStart MapManager...");
        GameTemplate.getInstance().getMapManager().createMapRotationHandler(300).startRotation();

        sendConsoleMessage("§aCommands undEvents werden registriert...");
        registerCommands();
        registerEvents();

        sendConsoleMessage("§aVersion §f" + this.getDescription().getVersion() + "§a wurde aktiviert...");

        PlayerDataProfile.doSetGameProfileWorld(this.getServer().getWorld(getMapManager().getMapRotationHandler().getCurrentGameMap().getWorld()));

        for (CorePlayer p : CoreSystem.getInstance().getOnlineCorePlayers()) {
            p.getScoreboard().setNewObjective(new SidebarObjective());
            new KnockITPlayer(p);
        }
    }

    @Override
    public void onGameDisable() {
        for (KnockITPlayer knockITPlayer : getKnockITPlayers()) {
            knockITPlayer.saveData();
        }

        sendConsoleMessage("§cPlugin wurde deaktiviert!");
    }

    private void registerCommands() {
        registerCommands(
                new KnockITCommand()
        );
    }

    private void registerEvents() {
        registerEvents(
                new PlayerMoveListener(),
                new RocketListener(),
                new PlayerSwapListener(),
                new GrenadeListener(),
                new EntityDamageListener(),
                new FishingRodListener(),
                new GeneralPlayerListener(),
                new MlgBlockListener(),
                new NpcListener(),
                new PlayerDeathListener(),
                new PlayerLevelChange(),
                new PlayerUpdateListener(),
                new WeatherChangeListener(),
                new GameMapCountdownChangeListener(),
                new InventoryClickListener()
        );
    }

    public KnockITPlayer getKnockITPlayer(UUID uuid) {
        for (KnockITPlayer sp : players) {
            if (sp.getCorePlayer().getUuid().equals(uuid)) {
                return sp;
            }
        }
        return null;
    }

    public KnockITPlayer getKnockITPlayer(String name) {
        for (KnockITPlayer sp : players) {
            if (sp.getCorePlayer().getName().equals(name)) {
                return sp;
            }
        }
        return null;
    }

    public CoreWorld getCurrentWorld() {
        return KnockIT.getInstance().getMapManager().getMapRotationHandler().getCurrentCoreWorld();
    }

    public Collection<KnockITPlayer> getKnockITPlayers() {
        return players;
    }

    public void registerKnockITPlayer(KnockITPlayer sp) {
        players.add(sp);
    }

    public void unregisterKnockITPlayer(KnockITPlayer sp) {
        players.remove(sp);
    }
}
