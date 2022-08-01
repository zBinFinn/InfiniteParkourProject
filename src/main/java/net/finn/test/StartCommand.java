package net.finn.test;

import net.finn.test.utilz.LocationUtils;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String playerName = sender.getName();
        Main.playerParkourStats.put(playerName, new PlayerParkourStats());
        PlayerParkourStats playerParkourStats = Main.playerParkourStats.get(playerName);

        if (!(sender instanceof Player))
            return false;

        if (Main.playersInParkour.contains(playerName))
            return false;

        Main.playersInParkour.add(playerName);
        playerParkourStats.setBlockLocation(LocationUtils.centerLocation(((Player)sender).getLocation().add(0, -1, 0)));
        playerParkourStats.setScore(0);
        playerParkourStats.setBossBar(Bukkit.createBossBar("0", BarColor.PINK, BarStyle.SOLID));
        playerParkourStats.getBossBar().addPlayer((Player) sender);

        return false;
    }

}
