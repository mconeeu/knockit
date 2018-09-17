/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.kitinventorys;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class KitsInventory extends CoreInventory {


    public KitsInventory(Player p) {
        super("§8» §e§lHändler §8| §fKits", p, 9 * 3, CoreInventory.Option.FILL_EMPTY_SLOTS);

        final CorePlayer ck = CoreSystem.getInstance().getCorePlayer(p);


        setItem(InventorySlot.ROW_2_SLOT_3, new ItemBuilder(Material.GOLD_CHESTPLATE, 1, 0).displayName("§6Gold-Kit").lore("", "§f§oMit diesem Kit erhälst du", "§f§oFolgende Vorteile :", "", "§6» §7Stein Schwerd", "§6» §7Enterhaken", "§6» §7Knockback-Stick", "§6» §7Bogen", "§6» §7Pfeile", "§6» §7Ketten Rüstung", "", "§fKosten 15 Coins", "", "§4§lACHTUNG DU HAST DIESES KIT NUR EIN MAL !").create(),
                e -> {


                    if ((ck.getCoins() - 15) >= 0) {
                        ck.removeCoins(15);
                    } else {
                        p.sendMessage("§8[§7§l!§8] §2KnockIt §8» §7Du hast nich genügend Coins");
                    }

                    p.getInventory().clear();
                    p.closeInventory();

                    p.sendMessage("§8[§7§l!§8] §2KnockIt §8» §7Du hast das §6Gold-Kit §7erfolgreich gekauft");

                        p.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
        p.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
        p.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
        p.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));


        ItemStack i1 = new ItemStack(Material.STONE_SWORD);
        ItemMeta m1 = i1.getItemMeta();
        m1.setDisplayName("§8» §b§lStein Schwerd");
        m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        i1.setItemMeta(m1);

        ItemStack i2 = new ItemStack(Material.FISHING_ROD);
        ItemMeta m2 = i2.getItemMeta();
        m2.setDisplayName("§8» §f§lEnterhaken");
        i2.setItemMeta(m2);

        ItemStack i3 = new ItemStack(Material.STICK);
        ItemMeta m3 = i3.getItemMeta();
        m3.setDisplayName("§8» §5§lKnockback-Stick");
        m3.addEnchant(Enchantment.KNOCKBACK, 2, true);
        i3.setItemMeta(m3);

        ItemStack i4 = new ItemStack(Material.BOW);
        ItemMeta m4 = i4.getItemMeta();
        m4.setDisplayName("§8» §d§lBogen");
        i4.setItemMeta(m4);

        p.getInventory().setItem(11 - 1, new ItemBuilder(Material.ARROW, 3, 0).displayName("§8» §6§lPfeile").create());

        p.getInventory().setItem(0, i1);
        p.getInventory().setItem(1, i2);
        p.getInventory().setItem(2, i3);
        p.getInventory().setItem(3, i4);
                });


        setItem(InventorySlot.ROW_2_SLOT_7, new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1, 0).displayName("§bDiamanten-Kit").lore("", "§f§oMit diesem Kit erhälst du", "§f§oFolgende Vorteile :", "", "§6» §7Stein Schwerd", "§6» §7Enterhaken", "§6» §7Knockback-Stick", "§6» §7Enderperle", "§6» §7Eisen Brustplatte", "§6» §7Ketten Rüstung", "", "§fKosten 25 Coins", "", "§4§lACHTUNG DU HAST DIESES KIT NUR EIN MAL !").create(),
                e -> {


                    if ((ck.getCoins() - 25) >= 0) {
                        ck.removeCoins(25);
                    } else {
                        p.sendMessage("§8[§7§l!§8] §2KnockIt §8» §7Du hast nich genügend Coins");
                    }

                    p.getInventory().clear();
                    p.closeInventory();

                    p.sendMessage("§8[§7§l!§8] §2KnockIt §8» §7Du hast das §bDiamanten-Kit §7erfolgreich gekauft");

                    p.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
                    p.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
                    p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                    p.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));


                    ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                    ItemMeta m1 = i1.getItemMeta();
                    m1.setDisplayName("§8» §b§lStein Schwerd");
                    m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                    i1.setItemMeta(m1);

                    ItemStack i2 = new ItemStack(Material.FISHING_ROD);
                    ItemMeta m2 = i2.getItemMeta();
                    m2.setDisplayName("§8» §f§lEnterhaken");
                    i2.setItemMeta(m2);

                    ItemStack i3 = new ItemStack(Material.STICK);
                    ItemMeta m3 = i3.getItemMeta();
                    m3.setDisplayName("§8» §5§lKnockback-Stick");
                    m3.addEnchant(Enchantment.KNOCKBACK, 2, true);
                    i3.setItemMeta(m3);

                    ItemStack i5 = new ItemStack(Material.ENDER_PEARL);
                    ItemMeta m5 = i5.getItemMeta();
                    m5.setDisplayName("§8» §5§lEnderperle");
                    i5.setItemMeta(m5);


                    p.getInventory().setItem(0, i1);
                    p.getInventory().setItem(1, i2);
                    p.getInventory().setItem(2, i3);
                    p.getInventory().setItem(3, i5);
                });



        openInventory();
    }


}
