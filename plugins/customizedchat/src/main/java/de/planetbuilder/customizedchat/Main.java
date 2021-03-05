package de.planetbuilder.customizedchat;
import de.planetbuilder.customizedchat.commands.CommandJoinMassage;
import de.planetbuilder.customizedchat.commands.CommandQuitMessage;
import de.planetbuilder.customizedchat.data.CCPlayerData;
import de.planetbuilder.customizedchat.listeners.ListenerJoin;
import de.planetbuilder.customizedchat.listeners.ListenerQuit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class Main extends JavaPlugin {
    public static HashMap<UUID, CCPlayerData> cCPlayerDataByUUID = new HashMap<>();
    //TODO: Make cCPlayerDataByUUID non-static

    @Override
    public void onEnable() {
        Bukkit.getLogger().fine("Plugin activating");
        listenerRegistration();
        commandRegistration();
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().fine("Plugin deactivating");
    }

    public void listenerRegistration(){
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ListenerJoin(), this);
        pluginManager.registerEvents(new ListenerQuit(), this);
    }

    public void commandRegistration(){
        Objects.requireNonNull(getCommand("joinmessage")).setExecutor(new CommandJoinMassage());
        Objects.requireNonNull(getCommand("quitmessage")).setExecutor(new CommandQuitMessage());
    }
}