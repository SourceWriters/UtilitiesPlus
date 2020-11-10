package com.syntaxphoenix.utilitiesplus.commands.money;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.syntaxphoenix.utilitiesplus.configs.MainConfig;
import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;
import com.syntaxphoenix.utilitiesplus.money.MoneyUtils;

public class BalanceCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {	
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("utilitiesplus.money.*") || p.hasPermission("utilitiesplus.money.balance") || p.hasPermission("utilitiesplus.*")) {
				p.sendMessage(MessagesConfig.prefix + MessagesConfig.money_balance.replace("%Balance%", "" + MoneyUtils.getBalance(p)).replace("%Currency%", MainConfig.currency));
			} else {
				p.sendMessage(MessagesConfig.prefix + MessagesConfig.no_permission_command);
			}
		} else {
			System.out.println(MessagesConfig.no_player);
		}
		
		return true;
	}

}