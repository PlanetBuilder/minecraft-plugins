package de.planetbuilder.customizedchat.commands;

import de.planetbuilder.customizedchat.data.CCPlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;


public class CommandJoinMassage implements CommandExecutor {
    private HashMap<UUID, CCPlayerData> cCPlayerDataByUUID;
    Player player;
    Player meantPlayer;
    UUID meantPlayerUUID;
    CCPlayerData temporareCCPlayerData;

    public CommandJoinMassage(HashMap<UUID, CCPlayerData> cCPlayerDataByUUID) {
        this.cCPlayerDataByUUID = cCPlayerDataByUUID;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player) || !(command.getName().equalsIgnoreCase("joinmessage"))){
            return false;
        }

        player = (Player) sender;

        if(args.length != 2 && args.length != 3){
            player.sendMessage("§c(!) /joinmessage <player> <prefix> <suffix>");
            return false;
        }

        try {
            meantPlayer = player.getServer().getPlayer(args[0]);
        } catch (Exception e) {
            return false;
        }

        meantPlayerUUID = meantPlayer.getUniqueId();
        temporareCCPlayerData.setJoinMessagePrefix(args[1]);
        temporareCCPlayerData.setJoinMessageSuffix(args[2]);




        return true;
    }
}