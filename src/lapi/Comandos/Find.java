package lapi.Comandos;

import lapi.Utils.PermissionEX;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Find implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("find")) {
            if (!p.hasPermission("lapi.find")) {
                p.sendMessage("§cVocê precisa do grupo Moderador ou superior para executar este comando.");
                return true;
            }
            if (args.length > 1) {
                p.sendMessage("§cUtilize /find (jogador).");
                return true;
            }
            p.sendMessage("§cPerfil:");
            p.sendMessage("  §fNome: " + p.getName());
            p.sendMessage("  §fÚltimo IP: " + p.getAddress().getAddress().getHostAddress());
            p.sendMessage("§cGrupos:");
            p.sendMessage("  §fPrefixos: " + PermissionEX.getPrefix(p));
            p.sendMessage("§cProxy:");
            p.sendMessage("  §fMundo: " + p.getWorld().getName());
            p.sendMessage("\n");
        }
        return true;
    }
}
