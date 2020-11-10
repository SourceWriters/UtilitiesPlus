package com.syntaxphoenix.utilitiesplus.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;

public class InvseeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("utilitiesplus.invsee") || p.hasPermission("utilitiesplus.*")) {
				if(args.length == 1) {
					String player = args[0];
					if(Bukkit.getPlayerExact(player) != null) {
						Player k = Bukkit.getPlayerExact(player);
						p.openInventory(k.getInventory());
					} else {
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.player_offline);
					}
				} else {
					p.sendMessage(MessagesConfig.prefix + MessagesConfig.arguments_error + "/invsee <Player>");
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