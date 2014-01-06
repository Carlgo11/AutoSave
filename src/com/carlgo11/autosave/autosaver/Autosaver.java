package com.carlgo11.autosave.autosaver;

import org.bukkit.Bukkit;
import com.carlgo11.autosave.Main;
import org.bukkit.event.Listener;

public class Autosaver implements Listener {

    static Main plugin;

    public Autosaver(Main plug)
    {
        super();
        this.plugin = plug;
        autosaver();
    }

    public void autosaver()
    {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

            @Override
            public void run()
            {
                int a = 0;
                for (int i = 1; a != 1; i++) {
                    String w = plugin.getConfig().getString("world" + i);
                    if (plugin.getConfig().contains("world" + i)) {
                        try {
                            Bukkit.getServer().getWorld(w).save();
                            System.out.println("world '" + w + "'saved.");
                        } catch (Exception e) {
                            System.out.println("Could not save world '" + w + "'. Output:" + e.toString());
                        }
                    } else {
                        a++;
                    }
                }
            }

        }, 200l, plugin.getConfig().getLong("delay"));
    }
}
