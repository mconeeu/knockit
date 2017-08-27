package KnockbackFFA.Listener.de;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class LISTENER_Weather implements Listener{
	  @EventHandler
	  public void onWeather(WeatherChangeEvent e)
	  {
	    e.setCancelled(true);
	  }
	}
