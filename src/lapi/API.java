package lapi;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.List;

public class API {

    public static ItemStack ItemStack(int id, String name, int date, List<String> lore) {
        ItemStack stack = new ItemStack(Material.getMaterial(id), 1, (short) date);
        ItemMeta stackM = stack.getItemMeta();
        stackM.setDisplayName(name);
        stackM.setLore((List) lore);
        stack.setItemMeta(stackM);
        return stack;
    }

    public static String getPrefix(Player p) {
        return PermissionsEx.getUser(p).getPrefix().replaceAll("&", "§");
    }

    public static String getSuflix(Player p) {
        return PermissionsEx.getUser(p).getSuffix().replaceAll("&", "§");
    }

}
