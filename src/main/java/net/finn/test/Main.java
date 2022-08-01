package net.finn.test;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Main extends JavaPlugin implements Listener {

    private static Thread parkourLoop = new Thread(new ParkourLoopRunnable());

    public static List<String> playersInParkour = new ArrayList<>();
    public static HashMap<String, PlayerParkourStats> playerParkourStats = new HashMap<>();

    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("start").setExecutor(new StartCommand());
        parkourLoop.start();
    }

    @Override
    public void onDisable() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            String playerName = player.getName();
            if (playersInParkour.contains(playerName))
                playerParkourStats.get(playerName).getBossBar().removeAll();
        }
    }

}