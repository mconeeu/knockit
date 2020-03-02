/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.kit;

import eu.mcone.coresystem.api.bukkit.inventory.PlayerInventorySlot;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Kit {

    public static final eu.mcone.gameapi.api.kit.Kit DEFAULT = new eu.mcone.gameapi.api.kit.Kit(
            "standard",
            new ItemBuilder(Material.WOOD_SWORD)
                    .displayName("§7Standard-Kit")
                    .lore(
                            "",
                            "§f§oMit diesem Kit erhälst du",
                            "§f§ofolgende Items:",
                            "",
                            "§6» §7Stein Schwert",
                            "§6» §7Angel",
                            "§6» §7Knockback-Stick",
                            "§6» §7Bogen",
                            "§6» §7Pfeile",
                            "§6» §7Ketten Rüstung",
                            "",
                            "§fKosten 100 Coins",
                            "",
                            "§4§lACHTUNG DU HAST DIESES KIT NUR EIN MAL!"
                    )
                    .create(),
            new HashMap<Integer, ItemStack>(){{
                put(PlayerInventorySlot.BOOTS, new ItemStack(Material.LEATHER_BOOTS));
                put(PlayerInventorySlot.LEGGINGS, new ItemStack(Material.LEATHER_LEGGINGS));
                put(PlayerInventorySlot.CHESTPLATE, new ItemStack(Material.IRON_CHESTPLATE));
                put(PlayerInventorySlot.HELMET, new ItemStack(Material.LEATHER_HELMET));

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
            "archer",
            new ItemBuilder(Material.BOW)
                    .displayName("§6Bogenschützen-Kit")
                    .lore(
                            "",
                            "§f§oMit diesem Kit erhälst du",
                            "§f§ofolgende Items:",
                            "",
                            "§6» §7Stein Schwert",
                            "§6» §7Angel",
                            "§6» §7Knockback-Stick",
                            "§6» §7Bogen",
                            "§6» §7Pfeile",
                            "§6» §7Ketten Rüstung",
                            "", "§fKosten 100 Coins",
                            "",
                            "§4§lACHTUNG DU HAST DIESES KIT NUR EIN MAL!"
                    )
                    .create(),
            new HashMap<Integer, ItemStack>(){{
                put(PlayerInventorySlot.BOOTS, new ItemStack(Material.CHAINMAIL_BOOTS));
                put(PlayerInventorySlot.LEGGINGS, new ItemStack(Material.CHAINMAIL_LEGGINGS));
                put(PlayerInventorySlot.CHESTPLATE, new ItemStack(Material.CHAINMAIL_CHESTPLATE));
                put(PlayerInventorySlot.HELMET, new ItemStack(Material.CHAINMAIL_HELMET));

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
            "knockback",
            new ItemBuilder(Material.STICK)
                    .enchantment(Enchantment.KNOCKBACK, 2)
                    .itemFlags(ItemFlag.HIDE_ENCHANTS)
                    .displayName("§aKnockback-Kit")
                    .lore(
                            "",
                            "§f§oMit diesem Kit erhälst du",
                            "§f§ofolgende Items:",
                            "",
                            "§6» §7Stein Schwert",
                            "§6» §7Angel",
                            "§6» §7Knockback-Stick auf Stufe 2",
                            "§6» §7Ketten Rüstung",
                            "", "§fKosten 100 Coins",
                            "",
                            "§4§lACHTUNG DU HAST DIESES KIT NUR EIN MAL!"
                    )
                    .create(),
            new HashMap<Integer, ItemStack>(){{
                put(PlayerInventorySlot.BOOTS, new ItemStack(Material.CHAINMAIL_BOOTS));
                put(PlayerInventorySlot.LEGGINGS, new ItemStack(Material.CHAINMAIL_LEGGINGS));
                put(PlayerInventorySlot.CHESTPLATE, new ItemStack(Material.CHAINMAIL_CHESTPLATE));
                put(PlayerInventorySlot.HELMET, new ItemStack(Material.CHAINMAIL_HELMET));

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
                put(PlayerInventorySlot.HOTBAR_SLOT_4, new ItemBuilder(Material.ENDER_PEARL,2,0)
                        .displayName("§8» §5§lEnderperle")
                        .lore("§a§oKnockbacl-Kit")
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
            "grapling_hook",
            new ItemBuilder(Material.FISHING_ROD)
                    .displayName("§dEnterhaken-Kit")
                    .lore(
                            "",
                            "§f§oMit diesem Kit erhälst du",
                            "§f§ofolgende Kit:",
                            "",
                            "§6» §7Stein Schwert",
                            "§6» §7Enterhacken",
                            "§6» §7Knockback-Stick",
                            "§6» §7Enderperle",
                            "§6» §7Eisen Brustplatte",
                            "§6» §7Ketten Rüstung",
                            "",
                            "§fKosten 125 Coins",
                            "",
                            "§4§lACHTUNG DU HAST DIESES KIT NUR EIN MAL!"
                    )
                    .create(),
            new HashMap<Integer, ItemStack>(){{
                put(PlayerInventorySlot.BOOTS, new ItemStack(Material.CHAINMAIL_BOOTS));
                put(PlayerInventorySlot.LEGGINGS, new ItemStack(Material.CHAINMAIL_LEGGINGS));
                put(PlayerInventorySlot.CHESTPLATE, new ItemStack(Material.CHAINMAIL_CHESTPLATE));
                put(PlayerInventorySlot.HELMET, new ItemStack(Material.CHAINMAIL_HELMET));

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

    public static final eu.mcone.gameapi.api.kit.Kit ENDERMAN = new eu.mcone.gameapi.api.kit.Kit(
            "enderman",
            new ItemBuilder(Material.ENDER_PEARL)
                    .displayName("§bEnderman-Kit")
                    .lore(
                            "",
                            "§f§oMit diesem Kit erhälst du",
                            "§f§ofolgende Kit:",
                            "",
                            "§6» §7Stein Schwert",
                            "§6» §7Angel",
                            "§6» §7Knockback-Stick",
                            "§6» §7Enderperle",
                            "§6» §7Eisen Brustplatte",
                            "§6» §7Ketten Rüstung",
                            "",
                            "§fKosten 150 Coins",
                            "",
                            "§4§lACHTUNG DU HAST DIESES KIT NUR EIN MAL!"
                    )
                    .create(),
            new HashMap<Integer, ItemStack>(){{
                put(PlayerInventorySlot.BOOTS, new ItemStack(Material.CHAINMAIL_BOOTS));
                put(PlayerInventorySlot.LEGGINGS, new ItemStack(Material.CHAINMAIL_LEGGINGS));
                put(PlayerInventorySlot.CHESTPLATE, new ItemStack(Material.CHAINMAIL_CHESTPLATE));
                put(PlayerInventorySlot.HELMET, new ItemStack(Material.CHAINMAIL_HELMET));

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
                put(PlayerInventorySlot.HOTBAR_SLOT_4, new ItemBuilder(Material.ENDER_PEARL,2,0)
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
