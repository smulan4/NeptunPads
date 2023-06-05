package se.neptunmc.neptunpads.command;

import org.bukkit.entity.Player;

import java.util.List;

public interface CommandInterface {

    String desc();
    List<String> commandArgs(Player Player, String[] args);
    void execute(Player player, String[] args);

}
