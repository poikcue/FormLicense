package poikcue.form.license;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Objects;

public class PlayerJoinEvent implements Listener {
    @EventHandler
    public boolean onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("license.full")) { //permission.
            p.setGameMode(GameMode.SURVIVAL);
        }
        else {
            p.setGameMode(GameMode.ADVENTURE);
            p.sendMessage(Objects.requireNonNull(FormLicense.getInstance().getConfig().getString("Message.no-license-player-join-message")));
            FormLicense.getInstance().getConfig().getStringList("Message.no-license-player-join-message").stream().map(message -> ChatColor.translateAlternateColorCodes('&', message)).forEach(p::sendMessage);
        }
        return false;
    }
}
