package se.neptunmc.neptunpads;

import org.bukkit.plugin.java.JavaPlugin;
import se.neptunmc.neptunpads.command.CommandManager;
import se.neptunmc.neptunpads.events.TempEvent;
import se.neptunmc.neptunpads.menu.MenuEventHandler;
import se.neptunmc.neptunpads.pads.PadEventHandler;
import se.neptunmc.neptunpads.pads.PadManager;

import java.io.File;

public final class NeptunPads extends JavaPlugin {

    private static NeptunPads instance;
    private PadManager padManager;

    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this;
        saveDefaultConfig();

        padManager = new PadManager(this);

        registerCommand();
        registerEvents();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommand() {
        getCommand("neptunpads").setExecutor(new CommandManager());
        getCommand("neptunpads").setTabCompleter(new CommandManager());
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new MenuEventHandler(), this);
        getServer().getPluginManager().registerEvents(new PadEventHandler(), this);
        getServer().getPluginManager().registerEvents(new TempEvent(), this);
    }

    public static NeptunPads getInstance() {
        return instance;
    }

    public PadManager getPadManager() {
        return padManager;
    }

}
