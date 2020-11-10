package com.syntaxphoenix.utilitiesplus.commands.warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;
import com.syntaxphoenix.utilitiesplus.locations.LocationsConfig;

public class RemoveWarpCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length == 1) {
				if(p.hasPermission("utilitiesplus.removewarp") || p.hasPermission("utilitiesplus.*")) {
					if(LocationsConfig.getWarpList().contains(args[0])) {
						LocationsConfig.removeFromWarpList(args[0]);
						LocationsConfig.removeLocation("Warp." + args[0]);
						p.sendMessage(MessagesConfig.prefix + "§7The Warp named §6" + args[0] + " §7has §asuccessfully §7been removed.");
					} else {
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.warp_invalid);
					}
				} else {
					p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
				}
			} else {
				p.sendMessage(MessagesConfig.prefix + MessagesConfig.arguments_error + "/remwarp <Warp>");
			}	
		} else {
			System.out.println(MessagesConfig.no_player);
		}	
		return true;
	}
}