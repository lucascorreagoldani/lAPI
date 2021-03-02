package lapi.Sistemas;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashSet;

public class VanishListener implements Listener {

    public static HashSet<Player> VANISH = new HashSet<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPermission("lapi.vanish")) {
            for (Player vanish : VANISH) {
                p.hidePlayer(vanish);
            }
        }
    }
}
