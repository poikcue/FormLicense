package poikcue.form.license.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import poikcue.form.license.FormLicense;

import javax.annotation.ParametersAreNonnullByDefault;

public class fastback implements CommandExecutor {
    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(FormLicense.getInstance().getConfig().getBoolean("FormLicense.Player.AllowUseFastbackCommand.enable")){
            if(commandSender.hasPermission("license.full") && commandSender.hasPermission("formlicense.user.weight.a")) {
                commandSender.sendMessage(FormLicense.getInstance().getConfig().getString("Message.fastback.message"));
            }
            else{
                commandSender.sendMessage(FormLicense.getInstance().getConfig().getString("Message.fastback.message-with-have-license"));
            }
        }
        else{
            commandSender.sendMessage(FormLicense.getInstance().getConfig().getString("Message.fastback.disable-message"));
        }
        return true;
    }
}
// NOT REGISTER TO PLUGIN!
