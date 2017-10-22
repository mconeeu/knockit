package de.Dominik.KnockbackFFA.Command.de;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.Dominik.KnockbackFFA.Main.de.KnockFFA;

/**
 * 
 * @author Dominik Lippl ©
 * 
 * @copyright You do not have the permission to decompile this plugin ©
 * @copyright All right are at the developer with me: Dominik Lippl ©
 * @copyright You can not change the source code ©
 *
 */

public class CMD_spectate
  implements CommandExecutor
{
  public static ItemStack createItem(Material mat, int amount, String displayname)
  {
    ItemStack item = new ItemStack(mat, amount);
    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName(displayname);
    
    item.setItemMeta(meta);
    return item;
  }
  
  public static ArrayList<String> vanish = new ArrayList();
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (p.hasPermission("system.knockbackffa.spectator") || p.hasPermission("system.knockbackffa.*") || p.hasPermission("system.*")) {
      if (args.length == 0)
      {
        Object meta1;
        if (vanish.contains(p.getName()))
        {
          vanish.remove(p.getName());
          KnockFFA.main.ingame.add(p);
          KnockFFA.main.utils.clearPlayer(p);
          p.sendMessage(KnockFFA.main.sy + "§7Der §eSpectator-Modus §7wurde §cdeaktiviert");
          p.setFlying(false);
          p.setAllowFlight(false);
          for (Player all : Bukkit.getOnlinePlayers()) {
            all.showPlayer(p);
          }
          ItemStack stick = new ItemStack(Material.STICK);
          meta1 = stick.getItemMeta();
          ((ItemMeta)meta1).setDisplayName("§8§ §6Knockback-Stick");
          ((ItemMeta)meta1).addEnchant(Enchantment.KNOCKBACK, 2, true);
          stick.setItemMeta((ItemMeta)meta1);
          
          ItemStack enterhaken = new ItemStack(Material.FISHING_ROD);
          ItemMeta meta2 = enterhaken.getItemMeta();
          meta2.setDisplayName("§8§ §7Enterhaken (Rechtsklick)");
          meta2.spigot().setUnbreakable(true);
          enterhaken.setItemMeta(meta2);
          
          ItemStack mlg = new ItemStack(createItem(Material.QUARTZ_BLOCK, 3, "§8§ §cBlock-MLG"));
          
          p.getInventory().setItem(0, stick);
          if (KnockFFA.getAngel()) {
            p.getInventory().setItem(1, enterhaken);
          }
          if (KnockFFA.getBlock()) {
            p.getInventory().setItem(8, mlg);
          }
        }
        else
        {
          vanish.add(p.getName());
          KnockFFA.main.ingame.remove(p);
          KnockFFA.main.utils.clearPlayer(p);
          p.sendMessage(KnockFFA.main.sy + "§7Der §eSpectator-Modus §7wurde §aaktiviert");
          p.setHealth(20.0D);
          p.setFoodLevel(20);
          p.setAllowFlight(true);
          for (meta1 = Bukkit.getOnlinePlayers().iterator(); ((Iterator)meta1).hasNext();)
          {
            Player all = (Player)((Iterator)meta1).next();
            all.hidePlayer(p);
          }
          ItemStack compass = new ItemStack(Material.COMPASS);
          ItemMeta meta2 = compass.getItemMeta();
          meta2.setDisplayName("§cNavigator §7(Rechtsklick)");
          compass.setItemMeta(meta2);
          
          p.getInventory().setItem(0, compass);
        }
      }
    }else {
      p.sendMessage(KnockFFA.main.noPermission);
    }
    return false;
  }
}
