package fr.ippon.jug;

import java.util.ArrayList;
import java.util.List;

public class TennisGame4 implements TennisGame {

    private final Player server;
    private final Player receiver;

    public TennisGame4(Player server, Player receiver) {
        this.server = server;
        this.receiver = receiver;
    }

    @Override
    public String getScore() {
        List<ResultProvider> resultProviders = new ArrayList<>();
        resultProviders.add(new Deuce(this));
        resultProviders.add(new GameServer(this));
        resultProviders.add(new GameReceiver(this));
        resultProviders.add(new AdvantageServer(this));
        resultProviders.add(new AdvantageReceiver(this));
        resultProviders.add(new DefaultResult(this));

        for(ResultProvider resultProvider: resultProviders)
            if(resultProvider.checkScore())
                return resultProvider.getResult().format();

        TennisResult defaultResult = new DefaultResult(this).getResult();
        return defaultResult.format();
    }

    @Override
    public Player getServer() {
        return this.server;
    }

    @Override
    public Player getReceiver() {
        return this.receiver;
    }
}

