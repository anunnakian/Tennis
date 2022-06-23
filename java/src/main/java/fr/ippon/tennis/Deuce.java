package fr.ippon.tennis;

class Deuce implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public Deuce(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (isDeuce())
            return new TennisResult("Deuce", ""); // issue empty string
        return this.nextResult.getResult();
    }

    private boolean isDeuce() {
        return game.getServer().getScore() >= 3 && game.getReceiver().getScore() >= 3 && (game.getServer().getScore() == game.getReceiver().getScore());
    }
}