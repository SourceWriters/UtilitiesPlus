package com.syntaxphoenix.utilitiesplus.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;

public class GameModeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 1) {
				String gm = args[0];
				if(gm.equalsIgnoreCase("0")) {
					if(p.hasPermission("utilitiesplus.gamemode.*") || p.hasPermission("utilitiesplus.gamemode.self.*") || p.hasPermission("utilitiesplus.gamemode.self.0") || p.hasPermission("utilitiesplus.*")) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(MessagesConfig.prefix + "§7Your Gamemode has been set to GameMode §6Survival");
					} else {
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
					}
				} else if(gm.equalsIgnoreCase("1")) {
					if(p.hasPermission("utilitiesplus.gamemode.*") || p.hasPermission("utilitiesplus.gamemode.self.*") || p.hasPermission("utilitiesplus.gamemode.self.1") || p.hasPermission("utilitiesplus.*")) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(MessagesConfig.prefix + "§7Your Gamemode has been set to GameMode §6Creative");
					} else {
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
					}					
				} else if(gm.equalsIgnoreCase("2")) {
					if(p.hasPermission("utilitiesplus.gamemode.*") || p.hasPermission("utilitiesplus.gamemode.self.*") || p.hasPermission("utilitiesplus.gamemode.self.2") || p.hasPermission("utilitiesplus.*")) {
						p.setGameMode(GameMode.ADVENTURE);
						p.sendMessage(MessagesConfig.prefix + "§7Your Gamemode has been set to GameMode §6Adventure");
					} else {
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
					}
				} else if(gm.equalsIgnoreCase("3")) {
					if(p.hasPermission("utilitiesplus.gamemode.*") || p.hasPermission("utilitiesplus.gamemode.self.*") || p.hasPermission("utilitiesplus.gamemode.self.3") || p.hasPermission("utilitiesplus.*")) {
						p.setGameMode(GameMode.SPECTATOR);
						p.sendMessage(MessagesConfig.prefix + "§7Your Gamemode has been set to GameMode §6Spectator");
					} else {
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
					}
				} else {
					p.sendMessage(MessagesConfig.prefix + "§7/gm <0|1|2|3> [Player]");
				}
			} else if(args.length == 2) {
				String gm = args[0];
				String player = args[1];
				if(Bukkit.getPlayerExact(player) != null) {
					Player k = Bukkit.getPlayerExact(player);
					if(gm.equalsIgnoreCase("0")) {
						if(p.hasPermission("utilitiesplus.gamemode.*") || p.hasPermission("utilitiesplus.gamemode.other.*") || p.hasPermission("utilitiesplus.gamemode.other.0") || p.hasPermission("utilitiesplus.*")) {
							k.setGameMode(GameMode.SURVIVAL);
							k.sendMessage(MessagesConfig.prefix + "§7Your Gamemode has been set to GameMode §6Survival");
							p.sendMessage(MessagesConfig.prefix + "§7You set " + k.getName() +"`s GameMode to §6Survival");
						} else {
							p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
						}
					} else if(gm.equalsIgnoreCase("1")) {
						if(p.hasPermission("utilitiesplus.gamemode.*") || p.hasPermission("utilitiesplus.gamemode.other.*") || p.hasPermission("utilitiesplus.gamemode.other.1") || p.hasPermission("utilitiesplus.*")) {
							k.setGameMode(GameMode.CREATIVE);
							k.sendMessage(MessagesConfig.prefix + "§7Your Gamemode has been set to GameMode §6Creative");
							p.sendMessage(MessagesConfig.prefix + "§7You set " + k.getName() +"`s GameMode to §6Creative");
						} else {
							p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
						}					
					} else if(gm.equalsIgnoreCase("2")) {
						if(p.hasPermission("utilitiesplus.gamemode.*") || p.hasPermission("utilitiesplus.gamemode.other.*") || p.hasPermission("utilitiesplus.gamemode.other.2") || p.hasPermission("utilitiesplus.*")) {
							k.setGameMode(GameMode.ADVENTURE);
							k.sendMessage(MessagesConfig.prefix + "§7Your Gamemode has been set to GameMode §6Adventure");
							p.sendMessage(MessagesConfig.prefix + "§7You set " + k.getName() +"`s GameMode to §6Adventure");
						} else {
							p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
						}
					} else if(gm.equalsIgnoreCase("3")) {
						if(p.hasPermission("utilitiesplus.gamemode.*") || p.hasPermission("utilitiesplus.gamemode.other.*") || p.hasPermission("utilitiesplus.gamemode.other.3") || p.hasPermission("utilitiesplus.*")) {
							k.setGameMode(GameMode.SPECTATOR);
							k.sendMessage(MessagesConfig.prefix + "§7Your Gamemode has been set to GameMode §6Spectator");
							p.sendMessage(MessagesConfig.prefix + "§7You set " + k.getName() +"`s GameMode to §6Spectator");
						} else {
							p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
						}
					} else {
						p.sendMessage(MessagesConfig.prefix + "§7/gm <0|1|2|3> [Player]");
					}
				} else {
					p.sendMessage(MessagesConfig.prefix + MessagesConfig.player_offline);
				}
			} else {
				p.sendMessage(MessagesConfig.prefix + MessagesConfig.arguments_error + "/gm <0|1|2|3> [Player]");
			}
		} else {
			System.out.println(MessagesConfig.no_player);
		}
		return true;
	}

}