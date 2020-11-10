package com.syntaxphoenix.utilitiesplus.commands.warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;
import com.syntaxphoenix.utilitiesplus.locations.LocationsConfig;

public class WarpsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("utilitiesplus.warps") || p.hasPermission("utilitiesplus.*")) {
				if(LocationsConfig.getWarpList().size() > 0) {
					p.sendMessage(MessagesConfig.warps_header);
					for(String warp : LocationsConfig.getWarpList()) {
						p.sendMessage("§8- §e" + warp);
					}
					p.sendMessage(MessagesConfig.warps_header);
				} else {
					p.sendMessage(MessagesConfig.prefix + MessagesConfig.warps_empty);
				}
			}
		} else {
			System.out.println(MessagesConfig.no_player);
		}	
		return true;
	}
}