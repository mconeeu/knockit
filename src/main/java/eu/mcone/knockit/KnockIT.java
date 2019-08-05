/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.gamemode.Gamemode;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.profile.PlayerDataProfile;
import eu.mcone.coresystem.api.bukkit.world.BuildSystem;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import eu.mcone.gamesystem.api.GameTemplate;
import eu.mcone.gamesystem.api.game.manager.kit.Kit;
import eu.mcone.gamesystem.api.game.manager.kit.KitItem;
import eu.mcone.gamesystem.api.game.manager.kit.KitItemType;
import eu.mcone.knockit.cmd.KnockITCommand;
import eu.mcone.knockit.gadgets.event.GrenadeListener;
import eu.mcone.knockit.gadgets.event.PlayerSwapListener;
import eu.mcone.knockit.gadgets.event.RocketListener;
import eu.mcone.knockit.listener.*;
import eu.mcone.knockit.profile.KnockITPlayer;
import eu.mcone.knockit.util.Kits;
import eu.mcone.knockit.util.SidebarObjective;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;

import java.util.*;

public class KnockIT extends GameTemplate {

    public KnockIT() {
        super("knockit", Gamemode.KNOCKIT, ChatColor.GREEN, "knockit.prefix", GameSystemOptions.USE_MAP_MANAGER);
    }

    @Getter
    private static KnockIT instance;
    private List<KnockITPlayer> players;
    @Getter
    private Map<Player, Kit> sorting;

    @Getter
    private BuildSystem buildSystem;

    @Override
    public void onGameEnable() {
        instance = this;
        CoreSystem.getInstance().getTranslationManager().loadCategories(this);
        players = new ArrayList<>();
        sorting = new HashMap<>();

        sendConsoleMessage("§aBuild-System wird initiiert...");
        buildSystem = CoreSystem.getInstance().initialiseBuildSystem(BuildSystem.BuildEvent.BLOCK_BREAK, BuildSystem.BuildEvent.BLOCK_PLACE);
        buildSystem.addFilter(BuildSystem.BuildEvent.BLOCK_PLACE, Material.QUARTZ_BLOCK.getId());

        sendConsoleMessage("§aStart MapManager...");
        GameTemplate.getInstance().getMapManager().createMapRotationHandler(300).startRotation();

        sendConsoleMessage("§aCommands undEvents werden registriert...");
        registerCommands();
        registerEvents();

        registerKits();

        sendConsoleMessage("§aVersion §f" + this.getDescription().getVersion() + "§a wurde aktiviert...");

        PlayerDataProfile.doSetGameProfileWorld(this.getServer().getWorld(getMapManager().getMapRotationHandler().getCurrentGameMap().getWorld()));

        for (CorePlayer p : CoreSystem.getInstance().getOnlineCorePlayers()) {
            p.getScoreboard().setNewObjective(new SidebarObjective());
            new KnockITPlayer(p);
        }
    }

    @Override
    public void onGameDisable() {
        for (KnockITPlayer knockITPlayer : getKnockITPlayers()) {
            knockITPlayer.saveData();
        }

        sendConsoleMessage("§cPlugin wurde deaktiviert!");
    }

    private void registerCommands() {
        registerCommands(
                new KnockITCommand()
        );
    }

    private void registerEvents() {
        registerEvents(
                new PlayerMoveListener(),
                new RocketListener(),
                new PlayerSwapListener(),
                new GrenadeListener(),
                new EntityDamageListener(),
                new FishingRodListener(),
                new GeneralPlayerListener(),
                new MlgBlockListener(),
                new NpcListener(),
                new PlayerDeathListener(),
                new PlayerLevelChange(),
                new PlayerUpdateListener(),
                new WeatherChangeListener(),
                new GameMapCountdownChangeListener()
        );
    }

