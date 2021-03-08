package lapi.Comandos;

import lapi.Utils.PermissionEX;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Find implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("find")) {
                if (!p.hasPermission("lapi.find")) {
                    p.sendMessage("§cVocê precisa do grupo Moderador ou superior para executar este comando.");
                    return true;
                }
                if (args.length > 1) {
                    p.sendMessage("§cUtilize /find (jogador).");
                    return false;
                }
                if (args.length > 0) {
                    Player t = Bukkit.getPlayerExact(args[0]);
                    if (t == null) {
                        p.sendMessage("§cEste jogador está offline.");
                        return false;
                    }
                    p.sendMessage("§cPerfil: ");
                    p.sendMessage("  §fID: 1");
                    p.sendMessage("  §fNick: " + t.getName());
                    p.sendMessage("  §fUUID: " + t.getUniqueId());
                    p.sendMessage("  §fÚltimo IP: " + t.getAddress().getAddress().getHostAddress());
                    p.sendMessage("§cGrupos: ");
                    p.sendMessage("  §fPrefixos: " + PermissionEX.getPrefix(t));
                    p.sendMessage("§cStatus: ");
                    p.sendMessage("  §fServidor: " + t.getWorld().getName());
                    p.sendMessage("\n");
                    return true;
                }
                if (args.length == 0) {
                    Player player = (Player) sender;
                    p.sendMessage("§cPerfil: ");
                    p.sendMessage("  §fID: 1");
                    p.sendMessage("  §fNick: " + player.getName());
                    p.sendMessage("  §fUUID: " + player.getUniqueId());
                    p.sendMessage("  §fÚltimo IP: " + player.getAddress().getAddress().getHostAddress());
                    p.sendMessage("§cGrupos: ");
                    p.sendMessage("  §fPrefixos: " + PermissionEX.getPrefix(player));
                    p.sendMessage("§cStatus: ");
                    p.sendMessage("  §fServidor: " + player.getWorld().getName());
                    p.sendMessage("\n");
                    return true;
                }
            }
        }
        return true;
    }
}