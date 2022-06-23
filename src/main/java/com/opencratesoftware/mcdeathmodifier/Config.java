package com.opencratesoftware.mcdeathmodifier;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class Config 
{
    private static boolean sendDeathCoords = false;

    public static FileConfiguration getConfig()
    {
        return Bukkit.getPluginManager().getPlugin("DeathModifier").getConfig();
    }

    public static void updateConfig()
    {
        sendDeathCoords = getConfig().getBoolean("send-death-coords");
    }

    public static boolean getSendDeathCoords()
    {
        return sendDeathCoords;
    }
}
