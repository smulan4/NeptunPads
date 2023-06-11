package se.neptunmc.neptunpads.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import se.neptunmc.neptunpads.NeptunPads;
import se.neptunmc.neptunpads.pads.JumpPad;
import se.neptunmc.neptunpads.utils.ItemUtils;

public class TempEvent implements Listener {

    @EventHandler
    public void onPressurePlatePlace(BlockPlaceEvent event) {

        Player player = event.getPlayer();
        Block block = event.getBlockPlaced();

        if (ItemUtils.isPressurePlate(block.getType())) {
            new JumpPad(block.getLocation(), 10);
        }

    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();
        Block block = event.getBlock();

        if (ItemUtils.isPressurePlate(block.getType())) {
            NeptunPads.getInstance().getPadManager().removeJumpPad(NeptunPads.getInstance().getPadManager().getJumpPad(block.getLocation()));
        }

    }

}
