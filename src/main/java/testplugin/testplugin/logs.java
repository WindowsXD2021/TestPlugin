package testplugin.testplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class logs implements CommandExecutor {
    private final TestPlugin plugin;

    public logs(TestPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        try {
            File FileObj = new File("../logs/latest.log");
            Scanner FileReader = new Scanner(FileObj);
            while (FileReader.hasNextLine()) {
                String data = FileReader.nextLine();
                sender.sendMessage(data);
            }
            FileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            sender.sendMessage("§4Can't find logs!");
        }
        return false;
    }
}
