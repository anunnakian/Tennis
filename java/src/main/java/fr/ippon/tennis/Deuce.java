package fr.ippon.tennis;

class Deuce implements ResultProvider {
    private final TennisGame4 game;

    public Deuce(TennisGame4 game) {
        this.game = game;
    }

    @Override
    public boolean checkScore() {
        return game.getServer().getScore() >= 3 && game.getReceiver().getScore() >= 3 && (game.getServer().getScore() == game.getReceiver().getScore());
    }

    @Override
    public TennisResult getResult() {
        return new TennisResult("Deuce", ""); // issue empty string
    }
}