/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.kit;

import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum Kit {

    DEFAULT(
            "§7Standard-Kit",
            new ItemBuilder(Material.LEATHER_CHESTPLATE)
                    .create(),
            0
    ),
    ARCHER(
            "§6Bogenschützen-Kit",
            new ItemBuilder(Material.GOLD_CHESTPLATE)
                    .displayName("§6Gold-Kit")
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
            100
    ),


    KNOCKBACK(
            "§aKnockback-Kit",
            new ItemBuilder(Material.CHAINMAIL_CHESTPLATE)
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
            100
    ),




    ENDERMAN(
            "§bEnderman-Kit",
            new ItemBuilder(Material.DIAMOND_CHESTPLATE)
                    .displayName("§bDiamanten-Kit")
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
            150
    );

    @Getter
    private String name;
    @Getter
    private ItemStack item;
    @Getter
    private int coins;

    Kit(String name, ItemStack item, int coins) {
        this.name = name;
        this.item = item;
        this.coins = coins;
    }

}
