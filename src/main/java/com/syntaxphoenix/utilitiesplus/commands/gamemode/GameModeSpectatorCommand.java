package com.syntaxphoenix.utilitiesplus.commands.gamemode;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;

public class GameModeSpectatorCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 0) {
				if (player.hasPermission("utilitiesplus.gamemode.*") || player.hasPermission("utilitiesplus.gamemode.self.*") || player.hasPermission("utilitiesplus.gamemode.self.3") || player.hasPermission("utilitiesplus.*")) {
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(MessagesConfig.prefix + "§7Your Gamemode has been set to GameMode §6Spectator");
				} else {
					player.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
				}
			} else if(args.length == 1) {
				String otherPlayer = args[0];
				if (Bukkit.getPlayerExact(otherPlayer) != null) {
					Player externalPlayer = Bukkit.getPlayerExact(otherPlayer);
					if (player.hasPermission("utilitiesplus.gamemode.*") || player.hasPermission("utilitiesplus.gamemode.other.*") || player.hasPermission("utilitiesplus.gamemode.other.3") || player.hasPermission("utilitiesplus.*")) {
						externalPlayer.setGameMode(GameMode.SPECTATOR);
						externalPlayer.sendMessage(MessagesConfig.prefix + "§7Your Gamemode has been set to GameMode §6Spectator");
						player.sendMessage(MessagesConfig.prefix + "§7You set " + externalPlayer.getName() +"`s GameMode to §6Spectator");
					} else {
						player.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
					}
				} else {
					player.sendMessage(MessagesConfig.prefix + MessagesConfig.player_offline);
				}
			} else {
				player.sendMessage(MessagesConfig.prefix + MessagesConfig.arguments_error + "/gmsp [Player]");
			}
		} else {
			System.out.println(MessagesConfig.no_player);
		}
		return true;
	}
}

