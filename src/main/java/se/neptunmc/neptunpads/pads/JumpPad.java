package se.neptunmc.neptunpads.pads;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import se.neptunmc.neptunpads.NeptunPads;

public class JumpPad {

    private final Location padLocation;
    private int strength;

    public JumpPad(Location location, int strength) {

        this.padLocation = location;
        this.strength = strength;

        PadManager padManager = NeptunPads.getInstance().getPadManager();
        padManager.addJumpPad(this);
    }

    public Location getPadLocation() {
        return padLocation;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void action(Player player) {
        player.sendMessage("PlateEvent 4");
        player.setVelocity(player.getLocation().getDirection().multiply(strength));
    }

}
