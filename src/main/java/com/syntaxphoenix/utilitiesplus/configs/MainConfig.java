package com.syntaxphoenix.utilitiesplus.configs;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class MainConfig {
	
	public static File f = new File("plugins/UtilitiesPlus", "config.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	public static String currency = "€";
	
	public static boolean spawn_on_join = false;
	
	public static void load() {
		currency = fixColorCodes(setObject("Money-System.Prefix", currency));
		
		spawn_on_join = setObject("Spawn.Join", spawn_on_join);
	}
	
	public static String fixColorCodes(String code) {
		code = code.replace("&", "§");
		return code;
	}
	
	public static String setObject(String path, String obj) {
		if (cfg.contains(path)) {
			return cfg.getString(path);
		} else {
			cfg.set(path, obj);
			save();
			return obj;
		}
	}
	
	public static boolean setObject(String path, boolean obj) {
		if (cfg.contains(path)) {
			return cfg.getBoolean(path);
		} else {
			cfg.set(path, obj);
			save();
			return obj;
		}
	}
	
	public static void save() {
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}