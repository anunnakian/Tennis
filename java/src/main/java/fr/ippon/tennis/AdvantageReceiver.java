package fr.ippon.tennis;

class AdvantageReceiver implements ResultProvider {

    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public AdvantageReceiver(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public boolean checkScore() {
        return game.getReceiver().getScore() >= 4 && (game.getReceiver().getScore() - game.getServer().getScore()) == 1;
    }
    @Override
    public TennisResult getResult() {
        if (checkScore())
            return new TennisResult("Advantage " + game.getReceiver(), "");
        return this.nextResult.getResult();
    }
}