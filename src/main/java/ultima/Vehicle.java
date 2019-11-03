package ultima;

import java.util.Optional;

public class Vehicle {
  private Optional<MusicSystem> musicSystem;

  /**
   * @return Optional<MusicSystem>
   */
  public Optional<MusicSystem> getMusicSystem() {
    return musicSystem;
  }

  // private static final Logger LOGGER =
  // org.apache.Logger.LogManager.getLogger();

  /**
   * main class
   *
   * @param args
   *
   */
  public static void main(String[] args) {
    MusicSystem lcMusicSystem = new MusicSystem();
    Optional<MusicSystem> musicSystem = Optional.of(lcMusicSystem);
    System.out.println("Non-Empty Optional: musicsystem value : " + musicSystem.get());
    System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(lcMusicSystem));
    // LOGGER.debug("Debug Message Logged !!");
    // LOGGER.info("Info Message Logged !!");
    // LOGGER.debug("Another Debug Message !!");
  }
}
