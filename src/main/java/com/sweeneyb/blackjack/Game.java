package com.sweeneyb.blackjack;

import com.sweeneyb.blackjack.players.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    @Autowired
    @Qualifier("dealer")
    public Player dealer;

    @Autowired
    @Qualifier("players")
    public List<Player> players;

    public void startGame() {
        List<Player> turnOrder = new ArrayList<>();
        turnOrder.addAll(players);
        turnOrder.add( dealer);
        giveRoundOfCards(turnOrder);
        giveRoundOfCards(turnOrder);

        for ( Player player: turnOrder ) {
            player.doTurn(this);
        }

        int dealerSum = dealer.getCardSum();
        System.out.println("Dealer sum: "+ dealerSum);
        for(int i = 0;i< players.size();i++) {
            int score = players.get(i).getCardSum();
            System.out.println("Player "+i+" sum: "+score);
            if(score > dealerSum && score < 22) {
                System.out.println("Player " +i+" wins");
            }
            if(score < dealerSum) {
                System.out.println("Player " +i+" loses");
            }
            if(score == dealerSum) {
                System.out.println("Player " +i+" pushes");
            }
        }

    }

    public void giveRoundOfCards(List<Player> allPlayers) {
        for (Player player : allPlayers) {
            Card card = deal();

            // how trustworthy is the player?
            player.receiveCard(card);
        }
    }

    private Card deal() {
        return new Card();
    }

    public Card hit() {
        // additional enforcement so that a player can't hit after a bust?
        return deal();
    }


//    public Game(Player dealer, List<Player> players) {
//        this.dealer = dealer;
//        this.players = players;
//    }
}
