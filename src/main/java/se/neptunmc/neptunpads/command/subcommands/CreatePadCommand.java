package se.neptunmc.neptunpads.command.subcommands;

import org.bukkit.entity.Player;
import se.neptunmc.neptunpads.command.CommandInterface;

import java.util.List;

public class CreatePadCommand implements CommandInterface {

    @Override
    public String desc() {
        return "Creates jump pad.";
    }

    @Override
    public List<String> commandArgs(Player Player, String[] args) {
        return null;
    }

    @Override
    public void execute(Player player, String[] args) {

    }
}
