package cn.inuebisu.inudamage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import javax.annotation.ParametersAreNonnullByDefault;

public class CommandManager implements CommandExecutor {
    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 2) {
            String playerName = args[0];
            Player player = Bukkit.getPlayer(playerName);
            float amount = Float.parseFloat(args[1]);
            player.damage(amount);
            return true;
        }
        return false;
    }
}
