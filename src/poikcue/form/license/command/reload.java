package poikcue.form.license.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import poikcue.form.license.FormLicense;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

import static net.md_5.bungee.api.ChatColor.translateAlternateColorCodes;

public class reload implements CommandExecutor {
    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(commandSender.hasPermission("license.admin")){
            FormLicense.getInstance().reloadConfig();
            String nonColoredText = FormLicense.getInstance().getConfig().getString("Message.reload-with-permission");
            assert nonColoredText != null;
            String coloredText = translateAlternateColorCodes('&', nonColoredText);
            commandSender.sendMessage(Objects.requireNonNull(coloredText));
        }
        else{
            String nonColoredText = FormLicense.getInstance().getConfig().getString("Message.reload-with-no-permission");
            assert nonColoredText != null;
            String coloredText = translateAlternateColorCodes('&', nonColoredText);
            commandSender.sendMessage(Objects.requireNonNull(coloredText));
        }
        return true;
    }
}