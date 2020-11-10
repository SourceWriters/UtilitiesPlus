package com.syntaxphoenix.utilitiesplus.configs;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class MessagesConfig {
	
	public static File f = new File("plugins/UtilitiesPlus", "messages.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	public static String prefix = "&6Utilities&ePlus &8[>>] ";
	
	public static String no_player = "You are not a Player!";
	public static String player_offline = "&cThe player seems to be offline";
	public static String no_permission_command = "&cYou are not allowed to use this command";
	public static String arguments_error = "&cNot enough/too much Arguments. &7Try &6";
	

	public static String spawn_not_set = "&cThe Spawn-Location has not been set";
	public static String spawn_set = "&7The Spawn-Location has &asuccessfully &7been set";
	
	public static String warp_already_set = "&cA Warp with this name has already been set.";
	public static String warp_invalid = "&cInvalid Warp";
	public static String warps_header = "&7[>>] &6Warps &7[<<]";
	public static String warps_empty = "&cCurrently no warps has been set";
	
	public static String time_to_night = "&7Time has been set to &6Night";
	public static String time_to_day = "&7Time has been set to &6Day";
	

	public static String weather_to_sun = "&7Weather has been set to &6Sunny";
	public static String weather_to_rain = "&7Weather has been set to &6Rain";
	public static String weather_to_thunder = "&7Weather has been set to &6Thunder";
	
	public static String pm_yourself = "&cYou can not send messages to yourself";
	
	public static String home_set = "&7Your §aHome §7has successfully been set";
	public static String home_not_set = "&7You have to set your Home-Location first!";
	public static String home_tp = "&7You had been successfully teleported to your §aHome";
	
	public static String kickall_kick_msg = "&7You has been kicked by &6%Player%";
	public static String kickall_inform = "&7You kicked all Players";
	
	public static String money_balance = "&7You have currently an balance of &6%Balance%%Currency%";
	public static String money_add = "&7You added successfully &6%Balance%%Currency%&7 to &a%Player%'s &7balance";
	public static String money_remove = "&7You removed successfully &6%Balance%%Currency% &7from &a%Player%'s &7balance";
	public static String money_set = "&7You set successfully %Player%'s balance to &6%Balance%%Currency%";
	
	public static String money_help = "&7Please enter &c/money help";
	public static String money_header = "&7[>>] &6Money&7-&eHelp &7[<<]";
	
	public static String fly_enabled = "&7Flying &aenabled";
	public static String fly_disabled = "&7Flying &cdisabled";
	
	public static String tpall_message = "&7All Players had been teleported to you";
	public static String tpall_message_players = "&7You have been teleported to &e%Player%";
	
	public static String god_enabled = "&7God-Mode &aenabled";
	public static String god_disabled = "&7God-Mode &cdisabled";
	
	public static void load() {	
		prefix = fixColorCodes(setObject("Global.Prefix", prefix));
		
		no_player = fixColorCodes(setObject("Global.Error.No-Player", no_player));
		player_offline = fixColorCodes(setObject("Global.Error.Player-Offline", player_offline));
		no_permission_command = fixColorCodes(setObject("Global.Error.No-permission-Command", no_permission_command));
		arguments_error = fixColorCodes(setObject("Global.Error.Arguments-Error", arguments_error));
		
		spawn_not_set = fixColorCodes(setObject("Spawn.Not-Set", spawn_not_set));
		spawn_set = fixColorCodes(setObject("Spawn.Set", spawn_set));
		
		warp_already_set = fixColorCodes(setObject("Warp.Already-Set", warp_already_set));
		warp_invalid = fixColorCodes(setObject("Warp.Invalid", warp_invalid));
		warps_header = fixColorCodes(setObject("Warp.Header", warps_header));
		warps_empty = fixColorCodes(setObject("Warp.Empty", warps_empty));
		
		time_to_night = fixColorCodes(setObject("Time.Night", time_to_night));
		time_to_day = fixColorCodes(setObject("Time.Day", time_to_day));

		weather_to_sun = fixColorCodes(setObject("Weather.Sun", weather_to_sun));
		weather_to_rain = fixColorCodes(setObject("Weather.Rain", weather_to_rain));
		weather_to_thunder = fixColorCodes(setObject("Weather.Thunder", weather_to_thunder));

		pm_yourself = fixColorCodes(setObject("PM.Yourself", pm_yourself));
		
		home_set = fixColorCodes(setObject("Home.Set", home_set));
		home_tp = fixColorCodes(setObject("Home.Tp", home_tp));
		home_not_set = fixColorCodes(setObject("Home.Not-Set", home_not_set));
		
		kickall_kick_msg = fixColorCodes(setObject("Kickall.Kick-Msg", kickall_kick_msg));
		kickall_inform = fixColorCodes(setObject("Kickall.Inform", kickall_inform));
		
		money_help = fixColorCodes(setObject("Money.Help.Help-Inform", money_help));
		money_header = fixColorCodes(setObject("Money.Help.Header", money_header));
		
		money_balance = fixColorCodes(setObject("Money.Balance", money_balance));
		money_add = fixColorCodes(setObject("Money.Add", money_add));
		money_set = fixColorCodes(setObject("Money.Set", money_set));
		money_remove = fixColorCodes(setObject("Money.Remove", money_remove));
		
		fly_enabled = fixColorCodes(setObject("Fly.Enabled", fly_enabled));
		fly_disabled = fixColorCodes(setObject("Fly.Disabled", fly_disabled));
		
		tpall_message = fixColorCodes(setObject("Tpall.Message.Message", tpall_message));
		tpall_message_players = fixColorCodes(setObject("Tpall.Message.Players", tpall_message_players));
		
		god_enabled = fixColorCodes(setObject("God.Enabled", god_enabled));
		god_disabled = fixColorCodes(setObject("God.Disabled", god_disabled));
	}
	
	public static String fixColorCodes(String code) {
		code = code.replace("&", "§");
		code = code.replace("[<<]", "«");
		code = code.replace("[>>]", "»");
		return code;
	}
	
	public static String setObject(String path, String obj) {
		if(cfg.contains(path)) {
			return cfg.getString(path);
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