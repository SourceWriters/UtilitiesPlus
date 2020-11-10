package com.syntaxphoenix.utilitiesplus.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;

public class PmCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length >= 2) {
				if(p.hasPermission("utilitiesplus.pm") || p.hasPermission("utilitiesplus.*")) {
					String player = args[0];
					String message = "";
					int i = 1;
					while(args.length > i) {
						message = message + " " + args[i];
						i++;
					}
					if(Bukkit.getPlayerExact(player) != null) {
						Player k = Bukkit.getPlayerExact(player);
						if(!player.equalsIgnoreCase(p.getName())) {
							k.sendMessage("§6" + p.getName() + " §8► §6You §8» §7" + message);
							p.sendMessage("§6You" + " §8► §6" + k.getName() + " §8» §7" + message);
						} else {
							p.sendMessage(MessagesConfig.prefix + MessagesConfig.pm_yourself);
						}
					} else {
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.player_offline);
					}
				} else {
					p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
				}
			} else {
				p.sendMessage(MessagesConfig.prefix + MessagesConfig.arguments_error + "/pm <Player> <Message>");
			}
		} else {
			System.out.println(MessagesConfig.no_player);
		}
		return true;
	}

}