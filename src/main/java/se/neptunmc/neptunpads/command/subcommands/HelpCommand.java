package se.neptunmc.neptunpads.command.subcommands;

import org.bukkit.entity.Player;
import se.neptunmc.neptunpads.command.CommandInterface;
import se.neptunmc.neptunpads.utils.TextUtils;

import java.util.List;
import java.util.Map;

public class HelpCommand implements CommandInterface {

    private final Map<String, CommandInterface> commands;

    public HelpCommand(Map<String, CommandInterface> commands) {
        this.commands = commands;
    }

    @Override
    public String desc() {
        return "Returns a list of our commands and their usages.";
    }

    @Override
    public List<String> commandArgs(Player Player, String[] args) {
        return null;
    }

    @Override
    public void execute(Player player, String[] args) {

        player.sendMessage(TextUtils.color("&8» &b&lNEPTUN PADS &8| &f&lCommands:"));
        for(Map.Entry<String, CommandInterface> commands : commands.entrySet()) {
            player.sendMessage(TextUtils.color("&b/npads " + commands.getKey()));
            player.sendMessage(TextUtils.color("&8| &f&o" + commands.getValue().desc()));
        }
    }
}
