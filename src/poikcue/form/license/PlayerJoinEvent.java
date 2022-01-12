package poikcue.form.license;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Objects;

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
            p.sendMessage(Objects.requireNonNull(FormLicense.getInstance().getConfig().getString("Message.no-license-player-join-message")));
            String nonColoredText = FormLicense.getInstance().getConfig().getString("Message.no-license-player-join-message");
            assert nonColoredText != null;
            String coloredText = translateAlternateColorCodes('&', nonColoredText);
            p.sendMessage(Objects.requireNonNull(FormLicense.getInstance().getConfig().getString(coloredText)));
        }
        return false;
    }
}
