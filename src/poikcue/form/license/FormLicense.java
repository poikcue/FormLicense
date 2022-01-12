package poikcue.form.license;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import poikcue.form.license.command.command;
import poikcue.form.license.command.reload;
import poikcue.form.license.nolicense.ChangeWorld;
import poikcue.form.license.nolicense.pickUp;

import java.util.Objects;

public class FormLicense extends JavaPlugin {
    private static FormLicense instance;

    public void onEnable() {
        instance = this;
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new pickUp(), this);
        pm.registerEvents(new PlayerJoinEvent(), this);
        pm.registerEvents(new ChangeWorld(), this);
        saveDefaultConfig();
        if (Bukkit.getPluginCommand("license") != null) {
            Objects.requireNonNull(Bukkit.getPluginCommand("license")).setExecutor(new command());
        }
        if (Bukkit.getPluginCommand("licensereload") != null) {
            Objects.requireNonNull(Bukkit.getPluginCommand("licensereload")).setExecutor(new reload());
        }
        if(!getConfig().getBoolean("FormLicense.HideDevelopmentVersionWarning")){
            getLogger().warning("-- FormLicense Development Version Warning --");
            getLogger().warning("This version is alpha,beta or development version.* NOT A OFFICIAL VERSION! *");
            getLogger().warning("This means that the version is untested or possibly still have bug.");
            getLogger().warning("If you modify the plugin and test it yourself, there should be no problem.");
            getLogger().warning("If you have any problems with the development version, please submit an issue in GitHub and stop using it immediately. The developer will not bear * any * responsibility for this.");
            getLogger().warning("If you want to hide this information, set config.yml 'FormLicense.HideDevelopmentVersionWarning' to false");
            getLogger().warning("---------------------------------------------");
        }
        else{
            getLogger().info("You are already in config.yml disables the development version prompt.");
            getLogger().info("This message is a reminder that you are using the development version.");
        }
    }

    public static FormLicense getInstance(){
        return instance;
    }
}
