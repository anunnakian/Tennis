package fr.ippon.tennis.score;

import fr.ippon.tennis.Player;

public class WinScore implements Score {

    private Player player1;
    private Player player2;

    public WinScore(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public boolean checkScore() {
        return player1.getScore() >= 4 && (player1.getScore() - player2.getScore()) >= 2;
    }

    @Override
    public String getScore() {
        return "Win for " + player1;
    }
}
