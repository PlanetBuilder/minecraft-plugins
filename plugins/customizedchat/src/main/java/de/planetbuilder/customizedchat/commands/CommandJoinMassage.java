package de.planetbuilder.customizedchat.commands;

import de.planetbuilder.customizedchat.Main;
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
    CCPlayerData temporareCCPlayerData = new CCPlayerData();
    String prefix;
    String suffix;

    public CommandJoinMassage(HashMap<UUID, CCPlayerData> cCPlayerDataByUUID) {
        this.cCPlayerDataByUUID = cCPlayerDataByUUID;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player) || !(command.getName().equalsIgnoreCase("joinmessage")) || (args.length != 2 && args.length != 3)){
            return false;
        }

        player = (Player) sender;

        try {
            meantPlayer = player.getServer().getPlayer(args[0]);
        } catch (Exception e) {
            return false;
        }

        assert meantPlayer != null;
        meantPlayerUUID = meantPlayer.getUniqueId();

        prefix = args[1].replace('&', '§');
        suffix = args[2].replace('&', '§');

        temporareCCPlayerData.setJoinMessagePrefix(prefix);
        temporareCCPlayerData.setJoinMessageSuffix(suffix);

        Main.cCPlayerDataByUUID.put(meantPlayerUUID, temporareCCPlayerData);




        return true;
    }
}