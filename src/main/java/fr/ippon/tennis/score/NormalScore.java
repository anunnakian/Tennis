package fr.ippon.tennis.score;

import fr.ippon.tennis.TennisGame4;

public class NormalScore implements Score {

    private static final String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};

    private final TennisGame4 game;

    public NormalScore(TennisGame4 game) {
        this.game = game;
    }

    @Override
    public String toString() {
        String serverScore = scores[game.getServer().getScore()];
        String receiverScore = scores[game.getReceiver().getScore()];
        if (serverScore.equals(receiverScore))
            return serverScore + "-All";
        return serverScore + "-" + receiverScore;
    }
}