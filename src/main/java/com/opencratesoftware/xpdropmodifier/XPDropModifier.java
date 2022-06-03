package com.opencratesoftware.xpdropmodifier;
import com.opencratesoftware.listeners.EntityDeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class XPDropModifier  extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new EntityDeathListener(), this );
    }
}
