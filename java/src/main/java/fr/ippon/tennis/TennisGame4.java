package fr.ippon.tennis;

import java.util.ArrayList;
import java.util.List;

public class TennisGame4 implements TennisGame {

    private final Player server;
    private final Player receiver;

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
        List<ResultProvider> resultProviders = new ArrayList<>();
        resultProviders.add(new Deuce(this));
        resultProviders.add(new GameServer(this));
        resultProviders.add(new GameReceiver(this));
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