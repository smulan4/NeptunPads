package se.neptunmc.neptunpads.pads;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import se.neptunmc.neptunpads.NeptunPads;

public class JumpPad {

    private PadManager padManager = NeptunPads.getInstance().getPadManager();

    private Location padLocation;
    private int strength;

    public JumpPad(Location location) {

        this.padLocation = location;

        padManager.addJumpPad(this);
    }

    public Location getPadLocation() {
        return padLocation;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void action(Player player) {
        player.sendMessage("PlateEvent 4");
        player.setVelocity(player.getLocation().getDirection().multiply(strength));
    }

}
