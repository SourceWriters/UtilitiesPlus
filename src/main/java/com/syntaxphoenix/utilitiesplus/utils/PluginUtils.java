package com.syntaxphoenix.utilitiesplus.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

import com.syntaxphoenix.syntaxphoenixstats.SyntaxPhoenixStats;
import com.syntaxphoenix.utilitiesplus.UtilitiesPlus;
import com.syntaxphoenix.utilitiesplus.commands.EnderChestCommand;
import com.syntaxphoenix.utilitiesplus.commands.FlyCommand;
import com.syntaxphoenix.utilitiesplus.commands.GodCommand;
import com.syntaxphoenix.utilitiesplus.commands.InvseeCommand;
import com.syntaxphoenix.utilitiesplus.commands.KickallCommand;
import com.syntaxphoenix.utilitiesplus.commands.KillallCommand;
import com.syntaxphoenix.utilitiesplus.commands.PmCommand;
import com.syntaxphoenix.utilitiesplus.commands.daytime.DayCommand;
import com.syntaxphoenix.utilitiesplus.commands.daytime.NightCommand;
import com.syntaxphoenix.utilitiesplus.commands.gamemode.GameModeAdventureCommand;
import com.syntaxphoenix.utilitiesplus.commands.gamemode.GameModeCommand;
import com.syntaxphoenix.utilitiesplus.commands.gamemode.GameModeCreativeCommand;
import com.syntaxphoenix.utilitiesplus.commands.gamemode.GameModeSpectatorCommand;
import com.syntaxphoenix.utilitiesplus.commands.gamemode.GameModeSurvivalCommand;
import com.syntaxphoenix.utilitiesplus.commands.home.HomeCommand;
import com.syntaxphoenix.utilitiesplus.commands.home.SetHomeCommand;
import com.syntaxphoenix.utilitiesplus.commands.money.BalanceCommand;
import com.syntaxphoenix.utilitiesplus.commands.money.MoneyCommand;
import com.syntaxphoenix.utilitiesplus.commands.spawn.SetSpawnCommand;
import com.syntaxphoenix.utilitiesplus.commands.spawn.SpawnCommand;
import com.syntaxphoenix.utilitiesplus.commands.tp.TpallCommand;
import com.syntaxphoenix.utilitiesplus.commands.warps.RemoveWarpCommand;
import com.syntaxphoenix.utilitiesplus.commands.warps.SetWarpCommand;
import com.syntaxphoenix.utilitiesplus.commands.warps.WarpCommand;
import com.syntaxphoenix.utilitiesplus.commands.warps.WarpsCommand;
import com.syntaxphoenix.utilitiesplus.commands.weather.RainCommand;
import com.syntaxphoenix.utilitiesplus.commands.weather.SunCommand;
import com.syntaxphoenix.utilitiesplus.commands.weather.ThunderCommand;
import com.syntaxphoenix.utilitiesplus.configs.MainConfig;
import com.syntaxphoenix.utilitiesplus.configs.MessagesConfig;
import com.syntaxphoenix.utilitiesplus.listener.DamageListener;
import com.syntaxphoenix.utilitiesplus.listener.JoinListener;

public class PluginUtils {
	
	public static List<Player> godPlayers = new ArrayList<Player>();
	
	public static void setUp() {
		MessagesConfig.load();
		MainConfig.load();
		loadCommands();
		loadListener();
		new SyntaxPhoenixStats("6cetr3db", UtilitiesPlus.m);
	}
	
	public static void loadCommands() {
		UtilitiesPlus.m.getCommand("spawn").setExecutor(new SpawnCommand());
		UtilitiesPlus.m.getCommand("setspawn").setExecutor(new SetSpawnCommand());
		
		UtilitiesPlus.m.getCommand("warp").setExecutor(new WarpCommand());
		UtilitiesPlus.m.getCommand("setwarp").setExecutor(new SetWarpCommand());
		UtilitiesPlus.m.getCommand("remwarp").setExecutor(new RemoveWarpCommand());
		UtilitiesPlus.m.getCommand("warps").setExecutor(new WarpsCommand());
		
		UtilitiesPlus.m.getCommand("night").setExecutor(new NightCommand());
		UtilitiesPlus.m.getCommand("day").setExecutor(new DayCommand());
		
		UtilitiesPlus.m.getCommand("pm").setExecutor(new PmCommand());
		
		UtilitiesPlus.m.getCommand("invsee").setExecutor(new InvseeCommand());
		
		UtilitiesPlus.m.getCommand("gm").setExecutor(new GameModeCommand());
		UtilitiesPlus.m.getCommand("gma").setExecutor(new GameModeAdventureCommand());
		UtilitiesPlus.m.getCommand("gms").setExecutor(new GameModeSurvivalCommand());
		UtilitiesPlus.m.getCommand("gmc").setExecutor(new GameModeCreativeCommand());
		UtilitiesPlus.m.getCommand("gmsp").setExecutor(new GameModeSpectatorCommand());
		
		UtilitiesPlus.m.getCommand("sethome").setExecutor(new SetHomeCommand());
		UtilitiesPlus.m.getCommand("home").setExecutor(new HomeCommand());
		
		UtilitiesPlus.m.getCommand("sun").setExecutor(new SunCommand());
		UtilitiesPlus.m.getCommand("rain").setExecutor(new RainCommand());
		UtilitiesPlus.m.getCommand("thunder").setExecutor(new ThunderCommand());

		UtilitiesPlus.m.getCommand("kickall").setExecutor(new KickallCommand());
		
		UtilitiesPlus.m.getCommand("killall").setExecutor(new KillallCommand());
		
		UtilitiesPlus.m.getCommand("balance").setExecutor(new BalanceCommand());
		UtilitiesPlus.m.getCommand("money").setExecutor(new MoneyCommand());
		

		UtilitiesPlus.m.getCommand("fly").setExecutor(new FlyCommand());
		
		UtilitiesPlus.m.getCommand("tpall").setExecutor(new TpallCommand());
		
		UtilitiesPlus.m.getCommand("god").setExecutor(new GodCommand());	
		
		UtilitiesPlus.m.getCommand("enderchest").setExecutor(new EnderChestCommand());
		UtilitiesPlus.m.getCommand("ec").setExecutor(new EnderChestCommand());
		UtilitiesPlus.m.getCommand("echest").setExecutor(new EnderChestCommand());
	}
	
	public static void loadListener() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new JoinListener(), UtilitiesPlus.m);
		pm.registerEvents(new DamageListener(), UtilitiesPlus.m);
	}

}