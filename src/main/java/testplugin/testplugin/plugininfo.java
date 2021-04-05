package testplugin.testplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class plugininfo implements CommandExecutor{
    private final TestPlugin plugin;

    public plugininfo(TestPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("plugin-info")) {
            sender.sendMessage("§b§lTestPlugin v1.2.9");
            sender.sendMessage("§4by §r§6Ignacy Swiatecki");

            return true;
        }
        return false;
    }
}
