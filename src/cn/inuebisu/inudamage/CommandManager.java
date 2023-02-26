package cn.inuebisu.inudamage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class CommandManager implements CommandExecutor {
    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("inudamage.damage")) {
            sender.sendMessage("You have no permission!");
            return true;
        }

        Entity source = null;
        if(args.length == 3) {
            String selector = args[2];
            List<Entity> sources = Bukkit.selectEntities(sender, selector);
            if (sources.size() >= 1) {
                source = sources.get(0);
            } else {
                sender.sendMessage("Invaild source!");
                return true;
            }
        }

        if(args.length >= 2) {
            String selector = args[0];
            List<Entity> targets = Bukkit.selectEntities(sender, selector);
            float amount = Float.parseFloat(args[1]);
            for(Entity entity: targets) {
                if(entity instanceof Damageable) {
                    ((Damageable) entity).damage(amount, source);
                }
            }
            return true;
        }

        sender.sendMessage("/damage <playerName> <amount> [damageSource]");
        return true;
    }
}
