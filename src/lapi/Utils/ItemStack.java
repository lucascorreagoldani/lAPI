package lapi.Utils;

import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemStack {

    public static org.bukkit.inventory.ItemStack ItemStack(int id, String name, int date, List<String> lore) {
        org.bukkit.inventory.ItemStack stack = new org.bukkit.inventory.ItemStack(Material.getMaterial(id), 1, (short) date);
        ItemMeta stackM = stack.getItemMeta();
        stackM.setDisplayName(name);
        stackM.setLore((List) lore);
        stack.setItemMeta(stackM);
        return stack;
    }

}
