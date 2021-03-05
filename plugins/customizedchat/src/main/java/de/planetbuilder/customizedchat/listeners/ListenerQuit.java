package de.planetbuilder.customizedchat.listeners;

import de.planetbuilder.customizedchat.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;


public class ListenerQuit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        event.setQuitMessage(Main.cCPlayerDataByUUID.get(player.getUniqueId()).getQuitMessagePrefix() + player.getDisplayName() + Main.cCPlayerDataByUUID.get(player.getUniqueId()).getQuitMessageSuffix());
    }

}
