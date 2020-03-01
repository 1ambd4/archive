package cn.lttzz.minecraft.bukkit.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

	public Plugin() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onEnable() {
		getLogger().info("Plugin is enabled.");
		
		getServer().getPluginManager().registerEvents(new EventListener(), this);
	}

	@Override
	public void onDisable() {
		super.onDisable();
	}	
}