package KnockbackFFA.Main.de;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import KnockbackFFA.Command.de.CMD_Holo;
import KnockbackFFA.Command.de.CMD_angel;
import KnockbackFFA.Command.de.CMD_build;
import KnockbackFFA.Command.de.CMD_fly;
import KnockbackFFA.Command.de.CMD_setdeathborder;
import KnockbackFFA.Command.de.CMD_setfrieden;
import KnockbackFFA.Command.de.CMD_setspawn;
import KnockbackFFA.Command.de.CMD_spectate;
import KnockbackFFA.Hologramm.de.PlayerHoloListener;
import KnockbackFFA.Listener.de.EVENT_Vanish;
import KnockbackFFA.Listener.de.LISTENER_Build;
import KnockbackFFA.Listener.de.LISTENER_Death;
import KnockbackFFA.Listener.de.LISTENER_Drop;
import KnockbackFFA.Listener.de.LISTENER_Enterhaken;
import KnockbackFFA.Listener.de.LISTENER_FallDamage;
import KnockbackFFA.Listener.de.LISTENER_Feed;
import KnockbackFFA.Listener.de.LISTENER_Frieden;
import KnockbackFFA.Listener.de.LISTENER_InstantDeath;
import KnockbackFFA.Listener.de.LISTENER_Killstreak;
import KnockbackFFA.Listener.de.LISTENER_Navigator;
import KnockbackFFA.Listener.de.LISTENER_Quit;
import KnockbackFFA.Listener.de.LISTENER_Respawn;
import KnockbackFFA.Listener.de.LISTENER_Weather;
import KnockbackFFA.api.de.API_Location;
import KnockbackFFA.api.de.API_Stuff;

