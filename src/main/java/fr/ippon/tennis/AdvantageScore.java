package fr.ippon.tennis;

public class AdvantageScore implements ResultProvider {

    private Player player1;
    private Player player2;

    public AdvantageScore(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public boolean checkScore() {
        return player1.getScore() >= 4 && (player1.getScore() - player2.getScore()) == 1;
    }
    @Override
    public TennisResult getResult() {
        return new TennisResult("Advantage " + player1, "");
    }
}
