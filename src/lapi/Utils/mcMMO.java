package lapi.Utils;

import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.nossr50.database.DatabaseManagerFactory;
import com.gmail.nossr50.datatypes.database.PlayerStat;
import com.gmail.nossr50.datatypes.skills.SkillType;

public class mcMMO extends BukkitRunnable

{
    public static HashMap<String, Integer> PLAYER_POSITION;

    static {
        mcMMO.PLAYER_POSITION = new HashMap<String, Integer>();
    }

    public static String getPlayerPosition(final Player p) {
        return (mcMMO.PLAYER_POSITION.get(p.getName()) == null) ? "Inválido" : mcMMO.PLAYER_POSITION.get(p.getName()).toString();
    }

    public void run() {
        final List<PlayerStat> list = (List<PlayerStat>)DatabaseManagerFactory.getDatabaseManager().readLeaderboard((SkillType)null, 1, 5);
        for (int i = 0; i < list.size(); ++i) {
            mcMMO.PLAYER_POSITION.put(list.get(i).name, i + 1);
        }
    }
}
