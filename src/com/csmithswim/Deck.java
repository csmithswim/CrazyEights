package com.csmithswim;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    protected ArrayList<Card> deck = new ArrayList<>();

    protected Deck() {
        createAndShuffleDeck();
    }

    protected ArrayList<Card> addAndShuffleDiscardPile(ArrayList<Card> discardPile) {
        if (!deck.isEmpty()) {
            for (int i = 0; i < deck.size(); i++) {
                deck.remove(i);
            }
        }

        for (int i = 0; i < discardPile.size() - 1; i++) {
            deck.add(discardPile.get(i));
        }
        Collections.shuffle(deck);
        return deck;
    }

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
        for (SUIT suit : SUIT.values()){
            for (RANK rank : RANK.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(deck);
    }

    protected void removeCard(Card card) {
        deck.remove(card);
    }

    protected int getDeckLength() {
        return deck.size();
    }
}
