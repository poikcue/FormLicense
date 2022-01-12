package poikcue.form.license.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import poikcue.form.license.FormLicense;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

import static net.md_5.bungee.api.ChatColor.translateAlternateColorCodes;

public class command implements CommandExecutor {
    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!commandSender.hasPermission("license.full")) {
            String nonColoredText = FormLicense.getInstance().getConfig().getString("Message.command-with-license");
            assert nonColoredText != null;
            String coloredText = translateAlternateColorCodes('&', nonColoredText);
            commandSender.sendMessage(Objects.requireNonNull(FormLicense.getInstance().getConfig().getString(coloredText)));
        } else {
            String nonColoredText = FormLicense.getInstance().getConfig().getString("Message.command-with-no-license");
            assert nonColoredText != null;
            String coloredText = translateAlternateColorCodes('&', nonColoredText);
            commandSender.sendMessage(Objects.requireNonNull(FormLicense.getInstance().getConfig().getString(coloredText)));
        }
        return true;
    }
}