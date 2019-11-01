package ultima;

import java.util.Optional;

public class Vehicle {
    private Optional<MusicSystem> musicSystem;

    public Optional<MusicSystem> getMusicSystem() {
        return musicSystem;
    }

    private static final Logger LOGGER = org.apache.Logger.LogManager.getLogger();

    public static void main(String[] args) {
        MusicSystem lc_ms = new MusicSystem();
        Optional<MusicSystem> music_system = Optional.of(lc_ms);
        System.out.println("Non-Empty Optional: musicsystem value : " + music_system.get());
        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(lc_ms));
        LOGGER.debug("Debug Message Logged !!");
        LOGGER.info("Info Message Logged !!");
        LOGGER.debug("Another Debug Message !!");
    }
}
