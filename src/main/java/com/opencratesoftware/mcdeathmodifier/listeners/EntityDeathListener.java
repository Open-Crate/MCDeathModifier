package com.opencratesoftware.mcdeathmodifier.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import com.opencratesoftware.mcdeathmodifier.Config;

public final class EntityDeathListener implements Listener
{
    public EntityDeathListener(float inExpMultiplier, boolean inMultiplyTotalExp)
    {
        expMultiplier = inExpMultiplier;
        multiplyTotalExp = inMultiplyTotalExp;
    }

    private float expMultiplier = 1.0f;
    
    private boolean multiplyTotalExp = true;

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e)
    {
        if (e.getEntity().getType() == EntityType.PLAYER)
        {
            Player player = Player.class.cast(e.getEntity());
            float PlayerTotalExp = 0.0f;
            int playerLevel;

            if (multiplyTotalExp)
                playerLevel = player.getLevel();
            else
                playerLevel = Math.round((player.getLevel()) * expMultiplier);

            if(playerLevel <= 16)
            {
                PlayerTotalExp = (playerLevel * playerLevel) + (6 * playerLevel);
            }
            else if (playerLevel <= 31)
            {
                PlayerTotalExp = ((2.5f * (playerLevel * playerLevel)) - (40.5f * playerLevel)) + 360;
            }
            else
            {
                PlayerTotalExp = ((4.5f * (playerLevel * playerLevel)) - (162.5f * playerLevel)) + 2220;
            }

            if (multiplyTotalExp)
                e.setDroppedExp(Math.round(PlayerTotalExp * expMultiplier));
            else
                e.setDroppedExp(Math.round(PlayerTotalExp));

        }
        if (Config.getSendDeathCoords())
        {
            e.getEntity().sendMessage("You died at: " + String.valueOf(Math.round(e.getEntity().getLocation().getX())) + " " + String.valueOf(Math.round(e.getEntity().getLocation().getY())) + " " + String.valueOf(Math.round(e.getEntity().getLocation().getZ())));
        }
    }   
}
