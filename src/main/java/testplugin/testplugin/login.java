package testplugin.testplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class login implements CommandExecutor {
    private final TestPlugin plugin;

    public login(TestPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("login")) {
            try {
                if (args[0].toString() == "admin") {
                    sender.sendMessage("Logged in!");
                } else {
                    sender.sendMessage("Wrong password!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                sender.sendMessage("§4You must provide a password");
            }
            return true;
        }
        return false;
    }
}
