package poikcue.form.license.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import poikcue.form.license.FormLicense;

public class JoinFoodLevel implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if(FormLicense.getInstance().getConfig().getBoolean("FormLicense.Player.CustomFoodLevel.enable")){
            Player p = e.getPlayer();
            if(p.hasPermission("license.full") && p.hasPermission("formlicense.user.weight.a")){
                String num = FormLicense.getInstance().getConfig().getString("FormLicense.Player.CustomFoodLevel.number");
                int intnum = Integer.parseInt(num); //将string改成int.
                p.setFoodLevel(intnum);
            }
        }
    }
}
