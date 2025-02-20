package eu.netleak.spawnguard;

import eu.netleak.spawnguard.platform.Services;

public class CommonClass {
    public static void init() {
        if (Services.PLATFORM.isModLoaded("spawnguard")) {
            Constants.LOG.info("Hello to spawnguard");
        }
    }
}