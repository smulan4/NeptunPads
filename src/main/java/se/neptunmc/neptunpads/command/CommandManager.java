package se.neptunmc.neptunpads.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import se.neptunmc.neptunpads.command.subcommands.HelpCommand;
import se.neptunmc.neptunpads.command.subcommands.ReloadCommand;
import se.neptunmc.neptunpads.utils.TextUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManager implements CommandExecutor, TabCompleter {

    private final Map<String, CommandInterface> commands = new HashMap<>();

    public CommandManager() {
        commands.put("help", new HelpCommand(commands));
        commands.put("reload", new ReloadCommand());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        if (!player.hasPermission("template.*")) {
            player.sendMessage(TextUtils.color("&cPermission denied."));
        }

        if (args.length == 0) {
            commands.get("help").execute(player, args);
            return true;
        }

        String commandName = args[0].toLowerCase();
        CommandInterface cmd = commands.get(commandName);

        if (cmd == null) {
            player.sendMessage(TextUtils.color("&cUnknown subcommand. Use '/template help'."));
            return true;
        }

        cmd.execute(player, args);

        return false;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;

        if (args.length == 1) {
            return new ArrayList<>(commands.keySet());
        }

        if (args.length >= 2) {
            String commandName = args[0];
            CommandInterface cmd = commands.get(commandName);
            if (cmd != null) {
                return cmd.commandArgs(player, args);
            }
        }

        return null;
    }

}
