package lapi;

import lapi.Comandos.Invsee;
import lapi.Comandos.Vanish;
import lapi.Sistemas.VanishListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new VanishListener(), this);
        Bukkit.getPluginManager().registerEvents(new Invsee(), this);
        getCommand("vanish").setExecutor(new Vanish());
        getCommand("invsee").setExecutor(new Invsee());
    }

    @Override
    public void onDisable() {
    }
}
