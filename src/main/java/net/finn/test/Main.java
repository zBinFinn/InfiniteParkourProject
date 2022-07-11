package net.finn.test;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    // DIAMOND HOE = SNOWBALL LAUNCHER
    // IRON HOE = EGG LAUNCHER
    // GOLD HOE = FIREBALL LAUNCHER
    // WOODEN HOE = ARROW LAUNCHER

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        if (e.hasItem()) {
            if (e.getItem().getType().equals(Material.DIAMOND_HOE)) {
                player.launchProjectile(Snowball.class);
                player.playSound(player.getLocation(), Sound.ENTITY_SNOWBALL_THROW, 1, 1);
            } else if (e.getItem().getType().equals(Material.IRON_HOE)) {
                player.launchProjectile(Egg.class);
                player.playSound(player.getLocation(), Sound.ENTITY_EGG_THROW, 1, 1);
            }
        }


    }

}