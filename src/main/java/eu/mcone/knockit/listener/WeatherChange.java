package eu.mcone.knockit.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherChange implements Listener{

    @EventHandler
    public void on(WeatherChangeEvent e)
    {
    e.setCancelled(true);
    }

}
