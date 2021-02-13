package lapi.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Vanish implements CommandExecutor {

    public static ArrayList<Player> vanish = new ArrayList<>();

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
                        return true;
                    }else {
                        for (Player players : Bukkit.getOnlinePlayers()) {
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
}
