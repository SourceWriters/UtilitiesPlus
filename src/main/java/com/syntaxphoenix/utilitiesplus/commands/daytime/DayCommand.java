package com.syntaxphoenix.utilitiesplus.commands.daytime;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;

public class DayCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("utilitiesplus.times.*") || p.hasPermission("utilitiesplus.times.day") || p.hasPermission("utilitiesplus.*")) {
				p.getWorld().setTime(1000);
				p.sendMessage(MessagesConfig.prefix + MessagesConfig.time_to_day);
			} else {
				p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
			}
		} else {
			System.out.println(MessagesConfig.no_player);
		}
		return true;
	}

}