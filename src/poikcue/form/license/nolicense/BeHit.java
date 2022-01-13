package poikcue.form.license.nolicense;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import poikcue.form.license.FormLicense;

import static net.md_5.bungee.api.ChatColor.translateAlternateColorCodes;

public class BeHit implements Listener {

    @EventHandler
    public void onDamaged(EntityDamageByEntityEvent e) {
        if (FormLicense.getInstance().getConfig().getBoolean("PlayerNoLicenseAllow.hit.be-hit")) {
            if (e.getEntity() instanceof Player) {
                Player p = (Player) e.getEntity();
                if (p.hasPermission("license.full")) {
                    e.setCancelled(false);
                } else {
                    e.setCancelled(true);
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(translateAlternateColorCodes('&', FormLicense.getInstance().getConfig().getString("Message.hit-message.be-hit-action-bar-message"))));
                }
            }
        }
    }
}
// In fact, this class copied from Hit.java.
// And...I changed getDamager() to getEntity()...It works.
