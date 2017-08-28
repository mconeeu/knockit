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

        final String[] Text = { "§7» §aKnockFFA", "§7Stats von §2§l" + p.getName(), "§r", "§7Platz: §a§l" + StatsAPI.getUserRanking(p.getName()), "§7Kills: §a§l" + StatsAPI.getKills(p.getUniqueId().toString(), p.getName()), "§7Tode: §a§l" + StatsAPI.getDeaths(p.getUniqueId().toString(), p.getName()), "§7Coins: §a§l" + CoinsAPI.getCoins(p)};
        final PlayerHolograms holo = new PlayerHolograms(Text, loc);
        holo.showPlayer(p);
    }
}
