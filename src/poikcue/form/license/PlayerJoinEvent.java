package poikcue.form.license;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static net.md_5.bungee.api.ChatColor.translateAlternateColorCodes;


public class PlayerJoinEvent implements Listener {
    @EventHandler
    public boolean onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("license.full")) { //permission.
            p.setGameMode(GameMode.SURVIVAL);
        }
        else {
            p.setGameMode(GameMode.ADVENTURE);
            p.sendMessage(translateAlternateColorCodes('&',FormLicense.getInstance().getConfig().getString("Message.no-license-player-join-message")));
        }
        return false;
    }
}
