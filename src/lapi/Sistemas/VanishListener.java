package lapi.Sistemas;

import java.util.HashSet;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class VanishListener implements Listener {

    public static HashSet<Player> vanish = new HashSet<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPermission("lapi.vanish")) {
            for (Player vanish : vanish) {
                p.hidePlayer(p);
            }
        }
    }
}
