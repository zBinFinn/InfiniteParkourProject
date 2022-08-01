package net.finn.test;

import net.finn.test.utilz.LocationUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.Random;

public class ParkourLoopRunnable implements Runnable{
    private static final Random random = new Random();

    @Override
    public void run() {

        while(true)
            tick();
    }

    private void tick() {

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (Main.playersInParkour.contains(player.getName()))
                playerCheck(player);

        }

    }

    private void playerCheck(Player player) {
        String playerName = player.getName();
        PlayerParkourStats playerParkourStats = Main.playerParkourStats.get(playerName);

        if (LocationUtils.centerLocation(player.getLocation().add(0, -1, 0)).toVector().toString().equals(playerParkourStats.getBlockLocation().toVector().toString())) {

            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);

            Location newLocation = playerParkourStats.getBlockLocation();
            newLocation.add(getShiftValue(), 1, getShiftValue());
            LocationUtils.centerLocation(newLocation);

            playerParkourStats.setBlockLocation(newLocation);
            playerParkourStats.incrementScore(1);
            playerParkourStats.getBossBar().setTitle(playerParkourStats.getScore() + "");

            player.sendBlockChange(newLocation, Material.GREEN_CONCRETE.createBlockData());
        }
    }

    private int getShiftValue() {
        if (random.nextBoolean())
            return random.nextInt(3) + 1;
        else
            return (random.nextInt(3) + 1) * -1;
    }
}
