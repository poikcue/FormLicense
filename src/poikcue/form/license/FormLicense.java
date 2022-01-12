package poikcue.form.license;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
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
        FileConfiguration config = getConfig();
        if (Bukkit.getPluginCommand("license") != null) {
            Objects.requireNonNull(Bukkit.getPluginCommand("license")).setExecutor(new command());
        }
        getLogger().info("Welcome to use FormLicense! Loaded version:" + config.getString("FormLicense.version"));
        getLogger().info("FormLicense.onEnableMessage");
    }

    public static FormLicense getInstance(){
        return instance;
    }
}
