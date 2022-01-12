package poikcue.form.license;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

public class command implements CommandExecutor {
    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!commandSender.hasPermission("license.full")) {
            commandSender.sendMessage(Objects.requireNonNull(FormLicense.getInstance().getConfig().getString("Message.command-with-license")));
            FormLicense.getInstance().getConfig().getStringList("Message.command-with-license").stream().map(message -> ChatColor.translateAlternateColorCodes('&', message)).forEach(commandSender::sendMessage);
        } else {
            commandSender.sendMessage(Objects.requireNonNull(FormLicense.getInstance().getConfig().getString("Message.command-with-no-license")));
            FormLicense.getInstance().getConfig().getStringList("Message.command-with-no-license").stream().map(message -> ChatColor.translateAlternateColorCodes('&', message)).forEach(commandSender::sendMessage);
        }
        return true;
    }
}