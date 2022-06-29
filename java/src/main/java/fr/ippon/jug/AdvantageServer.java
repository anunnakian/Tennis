package fr.ippon.jug;

class AdvantageServer implements ResultProvider {
    private final TennisGame4 game;

    public AdvantageServer(TennisGame4 game) {
        this.game = game;
    }

    @Override
    public TennisResult getResult() {
        return new TennisResult("Advantage " + game.getServer(), "");
    }

    public boolean checkScore() {
        return this.game.getServer().getScore() >= 4 && (this.game.getServer().getScore() - this.game.getReceiver().getScore()) == 1;
    }
}
