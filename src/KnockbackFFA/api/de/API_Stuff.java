package KnockbackFFA.api.de;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class API_Stuff{
  public void clearPlayer(Player p){
    p.setHealth(20.0D);
    p.setFoodLevel(20);
    p.setLevel(0);
    p.setExp(0.0F);
    p.getInventory().clear();
    p.getInventory().setArmorContents(null);
    for (PotionEffect effect : p.getActivePotionEffects()) {
      p.removePotionEffect(effect.getType());
    }
  }
}
