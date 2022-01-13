package poikcue.form.license.nolicense;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import poikcue.form.license.FormLicense;

public class pickup implements Listener {
    @EventHandler
    public void onPick(EntityPickupItemEvent e) {
        Player p = (Player) e.getEntity();
        if(FormLicense.getInstance().getConfig().getBoolean("PlayerNoLicenseAllow.pickup")){
            e.setCancelled(!p.hasPermission("license.full"));
        }
    }
}