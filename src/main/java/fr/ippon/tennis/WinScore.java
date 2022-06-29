package fr.ippon.tennis;

public class WinScore implements ResultProvider {

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
    public TennisResult getResult() {
        return new TennisResult("Win for " + player1, "");
    }
}
