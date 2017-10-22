package de.Dominik.KnockbackFFA.Listener.de;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

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

public class LISTENER_Navigator
  implements Listener
{
  @EventHandler
  public void onClick(InventoryClickEvent e)
  {
    try
    {
      Player p = (Player)e.getWhoClicked();
      if ((e.getClickedInventory() != null) && (e.getCurrentItem() != null) && 
        (!KnockFFA.main.ingame.contains(p)))
      {
        e.setCancelled(true);
        if (e.getClickedInventory().getTitle().equals("§cNavigator §7(Rechtsklick)"))
        {
          String playerName = e.getCurrentItem().getItemMeta().getDisplayName();
          if (KnockFFA.main.ingame.contains(Bukkit.getPlayer(playerName)))
          {
            Player tar = Bukkit.getPlayer(playerName);
            p.teleport(tar);
            p.sendMessage(
              KnockFFA.main.sy + "§7Du wurdest zu §e" + tar.getDisplayName() + " §7teleportiert");
          }
          else
          {
            p.sendMessage(KnockFFA.main.sy + "§7Dieser Spieler ist nicht mehr am §eLeben");
          }
        }
      }
    }
    catch (Exception e1)
    {
      e1.getMessage();
    }
  }
  
  @EventHandler
  public void onInteract(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((!KnockFFA.main.ingame.contains(p)) && 
      (p.getItemInHand().getType() == Material.COMPASS))
    {
      int length = KnockFFA.main.ingame.size() / 9 + 1;
      Inventory inv = Bukkit.createInventory(null, 9 * length, "§cNavigator §7(Rechtsklick)");
      for (Player ingame : KnockFFA.main.ingame)
      {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta skullmeta = (SkullMeta)head.getItemMeta();
        skullmeta.setOwner(ingame.getName());
        skullmeta.setDisplayName(ingame.getName());
        head.setItemMeta(skullmeta);
        inv.addItem(new ItemStack[] { head });
      }
      p.openInventory(inv);
    }
  }
}
