package com.sweeneyb.blackjack;

public class Card {

    String face = null;
    String suit = null;

    int value;

    public Card() {
        value = (int) Math.round(Math.random()*11)+1;
    }

    // No accounting for Aces
    public int getBlackjackValue() {
        return value;
    }
}
