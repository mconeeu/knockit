package eu.mcone.knockit;

import eu.mcone.bukkitcoresystem.CoreSystem;
import eu.mcone.bukkitcoresystem.api.HologramAPI;
import eu.mcone.bukkitcoresystem.command.HoloCMD;
import eu.mcone.bukkitcoresystem.config.MySQL_Config;
import eu.mcone.bukkitcoresystem.player.CorePlayer;
import eu.mcone.gameapi.api.StateAPI;
import eu.mcone.knockit.command.*;
import eu.mcone.knockit.listener.*;
import eu.mcone.knockit.util.Objective;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getPluginManager;

public class KnockIT extends JavaPlugin {

    private static KnockIT instance;
    public static MySQL_Config config;
    private HologramAPI holo;

    private static String MainPrefix = "§8[§2KnockIt§8] ";

    public static void playSound(Location loc, Sound s) {
        for (Player all : Bukkit.getOnlinePlayers()) {
            if (all.getLocation().distance(loc) <= 0.0D) {
                all.playSound(loc, s, 0.3F, 1.0F);
            }
        }
    }

    public void onEnable() {
        instance = this;

        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aMySQL Config wird initiiert...");
        config = new MySQL_Config(CoreSystem.mysql3, "KnockIt", 1000);
        registerMySQLConfig();

        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aHologram-Manager wird gestartet");
        holo = new HologramAPI(eu.mcone.bukkitcoresystem.CoreSystem.mysql1, "KnockIt");

        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aEvents und Befehle werden registriert...");
        registerCommands();
        registerEvents();

        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§aVersion §f" + this.getDescription().getVersion() + "§a wurde aktiviert...");
        StateAPI.setState(StateAPI.State.WAITING);

        for (CorePlayer p : CoreSystem.getOnlineCorePlayers()) {
            p.getScoreboard().setNewObjective(new Objective(p));
        }
    }

    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage(MainPrefix + "§cPlugin wurde deaktiviert!");
    }

    private void registerCommands() {
        getCommand("angel").setExecutor(new AngelCMD());
        getCommand("setspawn").setExecutor(new SetspawnCMD());
        getCommand("holo").setExecutor(new HoloCMD(holo));
    }

    private void registerEvents() {
        getPluginManager().registerEvents(new BlockBreak(), this);
        getPluginManager().registerEvents(new BlockPlace(), this);
        getPluginManager().registerEvents(new EntityDamage(), this);
        getPluginManager().registerEvents(new EntityDamageByEntity(), this);
        getPluginManager().registerEvents(new FoodLevelChange(), this);
        getPluginManager().registerEvents(new InventoryClick(), this);
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

    private void registerMySQLConfig() {
        config.createTable();

        config.insertMySQLConfig("System-Prefix", "§8[§7§l!§8] §2KnockIt §8» §7");
        config.insertMySQLConfig("System-No-Perm", "&4Du hast keine Berechtigung für diesen Befehl");

        config.insertMySQLConfig("ScoreBoard-1", "&7&l⚔ &3§l§nKnockIT");
        config.insertMySQLConfig("ScoreBoard-2", "&8» &7Kills:");
        config.insertMySQLConfig("ScoreBoard-4", "§3");
        config.insertMySQLConfig("ScoreBoard-5", "&8» &7Tode:");
        config.insertMySQLConfig("ScoreBoard-6", "§c");
        config.insertMySQLConfig("ScoreBoard-7", "&8» &7Coins:");
        config.insertMySQLConfig("ScoreBoard-8", "&f§lMCONE.EU");

        config.insertMySQLConfig("Item-MLG", true);
        config.insertMySQLConfig("Item-Angel", true);

        config.store();
    }

    public static KnockIT getInstance() {
        return KnockIT.instance;
    }

    public HologramAPI getHolo() {
        return holo;
    }
}
