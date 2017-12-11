import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        //Shit that happens when you start.
    }

    @Override
    public void onDisable() {
        //Shit that happens when you stop.
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("matt")) {
            Player p = (Player)sender;
            ReasonableDrops test = new ReasonableDrops();
            ItemStack testItem = test.getFullItem();
            if (testItem != null){
                System.out.println(testItem);
            }
            p.getInventory().addItem(testItem);
        }
        return true;
    }
}
