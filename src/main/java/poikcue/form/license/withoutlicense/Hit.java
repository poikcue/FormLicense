package poikcue.form.license.withoutlicense;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import poikcue.form.license.FormLicense;

import static net.md_5.bungee.api.ChatColor.*;

public class Hit implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if(e.getDamager() instanceof Player) {
            Player p = (Player) e.getDamager();
            if(FormLicense.getInstance().getConfig().getBoolean("PlayerNoLicenseAllow.hit.hit")){
                if (p.hasPermission("license.full") && p.hasPermission("formlicense.user.weight.a")){
                    e.setCancelled(false);
                }
                else {
                    e.setCancelled(true);
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(translateAlternateColorCodes('&', FormLicense.getInstance().getConfig().getString("Message.hit-message.hit-action-bar-message"))));
                }
            }
        }
    }
}
