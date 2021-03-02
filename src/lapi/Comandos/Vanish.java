package lapi.Comandos;

import lapi.Sistemas.VanishListener;
import lapi.Utils.OnlinePlayersAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Vanish implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("vanish")) {
                if (!p.hasPermission("lapi.vanish")) {
                    p.sendMessage("§cVocê precisa do grupo Moderador ou superior para executar este comando.");
                    return true;
                }
            }
        }

        Player p = (Player) sender;
        if (getVanishMode(p)) {
            sender.sendMessage("§eInvisibilidade desativada.");
            setVanishMode(p, false);
        }else {
            sender.sendMessage("§eInvisibilidade ativada.");
            setVanishMode(p, true);
        }
        return true;
    }
    private void setVanishMode(Player player, boolean enabled) {
        if (enabled) {
            VanishListener.VANISH.add(player);
            for (Player target : OnlinePlayersAPI.getOnlinePlayers()) {
                if (!target.hasPermission("lapi.vanish.bypass")) {
                    target.hidePlayer(player);
                }
            }
            return;
        }else {
            VanishListener.VANISH.remove(player);
            for (Player target : OnlinePlayersAPI.getOnlinePlayers()) {
                target.showPlayer(player);
            }
        }
    }
    private boolean getVanishMode(Player player) {
        return VanishListener.VANISH.contains(player);
    }

}