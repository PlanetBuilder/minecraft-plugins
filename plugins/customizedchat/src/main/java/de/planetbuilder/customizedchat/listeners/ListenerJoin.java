package de.planetbuilder.customizedchat.listeners;

import de.planetbuilder.customizedchat.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class ListenerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage(Main.cCPlayerDataByUUID.get(player.getUniqueId()).getJoinMessagePrefix() + player.getDisplayName() + Main.cCPlayerDataByUUID.get(player.getUniqueId()).getJoinMessageSuffix());
    }

}
