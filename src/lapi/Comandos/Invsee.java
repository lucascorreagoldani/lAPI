package lapi.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Invsee implements Listener, CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("invsee")) {
                if (!p.hasPermission("lapi.invsee")) {
                    p.sendMessage("§cVocê precisa do grupo Moderador ou superior para executar este comando.");
                    return false;
                }
                if (args.length == 0) {
                    p.sendMessage("§cUtilize /invsee (jogador).");
                    return false;
                }
                if (args.length == 1) {
                    Player t = Bukkit.getServer().getPlayer(args[0]);
                    if (t == null) {
                        p.sendMessage("§cEste usuário está offline.");
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
