package de.planetbuilder.customizedchat.listeners;

import de.planetbuilder.customizedchat.Main;
import de.planetbuilder.customizedchat.data.CCPlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.UUID;

public class ListenerJoin implements Listener {

    private HashMap<UUID, CCPlayerData> ccPlayerDataByUUID;

    public ListenerJoin(HashMap<UUID, CCPlayerData> cCPlayerDataByUUID) {
        this.ccPlayerDataByUUID = cCPlayerDataByUUID;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage(Main.cCPlayerDataByUUID.get(player.getUniqueId()).getJoinMessagePrefix() + player.getDisplayName() + Main.cCPlayerDataByUUID.get(player.getUniqueId()).getJoinMessageSuffix());
    }

}
