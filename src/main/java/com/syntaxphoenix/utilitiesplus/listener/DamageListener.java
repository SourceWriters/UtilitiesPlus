package com.syntaxphoenix.utilitiesplus.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import com.syntaxphoenix.utilitiesplus.utils.PluginUtils;

public class DamageListener implements Listener {

	@EventHandler
	public void on(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if (PluginUtils.godPlayers.contains(player)) {
				event.setCancelled(true);
			}
		}
	}
}