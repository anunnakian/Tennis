package fr.ippon.tennis;

class GameReceiver implements ResultProvider {
    private final TennisGame4 game;

    public GameReceiver(TennisGame4 game) {
        this.game = game;
    }

    @Override
    public boolean checkScore() {
        return game.getReceiver().getScore() >= 4 && (game.getReceiver().getScore() - game.getServer().getScore()) >= 2;
    }

    @Override
    public TennisResult getResult() {
        return new TennisResult("Win for " + game.getReceiver(), "");
    }
}