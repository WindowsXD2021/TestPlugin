package testplugin.testplugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class givesupersword implements CommandExecutor {
    private final TestPlugin plugin;

    public givesupersword(TestPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("give-super-sword")) {
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD,1);
            sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
            sword.addEnchantment(Enchantment.KNOCKBACK, 2);
            sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
            p.getInventory().addItem(sword);
            return true;
        }
        return false;
    }
}
