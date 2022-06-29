package fr.ippon.tennis;

import fr.ippon.tennis.score.*;

import java.util.ArrayList;
import java.util.List;

public class TennisGame4 implements TennisGame {

    private final Player server;
    private final Player receiver;

    public TennisGame4(String serverPlayer, String receiverPlayer) {
        this.server = Player.of(serverPlayer);
        this.receiver = Player.of(receiverPlayer);
    }

    public Player getServer() {
        return server;
    }

    public Player getReceiver() {
        return receiver;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals(server.getName())) {
            server.won();
        } else {
            receiver.won();
        }
    }

    @Override
    public String getScore() {
        List<Score> scores = new ArrayList<>();
        scores.add(new Deuce(this));
        scores.add(new WinScore(server, receiver));
        scores.add(new WinScore(receiver, server));
        scores.add(new AdvantageScore(server, receiver));
        scores.add(new AdvantageScore(receiver, server));

        for (Score score : scores) {
            if (score.checkScore()) {
                return score.getScore();
            }
        }

        return new NormalScore(this).getScore();
    }
}