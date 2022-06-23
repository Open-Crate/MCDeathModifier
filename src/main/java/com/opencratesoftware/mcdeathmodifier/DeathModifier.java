package com.opencratesoftware.mcdeathmodifier;
import org.bukkit.plugin.java.JavaPlugin;

import com.opencratesoftware.mcdeathmodifier.listeners.EntityDeathListener;

public final class DeathModifier  extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Config.updateConfig();
        getServer().getPluginManager().registerEvents(new EntityDeathListener((float) getConfig().getDouble("XPDropMultiplier"), getConfig().getBoolean("MultiplyTotalExp")), this );
    }
}
