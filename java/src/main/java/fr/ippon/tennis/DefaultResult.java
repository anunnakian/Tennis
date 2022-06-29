package fr.ippon.tennis;

class DefaultResult implements ResultProvider {

    private static final String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};

    private final TennisGame4 game;

    public DefaultResult(TennisGame4 game) {
        this.game = game;
    }

    @Override
    public boolean checkScore() {
        return true;
    }

    @Override
    public TennisResult getResult() {
        return new TennisResult(scores[game.getServer().getScore()], scores[game.getReceiver().getScore()]);
    }
}
