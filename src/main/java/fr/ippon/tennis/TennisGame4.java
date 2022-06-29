package fr.ippon.tennis;

import java.util.ArrayList;
import java.util.List;

public class TennisGame4 implements TennisGame {

    private final Player server;
    private final Player receiver;

    public TennisGame4(String serverPlayer, String receiverPlayer) {
        this.server = Player.of(serverPlayer);
        this.receiver = Player.of(receiverPlayer);
    }

    public Player getServer() {
        return server;
    }

    public Player getReceiver() {
        return receiver;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals(server.getName())) {
            server.won();
        } else {
            receiver.won();
        }
    }

    @Override
    public String getScore() {
        List<ResultProvider> resultProviders = new ArrayList<>();
        resultProviders.add(new Deuce(this));
        resultProviders.add(new WinScore(server, receiver));
        resultProviders.add(new WinScore(receiver, server));
        resultProviders.add(new AdvantageServer(this));
        resultProviders.add(new AdvantageReceiver(this));

        for (ResultProvider resultProvider : resultProviders) {
            if (resultProvider.checkScore()) {
                return resultProvider.getResult().format();
            }
        }

        return new DefaultResult(this).getResult().format();
    }
}