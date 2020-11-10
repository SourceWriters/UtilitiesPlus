package com.syntaxphoenix.utilitiesplus.commands.weather;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;

public class ThunderCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {	
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("utilitiesplus.weather.*") || p.hasPermission("utilitiesplus.weather.thunder") || p.hasPermission("utilitiesplus.*")) {
				p.getWorld().setStorm(true);
				p.getWorld().setThundering(true);
				p.sendMessage(MessagesConfig.prefix + MessagesConfig.weather_to_thunder);
			} else {
				p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
			}
		} else {
			System.out.println(MessagesConfig.no_player);
		}
		return true;
	}
}