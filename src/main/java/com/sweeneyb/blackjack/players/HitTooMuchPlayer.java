package com.sweeneyb.blackjack.players;

import com.sweeneyb.blackjack.Game;

public class HitTooMuchPlayer extends Player {

    public void doTurn(Game game) {
        while( getCardSum() < 37) {
            cards.add(game.hit());
        }
    }
}
