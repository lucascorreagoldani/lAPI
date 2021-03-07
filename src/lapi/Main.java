package lapi;

import lapi.Comandos.Find;
import lapi.Comandos.Invsee;
import lapi.Comandos.Vanish;
import lapi.Sistemas.VanishListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new VanishListener(), this);
        Bukkit.getPluginManager().registerEvents(new Invsee(), this);
        getCommand("find").setExecutor(new Find());
        getCommand("vanish").setExecutor(new Vanish());
        getCommand("invsee").setExecutor(new Invsee());
    }

    @Override
    public void onDisable() {

    }

}
