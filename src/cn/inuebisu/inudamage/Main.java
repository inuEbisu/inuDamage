package cn.inuebisu.inudamage;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        if (Bukkit.getPluginCommand("damage") != null) {
            Bukkit.getPluginCommand("damage").setExecutor(new CommandManager());
        }

        getLogger().info("inuDamage xD");
    }

}
