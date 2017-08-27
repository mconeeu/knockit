package KnockbackFFA.Hologramm.de;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;

import java.util.Iterator;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.plugin.Plugin;

import KnockbackFFA.Main.de.KnockFFA;
import me.BukkitCoreSystem.Main.de.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Dominik l.
 * Aka xXTwinsterHDXx
 * created on: 19.08.2017
 */
public class PlayerHolograms {
    private List<EntityArmorStand> entitylist;
    private String[] Text;
    private Location location;
    private double DISTANCE;
    int count;

    public PlayerHolograms(final String[] Text, final Location location) {
        this.entitylist = new ArrayList<EntityArmorStand>();
        this.DISTANCE = 0.25;
        this.Text = Text;
        this.location = location;
        this.create();
    }

    public void showPlayerTemp(final Player p, final int Time) {
        this.showPlayer(p);
        Bukkit.getScheduler().runTaskLater((Plugin) KnockFFA.getInstance(), (Runnable)new Runnable() {
            @Override
            public void run() {
                PlayerHolograms.this.hidePlayer(p);
            }
        }, (long)Time);
    }

    public void showAllTemp(final Player p, final int Time) {
        this.showAll();
        Bukkit.getScheduler().runTaskLater((Plugin)KnockFFA.getInstance(), (Runnable)new Runnable() {
            @Override
            public void run() {
                PlayerHolograms.this.hideAll();
            }
        }, (long)Time);
    }

    public void showPlayer(final Player p) {
        for (final EntityArmorStand armor : this.entitylist) {
            final PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving((EntityLiving)armor);
            ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)packet);
        }
    }

    public void hidePlayer(final Player p) {
        for (final EntityArmorStand armor : this.entitylist) {
            final PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(new int[] { armor.getId() });
            ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)packet);
        }
    }

    public void showAll() {
        for (final Player player : Bukkit.getOnlinePlayers()) {
            for (final EntityArmorStand armor : this.entitylist) {
                final PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving((EntityLiving)armor);
                ((CraftPlayer)player).getHandle().playerConnection.sendPacket((Packet)packet);
            }
        }
    }

    public void hideAll() {
        for (final Player player : Bukkit.getOnlinePlayers()) {
            for (final EntityArmorStand armor : this.entitylist) {
                final PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(new int[] { armor.getId() });
                ((CraftPlayer)player).getHandle().playerConnection.sendPacket((Packet)packet);
            }
        }
    }

    private void create() {
        String[] text;
        for (int length = (text = this.Text).length, j = 0; j < length; ++j) {
            final String Text = text[j];
            final EntityArmorStand entity = new EntityArmorStand((World)((CraftWorld)this.location.getWorld()).getHandle(), this.location.getX(), this.location.getY(), this.location.getZ());
            entity.setCustomName(Text);
            entity.setCustomNameVisible(true);
            entity.setInvisible(true);
            entity.setGravity(false);
            this.entitylist.add(entity);
            this.location.subtract(0.0, this.DISTANCE, 0.0);
            ++this.count;
        }
        for (int i = 0; i < this.count; ++i) {
            this.location.add(0.0, this.DISTANCE, 0.0);
        }
        this.count = 0;
    }
}
