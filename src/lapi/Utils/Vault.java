package lapi.Utils;

import java.text.DecimalFormat;

import lapi.Main;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.RegisteredServiceProvider;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;

public class Vault {

    public static Chat chat = null;
    public static Economy econ = null;

    public static boolean setupChat() {
        RegisteredServiceProvider<Chat> chatProvider = Main.instance.getServer().getServicesManager()
                .getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        return (chat != null);
    }

    public static boolean setupEconomy() {
        if (Main.instance.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> economia = Main.instance.getServer().getServicesManager()
                .getRegistration(Economy.class);
        if (economia == null) {
            return false;
        }
        econ = (Economy) economia.getProvider();
        return econ != null;
    }

    public static String money(final Entity ent) {
        final double money = econ.getBalance(ent.getName());
        final int monao = (int) econ.getBalance(ent.getName());
        final DecimalFormat numberFormat = new DecimalFormat("###,###");
        String d = numberFormat.format(econ.getBalance((OfflinePlayer) ent));
        if (d.equalsIgnoreCase(".00")) {
            d = "0.0";
        }
        return d.replace(".", ",");
    }

}
