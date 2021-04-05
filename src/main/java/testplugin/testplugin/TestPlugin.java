package testplugin.testplugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Turning on...");
        getLogger().info("_______________________");
        getLogger().info("|_____________________|");
        getLogger().info("|                     |");
        getLogger().info("|     §b §lTestPlugin     §r|");
        getLogger().info("| §4by §r§6Ignacy Swiatecki §r|");
        getLogger().info("|_____________________|");
        getLogger().info("|_____________________|");
        getLogger().info("");
        this.getCommand("login").setExecutor(new login(this));
        this.getCommand("plugin-info").setExecutor(new plugininfo(this));
        this.getCommand("server-info").setExecutor(new serverinfo(this));
        this.getCommand("http-server-start").setExecutor(new httpserver(this));
        //this.getCommand("http-server-stop").setExecutor(new httpserver(this));
        this.getCommand("logs").setExecutor(new logs(this));

    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye!");
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent evt) {
        Player player = evt.getPlayer();
        PlayerInventory inventory = player.getInventory();
        ItemStack itemstack = new ItemStack(Material.DIAMOND, 64);
        if (inventory.contains(itemstack)) {
            inventory.addItem(itemstack);
        }
    }
}
