package net.finn.test.utilz;

import org.bukkit.Location;

public class LocationUtils {

    public static Location centerLocation(Location location) {
        return location.getBlock().getLocation();
    }


}
