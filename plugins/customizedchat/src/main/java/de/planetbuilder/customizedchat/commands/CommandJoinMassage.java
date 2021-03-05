package de.planetbuilder.customizedchat.commands;

import de.planetbuilder.customizedchat.Main;
import de.planetbuilder.customizedchat.data.CCPlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.regex.Pattern;


public class CommandJoinMassage implements CommandExecutor {
    Player player;
    Player meantPlayer;
    UUID meantPlayerUUID;
    CCPlayerData temporaryCCPlayerData = new CCPlayerData();
    String prefix;
    String suffix;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player) || !(command.getName().equalsIgnoreCase("joinmessage") || command.getName().equalsIgnoreCase("setjoinmessage"))){
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

        temporaryCCPlayerData.setJoinMessagePrefix(prefix);
        temporaryCCPlayerData.setJoinMessageSuffix(suffix);

        Main.cCPlayerDataByUUID.put(meantPlayerUUID, temporaryCCPlayerData);


        return true;
    }

    public static final Pattern PATTERN = Pattern.compile("\"?( |$)(?=(([^\"]*\"){2})*[^\"]*$)\"?");

    public String[] quotedSpaces(String[] arguments) {
        return PATTERN.split(String.join(" ", arguments).replaceAll("^\"", ""));
    }
}
