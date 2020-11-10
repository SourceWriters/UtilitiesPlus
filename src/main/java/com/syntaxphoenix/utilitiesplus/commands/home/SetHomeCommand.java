package com.syntaxphoenix.utilitiesplus.commands.home;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;
import com.syntaxphoenix.utilitiesplus.locations.LocationsConfig;

public class SetHomeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("utilitiesplus.home.*") || p.hasPermission("utilitiesplus.home.set") || p.hasPermission("utilitiesplus.*")) {
				LocationsConfig.setLocation("Home." + p.getUniqueId().toString(), p.getLocation());
				p.sendMessage(MessagesConfig.prefix + MessagesConfig.home_set);
			} else {
				p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
			}
		} else {
			System.out.println(MessagesConfig.no_player);
		}		
		return true;
	}
}