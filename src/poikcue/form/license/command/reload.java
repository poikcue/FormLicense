package poikcue.form.license.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import poikcue.form.license.FormLicense;

import javax.annotation.ParametersAreNonnullByDefault;

import static net.md_5.bungee.api.ChatColor.*;

public class reload implements CommandExecutor {
    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(commandSender.hasPermission("license.admin")){
            FormLicense.getInstance().reloadConfig();
            commandSender.sendMessage(translateAlternateColorCodes('&',FormLicense.getInstance().getConfig().getString("Message.reload-with-permission")));
        }
        else{
            commandSender.sendMessage(translateAlternateColorCodes('&',FormLicense.getInstance().getConfig().getString("Message.reload-with-no-permission")));
        }
        return true;
    }
}