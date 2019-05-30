/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.kit;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.util.ItemBuilder;
import eu.mcone.knockit.KnockIT;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class KitManager {

    public static void setKit(Player p, Kit kit) {
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        if ((cp.getCoins() - kit.getCoins()) >= 0) {
            cp.removeCoins(kit.getCoins());
            p.getInventory().clear();

            switch (kit) {
                case DEFAULT: {
                    p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                    p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                    p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                    p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));

                    p.getInventory().setItem(0, new ItemBuilder(Material.WOOD_SWORD).displayName("§8» §b§lHolz Schwert").enchantment(Enchantment.DAMAGE_ALL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    p.getInventory().setItem(1, new ItemBuilder(Material.FISHING_ROD).displayName("§8» §f§lEnterhaken").unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    p.getInventory().setItem(2, new ItemBuilder(Material.STICK).displayName("§8» §5§lKnockback-Stick").enchantment(Enchantment.KNOCKBACK, 1).create());
                    p.getInventory().setItem(8, new ItemBuilder(Material.QUARTZ_BLOCK, 3).displayName("§8» §6§lMLG-Block").create());

                    break;
                }
                case GOLD: {
                    p.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
                    p.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
                    p.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
                    p.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));

                    p.getInventory().setItem(0, new ItemBuilder(Material.STONE_SWORD).displayName("§8» §b§lStein Schwert").enchantment(Enchantment.DAMAGE_ALL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    p.getInventory().setItem(1, new ItemBuilder(Material.FISHING_ROD).displayName("§8» §f§lEnterhaken").unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    p.getInventory().setItem(2, new ItemBuilder(Material.STICK).displayName("§8» §5§lKnockback-Stick").enchantment(Enchantment.KNOCKBACK, 2).create());
                    p.getInventory().setItem(3, new ItemBuilder(Material.BOW).displayName("§8» §d§lBogen").create());
                    p.getInventory().setItem(8, new ItemBuilder(Material.QUARTZ_BLOCK).displayName("§8» §6§lMLG-Block").create());
                    p.getInventory().setItem(10, new ItemBuilder(Material.ARROW, 3, 0).displayName("§8» §6§lPfeile").create());

                    break;
                }
                case DIAMOND: {
                    p.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
                    p.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
                    p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                    p.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));

                    p.getInventory().setItem(0, new ItemBuilder(Material.STONE_SWORD).displayName("§8» §b§lStein Schwerd").unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).enchantment(Enchantment.DAMAGE_ALL, 2).create());
                    p.getInventory().setItem(1, new ItemBuilder(Material.FISHING_ROD).displayName("§8» §f§lEnterhaken").unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create());
                    p.getInventory().setItem(2, new ItemBuilder(Material.STICK).displayName("§8» §5§lKnockback-Stick").enchantment(Enchantment.KNOCKBACK, 2).create());
                    p.getInventory().setItem(3, new ItemBuilder(Material.ENDER_PEARL).displayName("§8» §5§lEnderperle").create());
                    p.getInventory().setItem(8, new ItemBuilder(Material.QUARTZ_BLOCK).displayName("§8» §6§lMLG-Block").create());

                    break;
                }
            }

            if (kit != Kit.DEFAULT) {
                p.sendMessage("§8[§7§l!§8] §2KnockIt §8» §7Du hast das "+kit.getName()+" §7erfolgreich für "+kit.getCoins()+" Coins gekauft");
            }
        } else {
            KnockIT.getInstance().getMessager().send(p, "Du hast nich genügend Coins");
        }
    }

}
