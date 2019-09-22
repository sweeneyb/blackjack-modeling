package com.sweeneyb.blackjack.players;

import com.sweeneyb.blackjack.Card;
import com.sweeneyb.blackjack.Game;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {


    List<Card> cards = new ArrayList<>();

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public int getCardSum() {
        return cards.stream().map( card -> card.getBlackjackValue() ).reduce(0, Integer::sum);
    }

    public void doTurn(Game game) {
        while( getCardSum() < 17) {
            cards.add(game.hit());
        }
    }
}
