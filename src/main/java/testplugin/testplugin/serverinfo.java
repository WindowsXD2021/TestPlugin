package testplugin.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

public class serverinfo implements CommandExecutor {
    private final TestPlugin plugin;

    public serverinfo(TestPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("server-info")) {
            String servername = Bukkit.getName();
            String mtod = Bukkit.getMotd();
            String ip = Bukkit.getIp();
            Collection<? extends Player> players = Bukkit.getOnlinePlayers();
            Object[] playersArr = players.toArray();
            int playersCount = playersArr.length;
            String playersCountString = String.valueOf(playersCount);
            sender.sendMessage("Server name: "+servername);
            sender.sendMessage("Server mtod: "+mtod);
            sender.sendMessage("Server ip: "+ip);
            sender.sendMessage("Online players: "+playersCountString);
            return true;
        }
        return false;
    }
}
