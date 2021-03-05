package de.planetbuilder.customizedchat.commands;

import de.planetbuilder.customizedchat.Main;
import de.planetbuilder.customizedchat.data.CCPlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;


public class CommandQuitMessage implements CommandExecutor {
    Player player;
    Player meantPlayer;
    UUID meantPlayerUUID;
    CCPlayerData temporaryCCPlayerData = new CCPlayerData();
    String prefix;
    String suffix;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player) || !(command.getName().equalsIgnoreCase("quitmessage") || command.getName().equalsIgnoreCase("setquitmessage"))){
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

        for(int i = 0; i < (args.length - 1); i++){
            args[i] = args[i+1];
        }
        args[args.length-1] = null;


        prefix = quotedSpaces(args)[0];
        suffix = quotedSpaces(args)[1];

        prefix = prefix.replace('&', '§');
        suffix = suffix.replace('&', '§');

        temporaryCCPlayerData.setQuitMessagePrefix(prefix);
        temporaryCCPlayerData.setQuitMessageSuffix(suffix);

        Main.cCPlayerDataByUUID.put(meantPlayerUUID, temporaryCCPlayerData);


        return true;
    }

    public String[] quotedSpaces(String[] arguments) {
        return CommandJoinMassage.PATTERN.split(String.join(" ", arguments).replaceAll("^\"", ""));
    }
}
