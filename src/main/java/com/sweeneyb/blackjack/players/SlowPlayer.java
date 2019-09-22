package com.sweeneyb.blackjack.players;

import com.sweeneyb.blackjack.Game;

public class SlowPlayer extends Player {

    public void doTurn(Game game) {
        try {
            // How long is too long for a turn?
            Thread.sleep(1000* 5);
            super.doTurn(game);
        } catch (InterruptedException e ) {
            // what does interruption mean here?
        }
    }
}
