package fr.ippon.tennis;

class GameReceiver implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public GameReceiver(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public boolean checkScore() {
        return game.getReceiver().getScore() >= 4 && (game.getReceiver().getScore() - game.getServer().getScore()) >= 2;
    }

    @Override
    public TennisResult getResult() {
        if (checkScore())
            return new TennisResult("Win for " + game.getReceiver(), "");
        return this.nextResult.getResult();
    }
}