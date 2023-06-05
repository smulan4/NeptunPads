package se.neptunmc.neptunpads.pads;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import se.neptunmc.neptunpads.NeptunPads;
import se.neptunmc.neptunpads.utils.ItemUtils;

public class PadEventHandler implements Listener {

    private PadManager padManager = NeptunPads.getInstance().getPadManager();

    @EventHandler
    public void onPadMove(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        Location location = player.getLocation();
        Block block = location.getBlock();

        if (!ItemUtils.isPressurePlate(block.getType())) return;

        JumpPad jumpPad = padManager.getJumpPad(location);
        if (jumpPad != null) {
            jumpPad.action(player);
        }

    }

}
