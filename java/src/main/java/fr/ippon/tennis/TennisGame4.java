package fr.ippon.tennis;

public class TennisGame4 implements TennisGame {

    private Player server;
    private Player receiver;

    public TennisGame4(Player server, Player receiver) {
        this.server = server; // semantic issue server/receiver
        this.receiver = receiver;
    }

    public Player getServer() {
        return server;
    }

    public Player getReceiver() {
        return receiver;
    }

    @Override
    public String getScore() {
        TennisResult result = new Deuce(
                this, new GameServer(
                        this, new GameReceiver(
                                this, new AdvantageServer(
                                        this, new AdvantageReceiver(
                                                this, new DefaultResult(this)))))).getResult();
        return result.format();
    }

    boolean receiverHasAdvantage() {
        return receiver.getScore() >= 4 && (receiver.getScore() - server.getScore()) == 1;
    }

    boolean serverHasAdvantage() {
        return server.getScore() >= 4 && (server.getScore() - receiver.getScore()) == 1;
    }

    boolean receiverHasWon() {
        return receiver.getScore() >= 4 && (receiver.getScore() - server.getScore()) >= 2;
    }

    boolean serverHasWon() {
        return server.getScore() >= 4 && (server.getScore() - receiver.getScore()) >= 2;
    }

    boolean isDeuce() {
        return server.getScore() >= 3 && receiver.getScore() >= 3 && (server.getScore() == receiver.getScore());
    }
}