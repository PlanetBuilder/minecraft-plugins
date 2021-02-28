package de.planetbuilder.customizedchat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().fine("Plugin activating");

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().fine("Plugin deactivating");
    }
}