public class KnockFFA
  extends JavaPlugin
  implements Listener
{
  private static KnockFFA plugin;
  public static Plugin plugin2;
  public static KnockFFA main;
  public static String pr = "§8[§7§l!§8] §eKnockFFA §8» ";
  public static String sy = "§8[§7§l!§8] §fServer §8» §7 ";
  public static String noPermission = "§cKeine Permissions";
  public API_Stuff utils;
  public ArrayList<Player> ingame;
  
  @SuppressWarnings("unchecked")
public void onEnable(){
    plugin = this;
    main = this;
    this.utils = new API_Stuff();
    this.ingame = new ArrayList();
    
    Bukkit.getConsoleSender().sendMessage(this.pr + "§7------- §eKnockbackFFA §7-------");
	Bukkit.getConsoleSender().sendMessage(this.pr  + "§7Plugin Name: §e" + this.getDescription().getName());
	Bukkit.getConsoleSender().sendMessage(this.pr  + "§7Author: §e" + this.getDescription().getAuthors());
	Bukkit.getConsoleSender().sendMessage(this.pr  + "§7Version: §e" + this.getDescription().getVersion());
	Bukkit.getConsoleSender().sendMessage(this.pr  + "§7------- §eKnockbackFFA §7-------");
    
    PluginManager pm = Bukkit.getPluginManager();
    pm.registerEvents(new EVENT_Vanish(), this);
    pm.registerEvents(new LISTENER_Build(), this);
    pm.registerEvents(new LISTENER_Death(), this);
    pm.registerEvents(new LISTENER_Drop(), this);
    pm.registerEvents(new LISTENER_Enterhaken(), this);
    pm.registerEvents(new LISTENER_FallDamage(), this);
    pm.registerEvents(new LISTENER_Feed(), this);
    pm.registerEvents(new LISTENER_Frieden(), this);
    pm.registerEvents(new LISTENER_InstantDeath(), this);
    pm.registerEvents(new LISTENER_Killstreak(), this);
    pm.registerEvents(new LISTENER_Navigator(), this);
    pm.registerEvents(new LISTENER_Quit(), this);
    pm.registerEvents(new LISTENER_Respawn(), this);
    pm.registerEvents(new LISTENER_Weather(), this);
    Bukkit.getServer().getPluginManager().registerEvents(this, this);
    
    getCommand("angel").setExecutor(new CMD_angel());
    getCommand("build").setExecutor(new CMD_build());
    getCommand("fly").setExecutor(new CMD_fly());
    getCommand("setdeathborder").setExecutor(new CMD_setdeathborder());
    getCommand("setfrieden").setExecutor(new CMD_setfrieden());
    getCommand("set").setExecutor(new CMD_setspawn());
    getCommand("spectate").setExecutor(new CMD_spectate());
    getCommand("setholo").setExecutor(new CMD_Holo());
    for (Player all : Bukkit.getOnlinePlayers()) {
      main.ingame.add(all);
    }
  }
  
  public void onDisable() {}
  
  public static ItemStack createItem(Material mat, int amount, String displayname)
  {
    ItemStack item = new ItemStack(mat, amount);
    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName(displayname);
    
    item.setItemMeta(meta);
    return item;
  }
  
  @EventHandler
  public void onJoin(PlayerJoinEvent e){
    Player p = e.getPlayer();
    
    e.setJoinMessage(this.pr + "§7§ " + p.getDisplayName() + " §7ist dem Spiel beigetreten");
    
    main.utils.clearPlayer(p);
    main.ingame.add(p);
    p.setGameMode(GameMode.SURVIVAL);
    
    ItemStack stick = new ItemStack(Material.STICK);
    ItemMeta meta1 = stick.getItemMeta();
    meta1.setDisplayName("§8§ §6Knockback-Stick");
    meta1.addEnchant(Enchantment.KNOCKBACK, 2, true);
    stick.setItemMeta(meta1);
    
    ItemStack enterhaken = new ItemStack(Material.FISHING_ROD);
    ItemMeta meta2 = enterhaken.getItemMeta();
    meta2.setDisplayName("§8§ §7Enterhaken (Rechtsklick)");
    meta2.spigot().setUnbreakable(true);
    enterhaken.setItemMeta(meta2);
    
    for(Player p1 : Bukkit.getOnlinePlayers()){
		PlayerHoloListener.Holo(p1);
	}
    
    ItemStack mlg = new ItemStack(createItem(Material.QUARTZ_BLOCK, 3, "§8§ §cBlock-MLG"));
    
    p.getInventory().setItem(0, stick);
    if (getAngel()) {
      p.getInventory().setItem(1, enterhaken);
    }
    if (getBlock()) {
      p.getInventory().setItem(8, mlg);
    }
    p.teleport(API_Location.getLocation("spawn"));
  }
  
  public static void playSound(Location loc, Sound s)
  {
    for (Player all : Bukkit.getOnlinePlayers()) {
      if (all.getLocation().distance(loc) <= 0.0D) {
        all.playSound(loc, s, 0.3F, 1.0F);
      }
    }
  }
  
  public static void setAngel(boolean status)
  {
    File file = new File("plugins/" + main.getName(), "angel.yml");
    if (!file.exists()) {
      try
      {
        file.createNewFile();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    
    cfg.set("angel", Boolean.valueOf(status));
    try
    {
      cfg.save(file);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
  public static boolean getAngel()
  {
    File file = new File("plugins/" + main.getName(), "angel.yml");
    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    if (!file.exists()) {
      try
      {
        file.createNewFile();
        cfg.set("angel", Boolean.valueOf(true));
        cfg.save(file);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    boolean angel = cfg.getBoolean("angel");
    return angel;
  }
  
  public static void setBlock(boolean status)
  {
    File file = new File("plugins/" + main.getName(), "mlg.yml");
    if (!file.exists()) {
      try
      {
        file.createNewFile();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    
    cfg.set("mlg", Boolean.valueOf(status));
    try
    {
      cfg.save(file);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
  public static boolean getBlock()
  {
    File file = new File("plugins/" + main.getName(), "mlg.yml");
    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    if (!file.exists()) {
      try
      {
        file.createNewFile();
        cfg.set("mlg", Boolean.valueOf(true));
        cfg.save(file);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    boolean mlgblock = cfg.getBoolean("mlg");
    return mlgblock;
  }
  
  public static KnockFFA getPlugin(){

		return plugin;
	}

	public static KnockFFA getInstance() {
		return KnockFFA.plugin;
	}
}
