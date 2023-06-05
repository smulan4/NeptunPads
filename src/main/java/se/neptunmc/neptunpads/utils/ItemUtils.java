package se.neptunmc.neptunpads.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemUtils {

    // Returns custom item stack
    public static ItemStack createItem(Material material, String displayName, int amount, List<String> lore) {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(TextUtils.color(displayName));
        if (lore != null) {
            List<String> itemLore = new ArrayList<>();
            for (String s : lore) {
                itemLore.add(TextUtils.color(s));
            }
            itemMeta.setLore(itemLore);
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    // Fills empty slots in inventory with filler items.
    public static void setFillers(Inventory inventory, Material material) {
        ItemStack fillerItem = createItem(material, " ", 1, null);
        for(int i = 0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, fillerItem);
            }
        }
    }

    // Returns skull with skin of player
    public static ItemStack getPlayerHead(Player player, String name, List<String> lore) {
        ItemStack head = createItem(Material.PLAYER_HEAD, TextUtils.color(name), 1, lore);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        meta.setOwningPlayer(player);
        head.setItemMeta(meta);
        return head;
    }

    // Checks if block is a pressure plate.
    public static boolean isPressurePlate(Material material) {
        return material.name().endsWith("_PRESSURE_PLATE");
    }

}
