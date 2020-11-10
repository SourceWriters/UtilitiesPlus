package com.syntaxphoenix.utilitiesplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;

public class KillallCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("utilitiesplus.*") || p.hasPermission("utilitiesplus.killall")) {
				if(args.length == 0) {
					for(Entity e : p.getWorld().getEntities()) {
						if(e.getType() != EntityType.PLAYER) {
							e.remove();
						}
					}
				} else {
					if(args[0].equalsIgnoreCase("-ArmorStands")) {
						for(Entity e : p.getWorld().getEntities()) {
							if(e.getType() != EntityType.PLAYER && e.getType() != EntityType.ARMOR_STAND) {
								e.remove();
							}
						}
					} else {
						
					}
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