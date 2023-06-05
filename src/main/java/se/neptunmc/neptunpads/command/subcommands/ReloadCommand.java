package se.neptunmc.neptunpads.command.subcommands;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import se.neptunmc.neptunpads.NeptunPads;
import se.neptunmc.neptunpads.command.CommandInterface;
import se.neptunmc.neptunpads.utils.TextUtils;

import java.util.List;

public class ReloadCommand implements CommandInterface {

    private final NeptunPads main = NeptunPads.getInstance();
    private final FileConfiguration config = main.getConfig();

    @Override
    public String desc() {
        return "Reloads the config.";
    }

    @Override
    public List<String> commandArgs(Player Player, String[] args) {
        return null;
    }

    @Override
    public void execute(Player player, String[] args) {
        main.saveConfig();
        main.reloadConfig();
        player.sendMessage(TextUtils.color(config.getString("Reload")));
    }
}
