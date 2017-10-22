package de.Dominik.KnockbackFFA.api.de;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * 
 * @author Dominik Lippl ©
 * 
 * @copyright You do not have the permission to decompile this plugin ©
 * @copyright All right are at the developer with me: Dominik Lippl ©
 * @copyright You can not change the source code ©
 *
 */

public class API_Item{
  public static ItemStack createItem(Material material, int subid, String displayname){
    ItemStack item = new ItemStack(material, 1, (short)subid);
    ItemMeta mitem = item.getItemMeta();
    mitem.setDisplayName(displayname);
    item.setItemMeta(mitem);
    
    return item;
  }
}
