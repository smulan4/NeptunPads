package se.neptunmc.neptunpads.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import se.neptunmc.neptunpads.NeptunPads;
import se.neptunmc.neptunpads.utils.TextUtils;

public abstract class Menu implements InventoryHolder {

    protected NeptunPads main = NeptunPads.getInstance();

    public abstract String title();
    public abstract int size();

    protected Player player;
    protected Inventory inventory;

    public Menu(Player player, Player target) {
        this.player = player;
        inventory = Bukkit.createInventory(this, size(), TextUtils.color(title()));
        createComponents();
    }

    protected abstract void createComponents();

    protected abstract void handleClick(InventoryClickEvent event);

    public void open() {
        player.openInventory(inventory);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}