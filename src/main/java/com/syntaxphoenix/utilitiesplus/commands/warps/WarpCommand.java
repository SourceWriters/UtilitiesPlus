package com.syntaxphoenix.utilitiesplus.commands.warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;
import com.syntaxphoenix.utilitiesplus.locations.LocationsConfig;

public class WarpCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length == 1) {
				if(p.hasPermission("utilitiesplus.warp.*") || p.hasPermission("utilitiesplus.warp." + args[0]) || p.hasPermission("utilitiesplus.*")) {
					if(LocationsConfig.getWarpList().contains(args[0])) {
						p.teleport(LocationsConfig.getLocation("Warp." + args[0]));
					} else {
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.warp_invalid);
					}
				} else {
					p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
				}
			} else {
				p.sendMessage(MessagesConfig.prefix + MessagesConfig.arguments_error + "/warp <Warp>");
			}		
		} else {
			System.out.println(MessagesConfig.no_player);
		}
		return true;
	}
}