/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.hologram.HologramManager;
import eu.mcone.coresystem.api.bukkit.player.BukkitCorePlayer;
import eu.mcone.coresystem.api.bukkit.world.BuildSystem;
import eu.mcone.coresystem.api.bukkit.world.LocationManager;
import eu.mcone.coresystem.api.core.translation.TranslationField;
import eu.mcone.knockit.listener.*;
import eu.mcone.knockit.util.Item;
import eu.mcone.knockit.util.Objective;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

import static org.bukkit.Bukkit.getPluginManager;

public class KnockIT extends JavaPlugin {

    @Getter
    private static KnockIT instance;
    private static String MainPrefix = "§8[§2KnockIt§8] ";
    
    @Getter
    private HologramManager hologramManager;
    @Getter
    private LocationManager locationManager;

    public void onEnable() {
        instance = this;

        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aHologram-Manager wird gestartet");
        hologramManager = CoreSystem.getInstance().inititaliseHologramManager("KnockIt");

        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aBuild-System witd initiiert");
        CoreSystem.getInstance().initialiseBuildSystem(false, BuildSystem.BuildEvent.BLOCK_BREAK, BuildSystem.BuildEvent.BLOCK_PLACE);

        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aLocationManager witd initiiert");
        locationManager = CoreSystem.getInstance().initialiseLocationManager("Knockit").preventSpawnCommand().downloadLocations();

        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aEvents werden registriert...");
        registerEvents();

        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aVersion §f" + this.getDescription().getVersion() + "§a wurde aktiviert...");

        for (BukkitCorePlayer p : CoreSystem.getInstance().getOnlineCorePlayers()) {
            p.getScoreboard().setNewObjective(new Objective());
            p.bukkit().getInventory().clear();
            Item.setItems(p.bukkit());
        }
    }

    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§cPlugin wurde deaktiviert!");
    }

    private void registerEvents() {
        getPluginManager().registerEvents(new BlockPlace(), this);
        getPluginManager().registerEvents(new EntityDamage(), this);
        getPluginManager().registerEvents(new EntityDamageByEntity(), this);
        getPluginManager().registerEvents(new FoodLevelChange(), this);
        getPluginManager().registerEvents(new PlayerDeath(), this);
        getPluginManager().registerEvents(new PlayerDropItem(), this);
        getPluginManager().registerEvents(new PlayerFish(), this);
        getPluginManager().registerEvents(new PlayerInteract(), this);
        getPluginManager().registerEvents(new PlayerJoin(), this);
        getPluginManager().registerEvents(new PlayerLevelChange(), this);
        getPluginManager().registerEvents(new PlayerMove(), this);
        getPluginManager().registerEvents(new PlayerQuit(), this);
        getPluginManager().registerEvents(new PlayerRespawn(), this);
        getPluginManager().registerEvents(new StatsChange(), this);
        getPluginManager().registerEvents(new WeatherChange(), this);
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
