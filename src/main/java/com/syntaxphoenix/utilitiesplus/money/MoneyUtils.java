package com.syntaxphoenix.utilitiesplus.money;

import org.bukkit.entity.Player;

public class MoneyUtils {
	
	public static void addMoney(Player p, double amount) {
		MoneyConfig.addMoney(p.getUniqueId().toString(), amount);
	}
	
	public static void setMoney(Player p, double amount) {
		MoneyConfig.addMoney(p.getUniqueId().toString(), amount);
	}
	
	public static void removeMoney(Player p, double amount) {
		MoneyConfig.removeMoney(p.getUniqueId().toString(), amount);
	}
	
	public static double getBalance(Player p) {
		return MoneyConfig.getBalance(p.getUniqueId().toString());
	}

}