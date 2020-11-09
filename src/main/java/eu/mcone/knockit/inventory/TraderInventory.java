/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.inventory;

import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventoryOption;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.coresystem.api.bukkit.item.Skull;
import eu.mcone.gameapi.api.GamePlugin;
import eu.mcone.gameapi.api.player.GamePlayer;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.cmd.KnockITCommand;
import eu.mcone.knockit.kit.Kit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class TraderInventory extends CoreInventory {

    public TraderInventory(Player p) {
        super("§8» §e§lHändler", p, InventorySlot.ROW_3, InventoryOption.FILL_EMPTY_SLOTS);

        setItem(InventorySlot.ROW_1_SLOT_5, Skull.fromUrl("http://textures.minecraft.net/texture/5163dafac1d91a8c91db576caac784336791a6e18d8f7f62778fc47bf146b6", 1).toItemBuilder().displayName("§e§lHändler").lore("§7§oBeim Händler kannst ausgewählte", "§7§oGadgets oder Kits für kaufen.", "§7§oDie meisten Items erhälst du", "§7§onur durch Coins!").create());

        setItem(
                InventorySlot.ROW_3_SLOT_3,
                new ItemBuilder(Material.CHEST, 1, 0)
                        .displayName("§cGadgets kaufen")
                        .lore("§7§oDu kannst Gadgets mit", "§7§oKillstreaks kaufen!")
                        .create(),
                e -> new GadgetsInventory(p)
        );

        GamePlayer gamePlayer = KnockIT.getInstance().getGamePlayer(p);

        if (!gamePlayer.getCurrentKit().equals(Kit.DEFAULT)) {
            if (!KnockIT.getInstance().getIsKitAutoBuyDisabled().contains(p)) {
                if (!KnockIT.getInstance().getKitMap().containsKey(p)) {
                    KnockIT.getInstance().getKitMap().put(p, gamePlayer.getCurrentKit());
                }
            }
        }

        if (!gamePlayer.getCurrentKit().equals(Kit.DEFAULT)) {
            if (KnockIT.getInstance().getKitMap().containsKey(p)) {
                setItem(
                        InventorySlot.ROW_3_SLOT_5,
                        new ItemBuilder(Material.INK_SACK, 1, 5)
                                .displayName("§aAutomatisches Kit")
                                .lore("§7§oKlicke um kein automatisches Kit mehr", "§7§obeim sterben zu kaufen!")
                                .create(),
                        e -> {
                            KnockIT.getInstance().getKitMap().remove(p);
                            KnockIT.getInstance().getMessenger().sendSuccess(p, "§4Wenn du das nächste mal §cstirbst§4. Kaufst du nicht mehr §cautomatisch dein aktuelles Kit erneut§4!");

                            KnockIT.getInstance().isKitAutoBuyDisabled.add(p);

                            player.closeInventory();
                        }
                );

            }
        }

        setItem(
                InventorySlot.ROW_3_SLOT_7,
                new ItemBuilder(Material.DIAMOND_CHESTPLATE, 1, 0).displayName("§cKits kaufen").create(),
                e -> KnockIT.getInstance().getKitManager().openKitsInventory(p, () -> new TraderInventory(p))
        );

        openInventory();
    }

}

