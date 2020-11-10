package com.syntaxphoenix.utilitiesplus.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.syntaxphoenix.utilitiesplus.configs.MainConfig;
import com.syntaxphoenix.utilitiesplus.locations.LocationsConfig;

public class JoinListener implements Listener {
	
	@EventHandler
	public void on(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (MainConfig.spawn_on_join) {
			if (LocationsConfig.getLocation("Spawn") != null) {
				p.teleport(LocationsConfig.getLocation("Spawn"));
			}
		}
	}
}