package se.neptunmc.neptunpads.pads;

import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import se.neptunmc.neptunpads.NeptunPads;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PadManager {

    private final Plugin plugin;
    private final FileConfiguration config;

    private List<JumpPad> jumpPadList;

    public PadManager(NeptunPads plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
        this.jumpPadList = new ArrayList<>();
    }


    public List<JumpPad> getJumpPads() {
        return jumpPadList;
    }

    public JumpPad getJumpPad(Location location) {
        for (JumpPad jumpPad : jumpPadList) {
            if (jumpPad.getPadLocation().equals(location)) {
                return jumpPad;
            }
        }
        return null;
    }

    public void addJumpPad(JumpPad jumpPad) {
        ConfigurationSection launchPadsSection = config.getConfigurationSection("pads");
        if (!config.contains("pads")) {
            launchPadsSection = config.createSection("pads");
        }

        int padNumber = launchPadsSection.getKeys(false).size() + 1;
        ConfigurationSection padSection = launchPadsSection.createSection("pad" + padNumber);
        Location location = jumpPad.getPadLocation();
        List<Integer> coordinates = new ArrayList<>();
        coordinates.add(location.getBlockX());
        coordinates.add(location.getBlockY());
        coordinates.add(location.getBlockZ());
        padSection.set("strength", jumpPad.getStrength());
        padSection.set("world", location.getWorld().getName());
        padSection.set("coordinates", coordinates);
        jumpPadList.add(jumpPad);
        plugin.saveConfig();
    }

    public void removeJumpPad(JumpPad jumpPad) {
        ConfigurationSection launchPadsSection = config.getConfigurationSection("pads");

        if (!config.contains("pads")) {
            return;
        }

        Location location = jumpPad.getPadLocation();
        Set<String> sectionKeys = launchPadsSection.getKeys(false);
        for (String key : sectionKeys) {
            ConfigurationSection padSection = launchPadsSection.getConfigurationSection(key);
            List<Integer> coordinates = padSection.getIntegerList("coordinates");
            int x = coordinates.get(0);
            int y = coordinates.get(1);
            int z = coordinates.get(2);
            Location sectionLocation = new Location(plugin.getServer().getWorld(padSection.getString("world")), x, y, z);
            if (location.equals(sectionLocation)) {
                launchPadsSection.set(key, null);
                break;
            }
        }

        sectionKeys = launchPadsSection.getKeys(false);
        int number = 1;
        for (String key : sectionKeys) {
            ConfigurationSection padSection = launchPadsSection.getConfigurationSection(key);
            launchPadsSection.set(key, null);
            key = "pad" + number;
            launchPadsSection.set(key, padSection);
            number++;
        }

        plugin.saveConfig();
        jumpPadList.remove(jumpPad);
    }

}
