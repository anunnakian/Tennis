package fr.ippon.jug;

class AdvantageReceiver implements ResultProvider {

    private final TennisGame4 game;

    public AdvantageReceiver(TennisGame4 game) {
        this.game = game;
    }

    @Override
    public TennisResult getResult() {
        return new TennisResult("Advantage " + game.getReceiver(), "");
    }

    public boolean checkScore() {
        return this.game.getReceiver().getScore() >= 4 && (this.game.getReceiver().getScore() - this.game.getServer().getScore()) == 1;
    }
}
