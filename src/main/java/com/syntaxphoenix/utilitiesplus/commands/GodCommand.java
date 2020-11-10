package com.syntaxphoenix.utilitiesplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;
import com.syntaxphoenix.utilitiesplus.utils.PluginUtils;

public class GodCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("utilitiesplus.god") || p.hasPermission("utilitiesplus.*")) {
				if(PluginUtils.godPlayers.contains(p)) {
					PluginUtils.godPlayers.remove(p);
					p.sendMessage(MessagesConfig.prefix + MessagesConfig.god_disabled);
				} else {
					PluginUtils.godPlayers.add(p);
					p.sendMessage(MessagesConfig.prefix + MessagesConfig.god_enabled);
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