    private void registerKits() {
        getKitManager().registerKits(
                new Kit(1, Kits.DEFAULT.getName(), "§7Standard-Kit",
                        new ItemBuilder(Material.LEATHER_CHESTPLATE).create(),
                        new KitItem[]{
                                new KitItem(1.1, KitItemType.WEAPON, new ItemBuilder(Material.WOOD_SWORD).displayName("§8» §b§lHolz Schwert").enchantment(Enchantment.DAMAGE_ALL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create()),
                                new KitItem(1.2, KitItemType.WEAPON, new ItemBuilder(Material.FISHING_ROD).displayName("§8» §f§lAngel").unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create()),
                                new KitItem(1.3, KitItemType.WEAPON, new ItemBuilder(Material.STICK).displayName("§8» §5§lKnockback-Stick").enchantment(Enchantment.KNOCKBACK, 1).create()),
                                new KitItem(1.4, KitItemType.WEAPON, new ItemBuilder(Material.QUARTZ_BLOCK, 3).displayName("§8» §6§lMLG-Block").create())
                        },
                        100
                ),
                new Kit(2, Kits.ARCHER.getName(), "§2Bogenschützen-Kit", new ItemBuilder(Material.LEATHER_CHESTPLATE).create(),
                        new KitItem[]{
                                new KitItem(2.1, KitItemType.WEAPON, new ItemBuilder(Material.STONE_SWORD).displayName("§8» §b§lStein Schwert").enchantment(Enchantment.DAMAGE_ALL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create()),
                                new KitItem(2.2, KitItemType.WEAPON, new ItemBuilder(Material.FISHING_ROD).displayName("§8» §f§lAngel").unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create()),
                                new KitItem(2.3, KitItemType.WEAPON, new ItemBuilder(Material.STICK).displayName("§8» §5§lKnockback-Stick").enchantment(Enchantment.KNOCKBACK, 1).create()),
                                new KitItem(2.4, KitItemType.WEAPON, new ItemBuilder(Material.BOW).displayName("§8» §d§lBogen").create()),
                                new KitItem(2.5, KitItemType.WEAPON, new ItemBuilder(Material.ARROW, 3, 0).displayName("§8» §6§lPfeile").create())
                        },
                        100
                ),
                new Kit(3, Kits.KNOCKBACK.getName(), "§5Knockback-Kit",
                        new ItemBuilder(Material.CHAINMAIL_CHESTPLATE)
                                .displayName("§5Knockback-Kit")
                                .lore("",
                                        "§f§oMit diesem Kit erhälst du",
                                        "§f§ofolgende Items:",
                                        "",
                                        "§6» §7Stein Schwert (Lv. 1)",
                                        "§6» §7Knockback-Stick (Lv. 2)",
                                        "§6» §7Angel",
                                        "",
                                        "§f§oKosten 100 Coins",
                                        "",
                                        "§4§lACHTUNG DU HAST DIESES KIT NUR EIN MAL!").create(),
                        new KitItem[]{
                                new KitItem(3.1, KitItemType.WEAPON, new ItemBuilder(Material.STONE_SWORD).displayName("§8» §b§lStein Schwert").enchantment(Enchantment.DAMAGE_ALL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create()),
                                new KitItem(3.2, KitItemType.WEAPON, new ItemBuilder(Material.STICK).displayName("§8» §5§lKnockback-Stick").enchantment(Enchantment.KNOCKBACK, 2).create()),
                                new KitItem(3.3, KitItemType.WEAPON, new ItemBuilder(Material.FISHING_ROD).displayName("§8§ §f§lAngel").unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create())
                        },
                        100
                ),
                new Kit(4, Kits.GRAPPLING_HOOK.getName(), "§5Knockback-Kit",
                        new ItemBuilder(Material.GOLD_CHESTPLATE)
                                .displayName("§dEnterhacken-Kit")
                                .lore(
                                        "",
                                        "§f§oMit diesem Kit erhälst du",
                                        "§f§ofolgende Kit:",
                                        "",
                                        "§6» §7Stein Schwert",
                                        "§6» §7Enterhacken",
                                        "§6» §7Knockback-Stick",
                                        "",
                                        "§f§oKosten 125 Coins",
                                        "",
                                        "§4§lACHTUNG DU HAST DIESES KIT NUR EIN MAL!").create(),
                        new KitItem[]{
                                new KitItem(4.1, KitItemType.WEAPON, new ItemBuilder(Material.STONE_SWORD).displayName("§8» §b§lStein Schwert").unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).enchantment(Enchantment.DAMAGE_ALL, 2).create()),
                                new KitItem(4.2, KitItemType.WEAPON, new ItemBuilder(Material.FISHING_ROD).displayName("§6» §7Enterhacken").unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create()),
                                new KitItem(4.3, KitItemType.WEAPON, new ItemBuilder(Material.STICK).displayName("§8» §5§lKnockback-Stick").enchantment(Enchantment.KNOCKBACK, 2).create())
                        },
                        100
                ),
                new Kit(5, Kits.ENDERMAN.getName(), "§bEnderman-Kit",
                        new ItemBuilder(Material.DIAMOND_CHESTPLATE)
                                .displayName("§5Enderman-Kit")
                                .lore(
                                        "",
                                        "§f§oMit diesem Kit erhälst du",
                                        "§f§ofolgende Kit:",
                                        "",
                                        "§6» §7Stein Schwert",
                                        "§6» §7Angel",
                                        "§6» §7Knockback-Stick",
                                        "§6» §7Enderperle",
                                        "",
                                        "§f§oKosten 150 Coins",
                                        "",
                                        "§4§lACHTUNG DU HAST DIESES KIT NUR EIN MAL!").create(),
                        new KitItem[]{
                                new KitItem(4.1, KitItemType.WEAPON, new ItemBuilder(Material.STONE_SWORD).displayName("§8» §b§lStein Schwert").enchantment(Enchantment.DAMAGE_ALL, 1).unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create()),
                                new KitItem(4.2, KitItemType.WEAPON, new ItemBuilder(Material.FISHING_ROD).displayName("§8» §f§lAngel").unbreakable(true).itemFlags(ItemFlag.HIDE_UNBREAKABLE).create()),
                                new KitItem(4.3, KitItemType.WEAPON, new ItemBuilder(Material.STICK).displayName("§8» §5§lKnockback-Stick").enchantment(Enchantment.KNOCKBACK, 1).create()),
                                new KitItem(4.4, KitItemType.WEAPON, new ItemBuilder(Material.ENDER_PEARL).displayName("§8§ §d§lEnderperle").create())
                        },
                        100
                )
        );
    }

    public KnockITPlayer getKnockITPlayer(UUID uuid) {
        for (KnockITPlayer sp : players) {
            if (sp.getCorePlayer().getUuid().equals(uuid)) {
                return sp;
            }
        }
        return null;
    }

    public KnockITPlayer getKnockITPlayer(String name) {
        for (KnockITPlayer sp : players) {
            if (sp.getCorePlayer().getName().equals(name)) {
                return sp;
            }
        }
        return null;
    }

    public CoreWorld getCurrentWorld() {
        return KnockIT.getInstance().getMapManager().getMapRotationHandler().getCurrentCoreWorld();
    }

    public Collection<KnockITPlayer> getKnockITPlayers() {
        return players;
    }

    public void registerKnockITPlayer(KnockITPlayer sp) {
        players.add(sp);
    }

    public void unregisterKnockITPlayer(KnockITPlayer sp) {
        players.remove(sp);
    }
}
