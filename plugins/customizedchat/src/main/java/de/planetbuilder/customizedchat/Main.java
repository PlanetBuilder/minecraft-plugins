package de.planetbuilder.customizedchat;

import de.planetbuilder.customizedchat.commands.CommandJoinMassage;
import de.planetbuilder.customizedchat.data.CCPlayerData;
import de.planetbuilder.customizedchat.listeners.ListenerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class Main extends JavaPlugin {
    public static HashMap<UUID, CCPlayerData> cCPlayerDataByUUID = new HashMap();
    //TODO: Make cCPlayerDataByUUID non-static

    public Main(){

    }

    @Override
    public void onEnable() {
        Bukkit.getLogger().fine("Plugin activating");
        getCommand("joinmessage").setExecutor(new CommandJoinMassage(cCPlayerDataByUUID));
        listenerRegistration();
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().fine("Plugin deactivating");
    }

    public void listenerRegistration(){
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ListenerJoin(cCPlayerDataByUUID), this);
    }



}