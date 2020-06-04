/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.util;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.gamemode.Gamemode;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjective;
import eu.mcone.gameapi.api.Module;
import eu.mcone.knockit.KnockIT;
import org.bukkit.scoreboard.DisplaySlot;

import java.util.Calendar;
import java.util.TimeZone;

public class SidebarObjective extends CoreSidebarObjective {

    private static String updateTime = "NAN";

    static {
        KnockIT.getInstance().getServer().getScheduler().runTaskTimerAsynchronously(KnockIT.getInstance(), () -> {
            if (KnockIT.getInstance().hasModule(Module.MAP_MANAGER)) {
                String newDate = getUpdateDate();

                if (!updateTime.equals(newDate)) {
                    updateTime = newDate;

                    for (CorePlayer player : CoreSystem.getInstance().getOnlineCorePlayers()) {
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
                    }
                }
            }
        }, 0, 20);
    }

    public SidebarObjective() {
        super("KnockIT");
    }

    @Override
    public void onRegister(CorePlayer player) {
        setDisplayName(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.1"));

        setScore(11, "");
        setScore(10, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.2"));
        setScore(9, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.3") + player.getStats(Gamemode.KNOCKIT).getKill());
        setScore(8, "");
        setScore(7, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.4"));
        setScore(6, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.5") + player.getStats(Gamemode.KNOCKIT).getDeath());
        setScore(5, "");
        setScore(4, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.6"));
        setScore(3, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.7") + player.bukkit().getLevel());
        setScore(2, "");
        setScore(1, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.8"));
        setScore(0, " §f" + updateTime);
    }

    @Override
    public void onReload(CorePlayer player) {
        setDisplayName(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.1"));

        setScore(9, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.3") + player.getStats(Gamemode.KNOCKIT).getKill());
        setScore(6, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.5") + player.getStats(Gamemode.KNOCKIT).getDeath());
        setScore(3, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.7") + player.bukkit().getLevel());
        setScore(0, " §f" + updateTime);
    }

    private static String getUpdateDate() {
        String date = "...";

        long difference = KnockIT.getInstance().getMapManager().getMapRotationHandler().getRotationInterval() -
                ((System.currentTimeMillis() / 1000) - KnockIT.getInstance().getMapManager().getMapRotationHandler().getLastRotation());

        if (difference <= KnockIT.getInstance().getMapManager().getMapRotationHandler().getRotationInterval()) {
            Calendar differenceDate = Calendar.getInstance(TimeZone.getTimeZone("CEST"));
            differenceDate.setTimeInMillis(difference * 1000);

            if (differenceDate.get(Calendar.HOUR) >= 1) {
                date = differenceDate.get(Calendar.HOUR) + 1 + " Stunden";
            } else if (differenceDate.get(Calendar.MINUTE) >= 1) {
                date = differenceDate.get(Calendar.MINUTE) + 1 + " Minuten";
            } else if (differenceDate.get(Calendar.SECOND) >= 1) {
                date = differenceDate.get(Calendar.SECOND) + " Sekunden";
            }
        }

        return date;
    }

}
