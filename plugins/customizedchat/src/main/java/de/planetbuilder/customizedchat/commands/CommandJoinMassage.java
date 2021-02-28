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

    public CommandJoinMassage(HashMap<UUID, CCPlayerData> cCPlayerDataByUUID) {
        this.cCPlayerDataByUUID = cCPlayerDataByUUID;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player) || !(command.getName().equalsIgnoreCase("joinmessage"))){
            return false;
        }
        Player player = (Player) sender;
        Player meantPlayer;
        if(args.length != 2 && args.length != 3){
            player.sendMessage("§c(!) /joinmessage <player> <prefix> <suffix>");
            return false;
        }


        try {
            meantPlayer = player.getServer().getPlayer(args[0]);
        } catch (Exception e) {
            return false;
        }
        UUID meantPlayerUUID = meantPlayer.getUniqueId();



        return true;
    }
}