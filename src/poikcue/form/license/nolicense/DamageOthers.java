package poikcue.form.license.nolicense;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import poikcue.form.license.FormLicense;

import static net.md_5.bungee.api.ChatColor.*;

public class DamageOthers implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        Player p = (Player) e.getEntity();
        if(FormLicense.getInstance().getConfig().getBoolean("PlayerNoLicenseAllow.hit-others")){
            if (p.hasPermission("license.full")){
                e.setCancelled(false);
            }
            else {
                e.setCancelled(true);
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(translateAlternateColorCodes('&', FormLicense.getInstance().getConfig().getString("Message.action-bar-message"))));
            }
        }
    }
}
