package testplugin.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpa implements CommandExecutor {
    private final TestPlugin plugin;

    public tpa(TestPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED+"Please provide player name");
            }else if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                p.sendMessage(ChatColor.YELLOW+"You will be teleported in next 5 seconds.");
                try {
                    wait(5000);
                } catch (InterruptedException e) {
                    p.sendMessage(ChatColor.RED+"An error occurred while executing command. Please contact server administrator.");
                }
                p.teleport(target.getLocation());
            }else {
                p.sendMessage(ChatColor.RED+"Please provide only one player name");
            }
        }
        return false;
    }
}
