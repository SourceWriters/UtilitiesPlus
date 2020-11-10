package com.syntaxphoenix.utilitiesplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;

public class EnderChestCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("utilitiesplus.enderchest") || player.hasPermission("utilitiesplus.*")) {
				player.openInventory(player.getEnderChest());
			} else {
				player.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
			}
		} else {
			System.out.println(MessagesConfig.no_player);
		}
		return true;
	}

}
