package de.planetbuilder.customizedchat;

import de.planetbuilder.customizedchat.commands.CommandJoinMassage;
import de.planetbuilder.customizedchat.data.CCPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class Main extends JavaPlugin {
    private HashMap<UUID, CCPlayerData> cCPlayerDataByUUID = new HashMap();



    @Override
    public void onEnable() {
        Bukkit.getLogger().fine("Plugin activating");
        getCommand("joinmessage").setExecutor(new CommandJoinMassage(cCPlayerDataByUUID));
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().fine("Plugin deactivating");
    }



}