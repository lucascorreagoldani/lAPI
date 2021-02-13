package lapi;

import lapi.Comandos.Vanish;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getCommand("vanish").setExecutor(new Vanish());
    }

    @Override
    public void onDisable() {
    }
}
