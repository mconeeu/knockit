package KnockbackFFA.Hologramm.de;

import me.BukkitCoreSystem.API.de.CoinsAPI;
import me.BukkitCoreSystem.API.de.StatsAPI;
import net.minecraft.server.v1_8_R3.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import KnockbackFFA.Main.de.KnockFFA;

public class PlayerHoloListener implements Listener{
	public static void Holo(final Player p) {
        WorldServer world = ((CraftWorld) Bukkit.getWorld("world")).getHandle();
        double x =  KnockFFA.main.getConfig().getDouble("holo" + ".X");
        double y = KnockFFA.main.getConfig().getDouble("holo" + ".Y");
        double z = KnockFFA.main.getConfig().getDouble("holo" + ".Z");
        final Location loc = new Location(Bukkit.getWorld("world"), x, y, z);

        final String[] Text = { "§7» §e§lKnockFFA", 
				        		"§7Stats von §f" + p.getName(), 
				        		"§r", 
				        		"§7Platz: §f" + StatsAPI.getUserRanking(p.getName()), 
				        		"§7Kills: §f" + StatsAPI.getKills(p.getUniqueId().toString(), p.getName()), 
				        		"§7Tode: §f" + StatsAPI.getDeaths(p.getUniqueId().toString(), p.getName()), 
				        		"§7Coins: §f" + CoinsAPI.getCoins(p)};
        final PlayerHolograms holo = new PlayerHolograms(Text, loc);
        holo.showPlayer(p);
    }
}
