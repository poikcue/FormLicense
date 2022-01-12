package poikcue.form.license.nolicense;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import poikcue.form.license.FormLicense;

import java.util.Objects;

import static net.md_5.bungee.api.ChatColor.translateAlternateColorCodes;

public class ChangeWorld implements Listener {

    @EventHandler
    public void onChange(PlayerPortalEvent e) {
        Player p = e.getPlayer();
        if(FormLicense.getInstance().getConfig().getBoolean("PlayerNoLicenseAllow.UsePortal")){
            if (p.hasPermission("license.full")){
                e.setCancelled(false);
            }
            else {
                e.setCancelled(true);
                TextComponent messageaction;
                messageaction = new TextComponent(FormLicense.getInstance().getConfig().getString("Message.action-bar-message"));
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, messageaction);
                String nonColoredText = FormLicense.getInstance().getConfig().getString("Message.action-bar-message");
                assert nonColoredText != null;
                String coloredText = translateAlternateColorCodes('&', nonColoredText);
                p.sendMessage(Objects.requireNonNull(FormLicense.getInstance().getConfig().getString(coloredText)));
            }
        }
    }
}
