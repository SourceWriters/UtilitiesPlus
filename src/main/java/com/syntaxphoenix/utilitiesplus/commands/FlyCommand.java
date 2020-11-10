package com.syntaxphoenix.utilitiesplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;

public class FlyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("utilitiesplus.fly") || p.hasPermission("utilitiesplus.*")) {
				if(p.isFlying() || p.getAllowFlight()) {
					p.setFlying(false);
					p.setAllowFlight(false);
					p.sendMessage(MessagesConfig.prefix + MessagesConfig.fly_disabled);
				} else {
					p.setAllowFlight(true);
					p.setFlying(true);
					p.sendMessage(MessagesConfig.prefix + MessagesConfig.fly_enabled);
				}
			} else {
				p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
			}
		} else {
			System.out.println(MessagesConfig.no_player);
		}
		return true;
	}
}