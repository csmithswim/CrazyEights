package com.csmithswim;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    protected Card            card;
    protected ArrayList<Card> deck = new ArrayList<>();


    protected Deck() {
        createAndShuffleDeck();
    }

    //Eventually refactor this into the game constructor or createAndShuffleDeck method
    protected ArrayList<Card> initialDraw() {
        ArrayList<Card> playersHand = new ArrayList<>();

        for (int i = 0, j = deck.size() - 1; i < 8 && j > deck.size() - 8; i++, j--) {
            playersHand.add(deck.get(j));
            deck.remove(j);
        }
        return playersHand;
    }

    protected Card drawCard() {
        Card card =  deck.get(deck.size() - 1);
        deck.remove(deck.size() - 1);
        return card;
    }

    protected void createAndShuffleDeck() {

        //building the deck, starting the loop by suit in outer loop, inner loop with rank
        for (SUIT suit : SUIT.values()){
            for (RANK rank : RANK.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);
    }

    protected void displayDeck() {
        StringBuilder output = new StringBuilder();
        for (Card card : deck) {
            output.append(card.RANK).append(" of ").append(card.SUIT).append("\n");
        }
        System.out.println(output);
        System.out.println(deck.size());
    }

    protected void removeCard(Card card) {
        deck.remove(card);
    }

    protected int displayDeckLength() {
        return deck.size();
    }
}
