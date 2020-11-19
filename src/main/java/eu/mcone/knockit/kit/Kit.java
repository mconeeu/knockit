/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.kit;

import eu.mcone.coresystem.api.bukkit.inventory.PlayerInventorySlot;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.knockit.gadgets.Gadget;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Kit {

    public static final eu.mcone.gameapi.api.kit.Kit DEFAULT = new eu.mcone.gameapi.api.kit.Kit(
            "Standard",
            new ItemBuilder(Material.WOOD_SWORD)
                    .displayName("§7Standard-Kit")
                    .lore(
                            "",
                            "§7§oMit diesem Kit erhälst du:",
                            "§8» §7Stein Schwert",
                            "§8» §7Angel",
                            "§8» §7Knockback-Stick",
                            "§8» §7Bogen",
                            "§8» §7Pfeile",
                            "§8» §7Ketten Rüstung",
                            "",
                            "§7Kosten: §f100 Coins",
                            "§2§oBenutze die AutoBuy-Funktion, damit",
                            "§2§okaufst du das Kit automatisch erneut!"
                    )
                    .itemFlags(ItemFlag.HIDE_ATTRIBUTES)
                    .create(),
            new HashMap<Integer, ItemStack>() {{
                put(PlayerInventorySlot.BOOTS, new ItemBuilder(Material.LEATHER_BOOTS)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.LEGGINGS, new ItemBuilder(Material.LEATHER_LEGGINGS)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.CHESTPLATE, new ItemBuilder(Material.LEATHER_CHESTPLATE)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HELMET, new ItemBuilder(Material.LEATHER_HELMET)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );

                put(PlayerInventorySlot.HOTBAR_SLOT_1, new ItemBuilder(Material.WOOD_SWORD)
                        .displayName("§8» §b§lHolz Schwert")
                        .lore("§7§oStandard-Kit")
                        .enchantment(Enchantment.DAMAGE_ALL, 1)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_2, new ItemBuilder(Material.FISHING_ROD)
                        .displayName("§8» §f§lAngel")
                        .lore("§7§oStandard-Kit")
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_3, new ItemBuilder(Material.STICK)
                        .displayName("§8» §5§lKnockback-Stick")
                        .lore("§7§oStandard-Kit")
                        .enchantment(Enchantment.KNOCKBACK, 1)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_9, new ItemBuilder(Material.QUARTZ_BLOCK, 3)
                        .displayName("§8» §6§lMLG-Block")
                        .lore("§7§oStandard-Kit")
                        .create()
                );
            }},
            0
    );

    public static final eu.mcone.gameapi.api.kit.Kit ARCHER = new eu.mcone.gameapi.api.kit.Kit(
            "Bogenschütze",
            new ItemBuilder(Material.BOW)
                    .displayName("§6Bogenschützen-Kit")
                    .lore(
                            "",
                            "§7§oMit diesem Kit erhälst du:",
                            "§8» §6Stein Schwert",
                            "§8» §6Angel",
                            "§8» §6Knockback-Stick",
                            "§8» §6Bogen",
                            "§8» §6Pfeile",
                            "§8» §6Ketten Rüstung",
                            "",
                            "§7Kosten: §f100 Coins",
                            "§2§oBenutze die AutoBuy-Funktion, damit",
                            "§2§okaufst du das Kit automatisch erneut!"
                    )
                    .create(),
            new HashMap<Integer, ItemStack>() {{
                put(PlayerInventorySlot.BOOTS, new ItemBuilder(Material.LEATHER_BOOTS)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.LEGGINGS, new ItemBuilder(Material.LEATHER_LEGGINGS)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.CHESTPLATE, new ItemBuilder(Material.LEATHER_CHESTPLATE)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HELMET, new ItemBuilder(Material.LEATHER_HELMET)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );

                put(PlayerInventorySlot.HOTBAR_SLOT_1, new ItemBuilder(Material.STONE_SWORD)
                        .displayName("§8» §b§lStein Schwert")
                        .lore("§6§oBogenschützen-Kit")
                        .enchantment(Enchantment.DAMAGE_ALL, 1)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_2, new ItemBuilder(Material.FISHING_ROD)
                        .displayName("§8» §f§lAngel")
                        .lore("§6§oBogenschützen-Kit")
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_3, new ItemBuilder(Material.STICK)
                        .displayName("§8» §5§lKnockback-Stick")
                        .lore("§6§oBogenschützen-Kit")
                        .enchantment(Enchantment.KNOCKBACK, 1)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_4, new ItemBuilder(Material.BOW)
                        .displayName("§8» §d§lBogen")
                        .lore("§6§oBogenschützen-Kit")
                        .unbreakable(true)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_9, new ItemBuilder(Material.QUARTZ_BLOCK)
                        .displayName("§8» §6§lMLG-Block")
                        .lore("§6§oBogenschützen-Kit")
                        .create()
                );
                put(PlayerInventorySlot.ROW_1_SLOT_1, new ItemBuilder(Material.ARROW, 3, 0)
                        .displayName("§8» §6§lPfeile")
                        .lore("§6§oBogenschützen-Kit")
                        .create()
                );
            }},
            100
    );

    public static final eu.mcone.gameapi.api.kit.Kit KNOCKBACK = new eu.mcone.gameapi.api.kit.Kit(
            "Knockbacker",
            new ItemBuilder(Material.STICK)
                    .enchantment(Enchantment.KNOCKBACK, 2)
                    .itemFlags(ItemFlag.HIDE_ENCHANTS)
                    .displayName("§aKnockback-Kit")
                    .lore(
                            "",
                            "§7§oMit diesem Kit erhälst du:",
                            "§8» §aStein Schwert",
                            "§8» §aAngel",
                            "§8» §aKnockback-Stick auf Stufe 2",
                            "§8» §aKetten Rüstung",
                            "",
                            "§7Kosten: §f100 Coins",
                            "§2§oBenutze die AutoBuy-Funktion, damit",
                            "§2§okaufst du das Kit automatisch erneut!"
                    )
                    .create(),
            new HashMap<Integer, ItemStack>() {{
                put(PlayerInventorySlot.BOOTS, new ItemBuilder(Material.LEATHER_BOOTS)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.LEGGINGS, new ItemBuilder(Material.LEATHER_LEGGINGS)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.CHESTPLATE, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HELMET, new ItemBuilder(Material.LEATHER_HELMET)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );

                put(PlayerInventorySlot.HOTBAR_SLOT_1, new ItemBuilder(Material.STONE_SWORD)
                        .displayName("§8» §b§lStein Schwerd")
                        .lore("§a§oKnockbacl-Kit")
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .enchantment(Enchantment.DAMAGE_ALL, 2)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_2, new ItemBuilder(Material.FISHING_ROD)
                        .displayName("§8» §f§lAngel")
                        .lore("§a§oKnockbacl-Kit")
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_3, new ItemBuilder(Material.STICK)
                        .displayName("§8» §5§lKnockback-Stick")
                        .lore("§a§oKnockbacl-Kit")
                        .enchantment(Enchantment.KNOCKBACK, 1)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_9, new ItemBuilder(Material.QUARTZ_BLOCK)
                        .displayName("§8» §6§lMLG-Block")
                        .lore("§a§oKnockbacl-Kit")
                        .create()
                );
            }},
            100
    );

    public static final eu.mcone.gameapi.api.kit.Kit GRAPLING_HOOK = new eu.mcone.gameapi.api.kit.Kit(
            "Enterhacken",
            new ItemBuilder(Material.FISHING_ROD)
                    .displayName("§dEnterhaken-Kit")
                    .lore(
                            "",
                            "§7§oMit diesem Kit erhälst du:",
                            "§8» §dStein Schwert",
                            "§8» §dEnterhacken",
                            "§8» §dKnockback-Stick",
                            "§8» §dEisen Brustplatte",
                            "§8» §dKetten Rüstung",
                            "",
                            "§7Kosten: §f125 Coins",
                            "§2§oBenutze die AutoBuy-Funktion, damit",
                            "§2§okaufst du das Kit automatisch erneut!"
                    )
                    .create(),
            new HashMap<Integer, ItemStack>() {{
                put(PlayerInventorySlot.BOOTS, new ItemBuilder(Material.LEATHER_BOOTS)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.LEGGINGS, new ItemBuilder(Material.LEATHER_LEGGINGS)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.CHESTPLATE, new ItemBuilder(Material.GOLD_CHESTPLATE)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HELMET, new ItemBuilder(Material.LEATHER_HELMET)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );

                put(PlayerInventorySlot.HOTBAR_SLOT_1, new ItemBuilder(Material.STONE_SWORD)
                        .displayName("§8» §b§lStein Schwert")
                        .lore("§d§oEnterhaken-Kit")
                        .enchantment(Enchantment.DAMAGE_ALL, 1)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_2, new ItemBuilder(Material.FISHING_ROD)
                        .displayName("§8§ §d§lEnterhaken")
                        .lore("§d§oEnterhaken-Kit")
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
                        .itemFlags(ItemFlag.HIDE_ENCHANTS)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_3, new ItemBuilder(Material.STICK)
                        .displayName("§8» §5§lKnockback-Stick")
                        .lore("§d§oEnterhaken-Kit")
                        .enchantment(Enchantment.KNOCKBACK, 1)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_4, new ItemBuilder(Material.QUARTZ_BLOCK)
                        .displayName("§8» §6§lMLG-Block")
                        .lore("§d§oEnterhaken-Kit")
                        .create()
                );
            }},
            125
    );

    public static final eu.mcone.gameapi.api.kit.Kit BIG_HITTER = new eu.mcone.gameapi.api.kit.Kit(
            "Big Hitter",
            new ItemBuilder(Material.BLAZE_ROD)
                    .displayName("§eBig Hitter-Kit")
                    .lore(
                            "",
                            "§7§oMit diesem Kit erhälst du:",
                            "§8» §eStein Schwert",
                            "§8» §eEin schlag mit Knockback 6",
                            "§8» §eAngel",
                            "§8» §eEisen Brustplatte",
                            "§8» §eKetten Rüstung",
                            "",
                            "§7Kosten: §f165 Coins",
                            "§2§oBenutze die AutoBuy-Funktion, damit",
                            "§2§okaufst du das Kit automatisch erneut!"
                    )
                    .create(),
            new HashMap<Integer, ItemStack>() {{
                put(PlayerInventorySlot.BOOTS, new ItemBuilder(Material.LEATHER_BOOTS)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.LEGGINGS, new ItemBuilder(Material.LEATHER_LEGGINGS)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.CHESTPLATE, new ItemBuilder(Material.IRON_CHESTPLATE)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HELMET, new ItemBuilder(Material.LEATHER_HELMET)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );

                put(PlayerInventorySlot.HOTBAR_SLOT_1, new ItemBuilder(Material.STONE_SWORD)
                        .displayName("§8» §b§lStein Schwert")
                        .lore("§b§oBigHitter-Kit")
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .enchantment(Enchantment.DAMAGE_ALL, 2)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_2, new ItemBuilder(Material.FISHING_ROD)
                        .displayName("§8» §f§lAngel")
                        .lore("§b§oBigHitter-Kit")
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_3, new ItemBuilder(Material.BLAZE_ROD)
                        .displayName("§8» §b§lBig Hitter Stock")
                        .lore("§b§oBigHitter-Kit")
                        .unbreakable(false)
                        .enchantment(Enchantment.KNOCKBACK, 6)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_9, new ItemBuilder(Material.QUARTZ_BLOCK)
                        .displayName("§8» §6§lMLG-Block")
                        .lore("§b§oBigHitter-Kit")
                        .create()
                );
            }},
            195
    );

    public static final eu.mcone.gameapi.api.kit.Kit JETPACK = new eu.mcone.gameapi.api.kit.Kit(
            "Jetpack",
            new ItemBuilder(Material.FIREWORK)
                    .displayName("§eJetPack-Kit")
                    .lore(
                            "",
                            "§7§oMit diesem Kit erhälst du:",
                            "§8» §eStein Schwert",
                            "§8» §eJetPack Gegenstand",
                            "§8» §eEisen Brustplatte",
                            "§8» §eKetten Rüstung",
                            "",
                            "§7Kosten: §f165 Coins",
                            "§2§oBenutze die AutoBuy-Funktion, damit",
                            "§2§okaufst du das Kit automatisch erneut!"
                    )
                    .create(),
            new HashMap<Integer, ItemStack>() {{
                put(PlayerInventorySlot.BOOTS, new ItemBuilder(Material.LEATHER_BOOTS)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.LEGGINGS, new ItemBuilder(Material.LEATHER_LEGGINGS)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.CHESTPLATE, new ItemBuilder(Material.IRON_CHESTPLATE)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HELMET, new ItemBuilder(Material.LEATHER_HELMET)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );

                put(PlayerInventorySlot.HOTBAR_SLOT_1, new ItemBuilder(Material.STONE_SWORD)
                        .displayName("§8» §b§lStein Schwert")
                        .lore("§b§oJetPack-Kit")
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .enchantment(Enchantment.DAMAGE_ALL, 2)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_3, Gadget.ROCKET.getItem());

                put(PlayerInventorySlot.HOTBAR_SLOT_2, new ItemBuilder(Material.STICK)
                        .displayName("§8» §5§lKnockback-Stick")
                        .lore("§b§oJetPack-Kit")
                        .enchantment(Enchantment.KNOCKBACK, 1)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_9, new ItemBuilder(Material.QUARTZ_BLOCK)
                        .displayName("§8» §6§lMLG-Block")
                        .lore("§b§oJetPack-Kit")
                        .create()
                );
            }},
            165
    );

    public static final eu.mcone.gameapi.api.kit.Kit ENDERMAN = new eu.mcone.gameapi.api.kit.Kit(
            "Enderman",
            new ItemBuilder(Material.ENDER_PEARL)
                    .displayName("§dEnderman-Kit")
                    .lore(
                            "",
                            "§7§oMit diesem Kit erhälst du:",
                            "§8» §dStein Schwert",
                            "§8» §dAngel",
                            "§8» §dKnockback-Stick",
                            "§8» §dEnderperle",
                            "§8» §dEisen Brustplatte",
                            "§8» §dKetten Rüstung",
                            "",
                            "§7Kosten: §f150 Coins",
                            "§2§oBenutze die AutoBuy-Funktion, damit",
                            "§2§okaufst du das Kit automatisch erneut!"
                    )
                    .create(),
            new HashMap<Integer, ItemStack>() {{
                put(PlayerInventorySlot.BOOTS, new ItemBuilder(Material.LEATHER_BOOTS)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.LEGGINGS, new ItemBuilder(Material.LEATHER_LEGGINGS)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.CHESTPLATE, new ItemBuilder(Material.IRON_CHESTPLATE)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HELMET, new ItemBuilder(Material.LEATHER_HELMET)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );

                put(PlayerInventorySlot.HOTBAR_SLOT_1, new ItemBuilder(Material.STONE_SWORD)
                        .displayName("§8» §b§lStein Schwert")
                        .lore("§b§oEnderman-Kit")
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .enchantment(Enchantment.DAMAGE_ALL, 2)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_2, new ItemBuilder(Material.FISHING_ROD)
                        .displayName("§8» §f§lAngel")
                        .lore("§b§oEnderman-Kit")
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_UNBREAKABLE)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_3, new ItemBuilder(Material.STICK)
                        .displayName("§8» §5§lKnockback-Stick")
                        .lore("§b§oEnderman-Kit")
                        .enchantment(Enchantment.KNOCKBACK, 1)
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_4, new ItemBuilder(Material.ENDER_PEARL, 3, 0)
                        .displayName("§8» §5§lEnderperle")
                        .lore("§b§oEnderman-Kit")
                        .create()
                );
                put(PlayerInventorySlot.HOTBAR_SLOT_9, new ItemBuilder(Material.QUARTZ_BLOCK)
                        .displayName("§8» §6§lMLG-Block")
                        .lore("§b§oEnderman-Kit")
                        .create()
                );
            }},
            150
    );

}
