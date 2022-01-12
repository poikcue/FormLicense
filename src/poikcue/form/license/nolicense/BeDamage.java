package poikcue.form.license.nolicense;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import poikcue.form.license.FormLicense;

import static net.md_5.bungee.api.ChatColor.*;

public class BeDamage implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if(e.getEntityType() == EntityType.PLAYER) {
            Player p = (Player) e.getEntity();
            if(FormLicense.getInstance().getConfig().getBoolean("PlayerNoLicenseAllow.hit")){
                if (p.hasPermission("license.full")){
                    e.setCancelled(false);
                }
                else {
                    e.setCancelled(true);
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(translateAlternateColorCodes('&', FormLicense.getInstance().getConfig().getString("Message.hit-action-bar-message"))));
                }
            }
        }
    }
}
