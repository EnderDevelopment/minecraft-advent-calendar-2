package com.enderdevelopment.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Calendar plugin enabled!");
        getCommand("calendar").setExecutor(new CalendarCommand(this));
        getServer().getPluginManager().registerEvents(new CalendarListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Calendar plugin disabled!");
    }
}