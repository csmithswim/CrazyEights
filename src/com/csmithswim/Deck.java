package com.csmithswim;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    protected Card            card;
    protected ArrayList<Card> dealingDeck = new ArrayList<>();


    protected Deck() {
        createAndShuffleDeck();
    }

    //Eventually refactor this into the game constructor or createAndShuffleDeck method
    protected ArrayList<Card> initialDraw() {
        ArrayList<Card> playersHand = new ArrayList<>();

        for (int i = 0, j = dealingDeck.size() - 1; i < 20 && j > dealingDeck.size() - 20; i++, j--) {
            playersHand.add(dealingDeck.get(j));
            dealingDeck.remove(j);
        }
        System.out.println();;
        return playersHand;
    }

    protected Card drawCard() {
        Card card =  dealingDeck.get(dealingDeck.size() - 1);
        dealingDeck.remove(dealingDeck.size() - 1);
        return card;
    }

    protected void createAndShuffleDeck() {

        //building the deck, starting the loop by suit in outer loop, inner loop with rank
        for (SUIT suit : SUIT.values()){
            for (RANK rank : RANK.values()) {
                dealingDeck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(dealingDeck);
    }

    protected void displayDeck() {
        StringBuilder output = new StringBuilder();
        for (Card card : dealingDeck) {
            output.append(card.RANK).append(" of ").append(card.SUIT).append("\n");
        }
        System.out.println(output);
        System.out.println(dealingDeck.size());
    }

    protected void displayDeckLength() {
        System.out.println(dealingDeck.size());
    }
}
