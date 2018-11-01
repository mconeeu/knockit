/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.kit;

import eu.mcone.coresystem.api.bukkit.util.ItemBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum Kit {

    DEFAULT(
            "§7Standard-Kit",
            new ItemBuilder(Material.LEATHER_CHESTPLATE)
                    .displayName("§7Standard-Kit")
                    .lore(
                            "",
                            "§f§oMit diesem Kit hast du",
                            "§f§ofolgende Items:",
                            "",
                            "§6» §7Holz Schwert",
                            "§6» §7Enterhaken",
                            "§6» §7Knockback-Stick",
                            ""
                    )
                    .create(),
            0
    ),
    GOLD(
            "§6Gold-Kit",
            new ItemBuilder(Material.GOLD_CHESTPLATE)
                    .displayName("§6Gold-Kit")
                    .lore(
                            "",
                            "§f§oMit diesem Kit erhälst du",
                            "§f§ofolgende Items:",
                            "",
                            "§6» §7Stein Schwert",
                            "§6» §7Enterhaken",
                            "§6» §7Knockback-Stick",
                            "§6» §7Bogen",
                            "§6» §7Pfeile",
                            "§6» §7Ketten Rüstung",
                            "", "§fKosten 15 Coins",
                            "",
                            "§4§lACHTUNG DU HAST DIESES KIT NUR EIN MAL!"
                    )
                    .create(),
            15
    ),
    DIAMOND(
            "§bDiamanten-Kit",
            new ItemBuilder(Material.DIAMOND_CHESTPLATE)
                    .displayName("§bDiamanten-Kit")
                    .lore(
                            "",
                            "§f§oMit diesem Kit erhälst du",
                            "§f§ofolgende Kit:",
                            "",
                            "§6» §7Stein Schwert",
                            "§6» §7Enterhaken",
                            "§6» §7Knockback-Stick",
                            "§6» §7Enderperle",
                            "§6» §7Eisen Brustplatte",
                            "§6» §7Ketten Rüstung",
                            "",
                            "§fKosten 25 Coins",
                            "",
                            "§4§lACHTUNG DU HAST DIESES KIT NUR EIN MAL!"
                    )
                    .create(),
            25
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
