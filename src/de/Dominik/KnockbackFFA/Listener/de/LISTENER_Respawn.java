package de.Dominik.KnockbackFFA.Listener.de;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.Dominik.KnockbackFFA.Main.de.KnockFFA;
import de.Dominik.KnockbackFFA.api.de.API_Location;

/**
 * 
 * @author Dominik Lippl ©
 * 
 * @copyright You do not have the permission to decompile this plugin ©
 * @copyright All right are at the developer with me: Dominik Lippl ©
 * @copyright You can not change the source code ©
 *
 */

public class LISTENER_Respawn
  implements Listener
{
  public static ItemStack createItem(Material mat, int amount, String displayname)
  {
    ItemStack item = new ItemStack(mat, amount);
    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName(displayname);
    
    item.setItemMeta(meta);
    return item;
  }
  
  @EventHandler
  public void onRespawn(PlayerRespawnEvent e)
  {
    Player p = e.getPlayer();
    
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
    
    ItemStack mlg = new ItemStack(createItem(Material.QUARTZ_BLOCK, 3, "§8§ §cBlock-MLG"));
    
    p.getInventory().setItem(0, stick);
    if (KnockFFA.getAngel()) {
      p.getInventory().setItem(1, enterhaken);
    }
    if (KnockFFA.getBlock()) {
      p.getInventory().setItem(8, mlg);
    }
    e.setRespawnLocation(API_Location.getLocation("spawn"));
  }
}
