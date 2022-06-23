import fr.ippon.tennis.Player;

public interface TennisGame {
    default void wonPoint(String playerName) {
        // nothing
    }

    String getScore();

    Player getServer();
    Player getReceiver();
}