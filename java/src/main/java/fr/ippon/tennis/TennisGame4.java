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
        DefaultResult defaultResult = new DefaultResult(this);
        AdvantageReceiver advantageReceiver = new AdvantageReceiver(this, defaultResult);
        AdvantageServer advantageServer = new AdvantageServer(this, advantageReceiver);
        GameReceiver gameReceiver = new GameReceiver(this, advantageServer);
        GameServer gameServer = new GameServer(this, gameReceiver);
        Deuce deuce = new Deuce(this, gameServer);
        TennisResult result = deuce.getResult();
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

}