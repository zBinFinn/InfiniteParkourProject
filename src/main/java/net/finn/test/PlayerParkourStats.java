package net.finn.test;

import org.bukkit.Location;
import org.bukkit.boss.BossBar;

public class PlayerParkourStats {
    private String playerName;
    private Location blockLocation;
    private BossBar bossBar;
    private int score;

    public PlayerParkourStats(String playerName, Location blockLocation, BossBar bossBar, int score) {
        this.playerName = playerName;
        this.blockLocation = blockLocation;
        this.bossBar = bossBar;
        this.score = score;

    }

    public PlayerParkourStats() {}

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Location getBlockLocation() {
        return blockLocation;
    }

    public void setBlockLocation(Location blockLocation) {
        this.blockLocation = blockLocation;
    }

    public BossBar getBossBar() {
        return bossBar;
    }

    public void setBossBar(BossBar bossBar) {
        this.bossBar = bossBar;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void incrementScore(int i) {
        score += i;

    }
}
