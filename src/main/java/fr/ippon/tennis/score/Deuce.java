package fr.ippon.tennis.score;

import fr.ippon.tennis.TennisGame4;

public class Deuce implements ConditionalScore {
    private final TennisGame4 game;

    public Deuce(TennisGame4 game) {
        this.game = game;
    }

    @Override
    public boolean checkScore() {
        return game.getServer().getScore() >= 3 && game.getReceiver().getScore() >= 3 && (game.getServer().getScore() == game.getReceiver().getScore());
    }

    @Override
    public String getScore() {
        return "Deuce";
    }
}