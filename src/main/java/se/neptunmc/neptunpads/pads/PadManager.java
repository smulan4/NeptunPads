package se.neptunmc.neptunpads.pads;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import se.neptunmc.neptunpads.NeptunPads;

import java.util.ArrayList;
import java.util.List;

public class PadManager {

    private final NeptunPads main;
    private final FileConfiguration config;

    private List<JumpPad> jumpPadList;

    public PadManager(NeptunPads main) {
        this.main = main;
        config = main.getConfig();
        jumpPadList = new ArrayList<>();
        // jumpPadList = loadPads();
    }

    public List<JumpPad> loadPads() {
        List<JumpPad> newList = new ArrayList<>();



        return newList;
    }

    public void savePads() {

    }

    public List<JumpPad> getJumpPads() {
        return jumpPadList;
    }

    public JumpPad getJumpPad(Location location) {
        for (JumpPad jumpPad : jumpPadList) {
            Location padLocation = jumpPad.getPadLocation();
            if (padLocation.getBlockX() == location.getBlockX() &&
                    padLocation.getBlockY() == location.getBlockY() &&
                    padLocation.getBlockZ() == location.getBlockZ()) {
                return jumpPad;
            }
        }
        return null;
    }

    public void addJumpPad(JumpPad jumpPad) {
        jumpPadList.add(jumpPad);
    }

    public void removeJumpPad(JumpPad jumpPad) {
        jumpPadList.remove(jumpPad);
    }

}
