package fr.ippon.tennis;

class AdvantageServer implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public AdvantageServer(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public boolean checkScore() {
        return game.getServer().getScore() >= 4 && (game.getServer().getScore() - game.getReceiver().getScore()) == 1;
    }

    @Override
    public TennisResult getResult() {
        if (checkScore())
            return new TennisResult("Advantage " + game.getServer(), "");
        return this.nextResult.getResult();
    }
}