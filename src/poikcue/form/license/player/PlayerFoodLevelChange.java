package poikcue.form.license.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import poikcue.form.license.FormLicense;

public class PlayerFoodLevelChange implements Listener {

    @EventHandler
    public void onChanged(FoodLevelChangeEvent e) {
        if(FormLicense.getInstance().getConfig().getBoolean("FormLicense.Player.CustomFoodLevel.lock")){
            Player p = (Player) e.getEntity();
            if(e.getEntity() instanceof Player){
                e.setCancelled(!p.hasPermission("license.full") && !p.hasPermission("formlicense.user.weight.a"));
            }
        }
    }
}
// In fact, i want to add more license.
// but i don't want to do so.