package fr.ippon.tennis;

class AdvantageReceiver implements ResultProvider {

    private final TennisGame4 game;

    public AdvantageReceiver(TennisGame4 game) {
        this.game = game;
    }

    @Override
    public boolean checkScore() {
        return game.getReceiver().getScore() >= 4 && (game.getReceiver().getScore() - game.getServer().getScore()) == 1;
    }
    @Override
    public TennisResult getResult() {
        return new TennisResult("Advantage " + game.getReceiver(), "");
    }
}