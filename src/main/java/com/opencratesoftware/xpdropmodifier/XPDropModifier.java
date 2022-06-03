package com.opencratesoftware.xpdropmodifier;
import com.opencratesoftware.listeners.EntityDeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class XPDropModifier  extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new EntityDeathListener((float) getConfig().getDouble("XPDropMultiplier"), getConfig().getBoolean("MultiplyTotalExp")), this );
    }
}
