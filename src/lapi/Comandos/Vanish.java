package lapi.Comandos;

import java.util.ArrayList;

import lapi.Sistemas.VanishListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vanish implements CommandExecutor {

    public static ArrayList<Player> vanish = new ArrayList<>();
    static {
        vanish = new ArrayList<Player>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("vanish")) {
                if (!p.hasPermission("lapi.vanish")) {
                    p.sendMessage("§cVocê precisa do grupo Moderador ou superior para executar este comando.");
                    return false;
                }
                if (args.length == 0) {
                    if(!vanish.contains(p)) {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            if (!players.hasPermission("lapi.vanish"))
                            players.hidePlayer(p);
                        }
                        vanish.add(p);
                        p.sendMessage("§eInvisibilidade ativada.");
                    }else {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            if (!players.hasPermission("lapi.vanish"))
                            players.showPlayer(p);
                        }
                        vanish.remove(p);
                        p.sendMessage("§eInvisibilidade desativada.");
                    }
                }
            }
        }
        return false;
    }

    private boolean getVanish(Player p) {
        return VanishListener.vanish.contains(p);
    }

}
