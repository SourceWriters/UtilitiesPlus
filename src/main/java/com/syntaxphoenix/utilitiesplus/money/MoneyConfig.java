package com.syntaxphoenix.utilitiesplus.money;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class MoneyConfig {
	
	public static File f = new File("plugins/UtilitiesPlus", "money.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	public static void setMoney(String uuid, double money) {
		cfg.set("balance." + uuid, money);
		save();
	}
	
	public static void addMoney(String uuid, double money) {
		double i_money = getBalance(uuid);
		i_money = i_money + money;
		cfg.set("balance." + uuid, i_money);
		save();
	}
	
	public static void removeMoney(String uuid, double money) {
		double i_money = getBalance(uuid);
		i_money = i_money - money;
		cfg.set("balance." + uuid, i_money);
		save();
	}
	
	public static double getBalance(String uuid) {
		double money = 0;
		if(cfg.contains("balance." + uuid)) {
			money = cfg.getDouble("balance." + uuid);
		}
		return money;
	}
	
	public static void save() {
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}