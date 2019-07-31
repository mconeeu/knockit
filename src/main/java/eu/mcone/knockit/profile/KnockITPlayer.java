/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.profile;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.plugin.GamePlayerData;
import eu.mcone.coresystem.api.core.player.Group;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.gadgets.Gadgets;
import eu.mcone.knockit.kit.CustomKit;
import eu.mcone.knockit.kit.Kit;
import lombok.Getter;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Map;

public class KnockITPlayer extends GamePlayerData<KnockITPlayerProfile> {

    @Getter
    private transient Kit currentKit;
    @Getter
    private transient Gadgets currentGadget;

    @Getter
    private Map<String, CustomKit> customKits;

    public KnockITPlayer(CorePlayer player) {
        super(player);
        KnockIT.getInstance().registerKnockITPlayer(this);
    }

    @Override
    public KnockITPlayerProfile reload() {
        KnockITPlayerProfile profile = super.reload();
        this.customKits = profile.getCustomKits();

        return profile;
    }

    @Override
    protected KnockITPlayerProfile loadData() {
        return KnockIT.getInstance().loadGameProfile(corePlayer.bukkit(), KnockITPlayerProfile.class);
    }

    @Override
    public void saveData() {
        KnockIT.getInstance().saveGameProfile(new KnockITPlayerProfile(corePlayer.bukkit(), customKits));
    }

    public void modifyInventory(final Kit kit, final Map<String, Double> sortedItems) {
        customKits.put(String.valueOf(kit.getKitID()), new CustomKit(System.currentTimeMillis() / 1000, sortedItems));
    }

    public CustomKit getModifiedKit(Kit kit) {
        return customKits.getOrDefault(String.valueOf(kit.getKitID()), null);
    }

    public boolean isKitModified(Kit kit) {
        return customKits.containsKey(String.valueOf(kit.getKitID()));
    }

    public void setGadget(Gadgets gadget) {
        currentGadget = gadget;
        corePlayer.bukkit().getInventory().addItem(gadget.getItem());
    }

    public void removeGadget(Gadgets gadgets) {
        customKits = null;
        corePlayer.bukkit().getInventory().remove(gadgets.getItem());
    }

    public void setKit(Kit kit) {
        currentKit = kit;

        Player player = getCorePlayer().bukkit();
        CorePlayer corePlayer = CoreSystem.getInstance().getCorePlayer(player.getUniqueId());
        CustomKit customKit = getModifiedKit(kit);

        if (corePlayer.getGroups().contains(Group.ADMIN)) {
            player.getInventory().setHelmet(ItemBuilder.createLeatherArmorItem(Material.LEATHER_HELMET, Color.RED).create());
            player.getInventory().setLeggings(ItemBuilder.createLeatherArmorItem(Material.LEATHER_LEGGINGS, Color.RED).create());
            player.getInventory().setBoots(ItemBuilder.createLeatherArmorItem(Material.LEATHER_BOOTS, Color.RED).create());
        } else if (corePlayer.getGroups().contains(Group.DEVELOPER)) {
            player.getInventory().setHelmet(ItemBuilder.createLeatherArmorItem(Material.LEATHER_HELMET, Color.AQUA).create());
            player.getInventory().setLeggings(ItemBuilder.createLeatherArmorItem(Material.LEATHER_LEGGINGS, Color.AQUA).create());
            player.getInventory().setBoots(ItemBuilder.createLeatherArmorItem(Material.LEATHER_BOOTS, Color.AQUA).create());
        } else if (corePlayer.getGroups().contains(Group.SRMODERATOR)
                || corePlayer.getGroups().contains(Group.MODERATOR)
                || corePlayer.getGroups().contains(Group.SUPPORTER)
                || corePlayer.getGroups().contains(Group.JRSUPPORTER)) {
            player.getInventory().setHelmet(ItemBuilder.createLeatherArmorItem(Material.LEATHER_HELMET, Color.GREEN).create());
            player.getInventory().setLeggings(ItemBuilder.createLeatherArmorItem(Material.LEATHER_LEGGINGS, Color.GREEN).create());
            player.getInventory().setBoots(ItemBuilder.createLeatherArmorItem(Material.LEATHER_BOOTS, Color.GREEN).create());
        } else if (corePlayer.getGroups().contains(Group.BUILDER)) {
            player.getInventory().setHelmet(ItemBuilder.createLeatherArmorItem(Material.LEATHER_HELMET, Color.YELLOW).create());
            player.getInventory().setLeggings(ItemBuilder.createLeatherArmorItem(Material.LEATHER_LEGGINGS, Color.YELLOW).create());
            player.getInventory().setBoots(ItemBuilder.createLeatherArmorItem(Material.LEATHER_BOOTS, Color.YELLOW).create());
        } else if (corePlayer.getGroups().contains(Group.TEAM)) {
            player.getInventory().setHelmet(ItemBuilder.createLeatherArmorItem(Material.LEATHER_HELMET, Color.WHITE).create());
            player.getInventory().setLeggings(ItemBuilder.createLeatherArmorItem(Material.LEATHER_LEGGINGS, Color.WHITE).create());
            player.getInventory().setBoots(ItemBuilder.createLeatherArmorItem(Material.LEATHER_BOOTS, Color.WHITE).create());
        } else if (corePlayer.getGroups().contains(Group.YOUTUBER)) {
            player.getInventory().setHelmet(ItemBuilder.createLeatherArmorItem(Material.LEATHER_HELMET, Color.PURPLE).create());
            player.getInventory().setLeggings(ItemBuilder.createLeatherArmorItem(Material.LEATHER_LEGGINGS, Color.PURPLE).create());
            player.getInventory().setBoots(ItemBuilder.createLeatherArmorItem(Material.LEATHER_BOOTS, Color.PURPLE).create());
        } else if (corePlayer.getGroups().contains(Group.PREMIUMPLUS)
                || corePlayer.getGroups().contains(Group.PREMIUM)) {
            player.getInventory().setHelmet(ItemBuilder.createLeatherArmorItem(Material.LEATHER_HELMET, Color.ORANGE).create());
            player.getInventory().setLeggings(ItemBuilder.createLeatherArmorItem(Material.LEATHER_LEGGINGS, Color.ORANGE).create());
            player.getInventory().setBoots(ItemBuilder.createLeatherArmorItem(Material.LEATHER_BOOTS, Color.ORANGE).create());
        } else {
            player.getInventory().setHelmet(ItemBuilder.createLeatherArmorItem(Material.LEATHER_HELMET, Color.GRAY).create());
            player.getInventory().setLeggings(ItemBuilder.createLeatherArmorItem(Material.LEATHER_LEGGINGS, Color.GRAY).create());
            player.getInventory().setBoots(ItemBuilder.createLeatherArmorItem(Material.LEATHER_BOOTS, Color.GRAY).create());
        }

        player.getInventory().setChestplate(new ItemBuilder(Material.IRON_CHESTPLATE).create());

        if (customKit != null) {
            for (Map.Entry<String, Double> kitEntry : customKit.getCustomItems().entrySet()) {
                int slot = Integer.valueOf(kitEntry.getKey());
                Kit.KitItem kitItem = kit.getKitItem(kitEntry.getValue());

                if (kitItem != null) {
                    player.getInventory().setItem(slot, kitItem.getItemStack());
                }
            }
        } else {
            int slot = 0;
            for (Kit.KitItem kitItem : kit.getKitItems()) {
                player.getInventory().setItem(slot, kitItem.getItemStack());
                slot++;
            }
        }
    }
}
