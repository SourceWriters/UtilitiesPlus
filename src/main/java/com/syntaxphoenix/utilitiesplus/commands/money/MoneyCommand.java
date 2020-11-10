package com.syntaxphoenix.utilitiesplus.commands.money;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MainConfig;
import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;
import com.syntaxphoenix.utilitiesplus.money.MoneyUtils;

public class MoneyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {	
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				if(p.hasPermission("utilitiesplus.money.*") || p.hasPermission("utilitiesplus.money.help") || p.hasPermission("utilitiesplus.*")) {
					p.sendMessage(MessagesConfig.prefix + MessagesConfig.money_help);
				} else {
					p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
				}
			} else {
				if(args[0].equalsIgnoreCase("help")) {
					if(p.hasPermission("basicsplus.money.*") || p.hasPermission("basicsplus.money.help") || p.hasPermission("basicplus.*")) {
						p.sendMessage(MessagesConfig.money_header);
						p.sendMessage("§6/money help §8- §7Shows all Commands");
						p.sendMessage("§6/money add <Amount> <Player> §8- §7Adds an specific amount to an Players balance");
						p.sendMessage("§6/money remove <Amount> <Player> §8- §7Removes an specific amount to an Players balance");
						p.sendMessage("§6/money set <Amount> <Player> §8- §7Set an Players balance to an specific amount");
						p.sendMessage(MessagesConfig.money_header);
					} else {
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
					}					
				} else if(args[0].equalsIgnoreCase("add")) {
					if(p.hasPermission("basicsplus.money.*") || p.hasPermission("basicsplus.money.add") || p.hasPermission("basicplus.*")) {
						if(args.length >= 3) {
							if(Bukkit.getPlayerExact(args[2]) != null) {
								double amount = Double.valueOf(args[1]);
								Player k = Bukkit.getPlayerExact(args[2]);
								MoneyUtils.addMoney(k, amount);
								p.sendMessage(MessagesConfig.prefix + MessagesConfig.money_add.replace("%Balance%", "" + amount).replace("%Currency%", MainConfig.currency).replace("%Player%", k.getName()));
							} else {
								p.sendMessage(MessagesConfig.prefix + MessagesConfig.player_offline);
							}
						} else {
							p.sendMessage(MessagesConfig.prefix + MessagesConfig.arguments_error);
						}
					} else {
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
					}						
				} else if(args[0].equalsIgnoreCase("set")) {
					if(p.hasPermission("basicsplus.money.*") || p.hasPermission("basicsplus.money.set") || p.hasPermission("basicplus.*")) {
						if(args.length >= 3) {
							if(Bukkit.getPlayerExact(args[2]) != null) {
								double amount = Double.valueOf(args[1]);
								Player k = Bukkit.getPlayerExact(args[2]);
								MoneyUtils.setMoney(k, amount);
								p.sendMessage(MessagesConfig.prefix + MessagesConfig.money_set.replace("%Balance%", "" + amount).replace("%Currency%", MainConfig.currency).replace("%Player%", k.getName()));
							} else {
								p.sendMessage(MessagesConfig.prefix + MessagesConfig.player_offline);
							}
						} else {
							p.sendMessage(MessagesConfig.prefix + MessagesConfig.arguments_error);
						}
					} else {
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
					}						
				} else if(args[0].equalsIgnoreCase("remove")) {
					if(p.hasPermission("basicsplus.money.*") || p.hasPermission("basicsplus.money.remove") || p.hasPermission("basicplus.*")) {
						if(args.length >= 3) {
							if(Bukkit.getPlayerExact(args[2]) != null) {
								double amount = Double.valueOf(args[1]);
								Player k = Bukkit.getPlayerExact(args[2]);
								MoneyUtils.removeMoney(k, amount);
								p.sendMessage(MessagesConfig.prefix + MessagesConfig.money_remove.replace("%Balance%", "" + amount).replace("%Currency%", MainConfig.currency).replace("%Player%", k.getName()));
							} else {
								p.sendMessage(MessagesConfig.prefix + MessagesConfig.player_offline);
							}
						} else {
							p.sendMessage(MessagesConfig.prefix + MessagesConfig.arguments_error);
						}
					} else {
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
					}						
				}
			}
		} else {
			System.out.println(MessagesConfig.no_player);
		}		
		return true;
	}
}