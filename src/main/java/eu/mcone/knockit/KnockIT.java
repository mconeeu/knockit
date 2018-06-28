/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit;

import eu.mcone.coresystem.api.bukkit.CorePlugin;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.hologram.HologramManager;
import eu.mcone.coresystem.api.bukkit.player.BukkitCorePlayer;
import eu.mcone.coresystem.api.bukkit.player.StatsAPI;
import eu.mcone.coresystem.api.bukkit.world.BuildSystem;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import eu.mcone.coresystem.api.core.gamemode.Gamemode;
import eu.mcone.coresystem.api.core.translation.TranslationField;
import eu.mcone.knockit.listener.*;
import eu.mcone.knockit.util.Item;
import eu.mcone.knockit.util.Objective;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.HashMap;

public class KnockIT extends CorePlugin {

    public KnockIT() {
        super("KnockIT", ChatColor.DARK_GREEN, "knockit.prefix");
    }

    @Getter
    private static KnockIT instance;
    @Getter
    private StatsAPI statsAPI;
    @Getter
    private HologramManager hologramManager;
    @Getter
    private CoreWorld world;

    public void onEnable() {
        instance = this;
        world = CoreSystem.getInstance().getWorldManager().getWorld("Knockit");
        registerTranslations();

        sendConsoleMessage("§aStatsAPI wird initiiert...");
        statsAPI = CoreSystem.getInstance().getStatsAPI(Gamemode.KNOCKIT);

        sendConsoleMessage("§aHologram-Manager wird gestartet");
        hologramManager = CoreSystem.getInstance().inititaliseHologramManager(this);

        sendConsoleMessage("§aBuild-System witd initiiert");
        CoreSystem.getInstance().initialiseBuildSystem(false, BuildSystem.BuildEvent.BLOCK_BREAK, BuildSystem.BuildEvent.BLOCK_PLACE);

        sendConsoleMessage("§aEvents werden registriert...");
        registerEvents();

        sendConsoleMessage("§aVersion §f" + this.getDescription().getVersion() + "§a wurde aktiviert...");

        for (BukkitCorePlayer p : CoreSystem.getInstance().getOnlineCorePlayers()) {
            p.getScoreboard().setNewObjective(new Objective());
            p.bukkit().getInventory().clear();
            Item.setItems(p.bukkit());
        }
    }

    public void onDisable() {
        sendConsoleMessage("§cPlugin wurde deaktiviert!");
    }

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new BlockPlace(), this);
        Bukkit.getPluginManager().registerEvents(new EntityDamage(), this);
        Bukkit.getPluginManager().registerEvents(new EntityDamageByEntity(), this);
        Bukkit.getPluginManager().registerEvents(new FoodLevelChange(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeath(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDropItem(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerFish(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteract(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerLevelChange(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMove(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuit(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerRespawn(), this);
        Bukkit.getPluginManager().registerEvents(new StatsChange(), this);
        Bukkit.getPluginManager().registerEvents(new WeatherChange(), this);
    }

    private void registerTranslations() {
        CoreSystem.getInstance().getTranslationManager().insertIfNotExists(
                new HashMap<String, TranslationField>(){{
                    put("knockit.prefix", new TranslationField("§8[§7§l!§8] §2KnockIt §8» §7"));
                    put("knockit.scoreboard.1", new TranslationField("&7&l⚔ &3§l§nKnockIT"));
                    put("knockit.scoreboard.2", new TranslationField("&8» &7Kills:"));
                    put("knockit.scoreboard.4", new TranslationField("§3"));
                    put("knockit.scoreboard.5", new TranslationField("&8» &7Tode:"));
                    put("knockit.scoreboard.6", new TranslationField("§c"));
                    put("knockit.scoreboard.7", new TranslationField("&8» &7Coins:"));
                    put("knockit.scoreboard.8", new TranslationField("&f§lMCONE.EU"));
                }}
        );
    }

}
