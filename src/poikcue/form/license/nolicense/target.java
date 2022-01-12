package poikcue.form.license.nolicense;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import poikcue.form.license.FormLicense;

public class target implements Listener {

    @EventHandler
    public void onETE(EntityTargetEvent e) {
        if(FormLicense.getInstance().getConfig().getBoolean("PlayerNoLicenseAllow.target")){
            if(e.getTarget() instanceof Player){
                Player p = (Player) e.getTarget();
                if (p.hasPermission("license.full")){
                    e.setCancelled(false);
                }
                else {
                    e.setCancelled(true);
                }
            }
        }
    }
}
