package com.syntaxphoenix.utilitiesplus.locations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class LocationsConfig {
	
	public static File f = new File("plugins/UtilitiesPlus/Locations", "locations.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	public static void setLocation(String path, Location loc) {
		cfg.set("Location." + path + ".world", loc.getWorld().getName());
		cfg.set("Location." + path + ".x", loc.getX());
		cfg.set("Location." + path + ".y", loc.getY());
		cfg.set("Location." + path + ".z", loc.getZ());
		cfg.set("Location." + path + ".yaw", loc.getYaw());
		cfg.set("Location." + path + ".pitch", loc.getPitch());
		save();
	}
	
	public static Location getLocation(String path) {
		Location loc = null;
		if(cfg.getString("Location." + path + ".world") != null) {
			World w = Bukkit.getWorld(cfg.getString("Location." + path + ".world"));
			double x = cfg.getDouble("Location." + path + ".x");
			double y = cfg.getDouble("Location." + path + ".y");
			double z = cfg.getDouble("Location." + path + ".z");
			double yaw = cfg.getDouble("Location." + path + ".yaw");
			double pitch = cfg.getDouble("Location." + path + ".pitch");
			loc = new Location(w, x, y, z, (float) yaw, (float) pitch);
		}
		return loc;
	}
	
	public static void removeLocation(String path) {
		cfg.set("Location." + path + ".world", null);
		cfg.set("Location." + path + ".x", null);
		cfg.set("Location." + path + ".y", null);
		cfg.set("Location." + path + ".z", null);
		cfg.set("Location." + path + ".yaw", null);
		cfg.set("Location." + path + ".pitch", null);
		cfg.set("Location." + path, null);
		save();
	}
	
	public static void addToWarpList(String path) {
		List<String> warps = new ArrayList<String>();
		if(cfg.getStringList("Warps") != null) {
			warps = cfg.getStringList("Warps");
		}
		warps.add(path);
		cfg.set("Warps", warps);
	}
	
	public static void removeFromWarpList(String path) {
		List<String> warps = new ArrayList<String>();
		if(cfg.getStringList("Warps") != null) {
			warps = cfg.getStringList("Warps");
		}
		if(warps.contains(path)) {
			warps.remove(path);
		}
		cfg.set("Warps", warps);
	}
	
	public static List<String> getWarpList() {
		List<String> warps = new ArrayList<String>();
		if(cfg.getStringList("Warps") != null) {
			warps = cfg.getStringList("Warps");
		}
		return warps;
	}
	
	public static void save() {
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}