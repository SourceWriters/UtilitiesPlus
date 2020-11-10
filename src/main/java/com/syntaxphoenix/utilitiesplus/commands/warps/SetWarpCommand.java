package com.syntaxphoenix.utilitiesplus.commands.warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;
import com.syntaxphoenix.utilitiesplus.locations.LocationsConfig;

public class SetWarpCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("utilitiesplus.setwarp") || p.hasPermission("utilitiesplus.*")) {
				if(args.length == 1) {
					if(!LocationsConfig.getWarpList().contains(args[0])) {
						LocationsConfig.addToWarpList(args[0]);
						LocationsConfig.setLocation("Warp." + args[0], p.getLocation());
						p.sendMessage(MessagesConfig.prefix + "§7A Warp named §6" + args[0] + " §7has §asuccessfully §7been set.");
					} else {
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.warp_already_set);
					}
				} else {
					p.sendMessage(MessagesConfig.prefix + MessagesConfig.arguments_error + "/setwarp <Warp>");
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