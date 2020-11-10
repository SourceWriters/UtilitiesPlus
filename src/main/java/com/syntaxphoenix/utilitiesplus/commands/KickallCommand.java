package com.syntaxphoenix.utilitiesplus.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;

public class KickallCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("utilitiesplus.kickall") || p.hasPermission("utilitiesplus.*")) {
				for(Player all : Bukkit.getOnlinePlayers()) {
					if(!all.hasPermission("basicplus.kick.bypass")) {
						all.kickPlayer(MessagesConfig.prefix + MessagesConfig.kickall_kick_msg.replace("%Player%", p.getName()));
					}
				}
				p.sendMessage(MessagesConfig.prefix + MessagesConfig.kickall_inform);
			} else {
				p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
			}
		} else {
			System.out.println(MessagesConfig.no_player);
		}
		return true;
	}

}