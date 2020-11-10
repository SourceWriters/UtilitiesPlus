package com.syntaxphoenix.utilitiesplus.commands.tp;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;

public class TpallCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("utilitiesplus.tpall") || p.hasPermission("utilitiesplus.*")) {
				for(Player all : Bukkit.getOnlinePlayers()) {
					if(!all.hasPermission("utilitiesplus.tpall.bypass")) {
						all.teleport(p);
						all.sendMessage(MessagesConfig.prefix + MessagesConfig.tpall_message_players.replace("%Player%", p.getName()));
					}
				}
				p.sendMessage(MessagesConfig.prefix + MessagesConfig.tpall_message);
			} else {
				p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
			}
		} else {
			System.out.println(MessagesConfig.no_player);
		}
		return true;
	}
}