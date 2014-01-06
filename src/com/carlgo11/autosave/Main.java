package com.carlgo11.autosave;

import com.carlgo11.autosave.autosaver.Autosaver;
import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable()
    {
        File config = new File(getDataFolder(), "config.yml");
        if (!config.exists()) {
            saveDefaultConfig();
            getConfig().options().copyHeader(true);

            System.out.println("[autosave] No config.yml detected, config.yml created");
        }
        getServer().getPluginManager().registerEvents(new Autosaver(this), this);
    }

    public void onDisable()
    {

    }

}
