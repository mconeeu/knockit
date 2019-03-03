/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit;

import eu.mcone.coresystem.api.bukkit.CorePlugin;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.world.BuildSystem;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import eu.mcone.knockit.listener.*;
import eu.mcone.knockit.util.SidebarObjective;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class KnockIT extends CorePlugin {

    public KnockIT() {
        super("KnockIT", ChatColor.DARK_GREEN, "knockit.prefix");
    }

    @Getter
    private static KnockIT instance;
    @Getter
    private CoreWorld world;
    @Getter
    private BuildSystem buildSystem;

    public void onEnable() {
        instance = this;
        world = CoreSystem.getInstance().getWorldManager().getWorld("Knockit");
        CoreSystem.getInstance().getTranslationManager().loadCategories(this);

        sendConsoleMessage("§aBuild-System witd initiiert");
        buildSystem = CoreSystem.getInstance().initialiseBuildSystem(BuildSystem.BuildEvent.BLOCK_BREAK, BuildSystem.BuildEvent.BLOCK_PLACE);
        buildSystem.addFilter(BuildSystem.BuildEvent.BLOCK_PLACE, Material.QUARTZ_BLOCK);

        sendConsoleMessage("§aEvents werden registriert...");
        registerEvents();

        sendConsoleMessage("§aVersion §f" + this.getDescription().getVersion() + "§a wurde aktiviert...");

        for (CorePlayer p : CoreSystem.getInstance().getOnlineCorePlayers()) {
            p.getScoreboard().setNewObjective(new SidebarObjective());
        }
    }

    public void onDisable() {
        sendConsoleMessage("§cPlugin wurde deaktiviert!");
    }

    private void registerEvents() {
        registerEvents(
                new EntityDamage(),
                new EntityDamageByEntity(),
                new FoodLevelChange(),
                new InventoryClick(),
                new PlayerDeath(),
                new PlayerDropItem(),
                new PlayerFish(),
                new PlayerJoin(),
                new PlayerLevelChange(),
                new PlayerQuit(),
                new PlayerRespawn(),
                new CoinsChange(),
                new NpcInteract(),
                new StatsChange(),
                new WeatherChange(),
                new InventoryClick()
        );
    }

}
