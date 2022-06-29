package fr.ippon.tennis;

class AdvantageServer implements ResultProvider {
    private final TennisGame4 game;

    public AdvantageServer(TennisGame4 game) {
        this.game = game;
    }

    @Override
    public boolean checkScore() {
        return game.getServer().getScore() >= 4 && (game.getServer().getScore() - game.getReceiver().getScore()) == 1;
    }

    @Override
    public TennisResult getResult() {
        return new TennisResult("Advantage " + game.getServer(), "");
    }
}