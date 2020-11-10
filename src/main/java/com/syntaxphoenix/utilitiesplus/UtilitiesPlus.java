package com.syntaxphoenix.utilitiesplus;

import org.bukkit.plugin.java.JavaPlugin;

import com.syntaxphoenix.utilitiesplus.utils.PluginUtils;

public class UtilitiesPlus extends JavaPlugin {
	
	public static UtilitiesPlus m;
	
	public void onEnable() {
		m = this;
		PluginUtils.setUp();
	}
	
	public void onDisable() {
		
	}
}