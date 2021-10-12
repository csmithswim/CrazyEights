package com.csmithswim;

import java.util.Random;

public class Deck {

    protected Card card;
    protected Card[] deck = new Card[52];

    protected void createAndShuffleDeck() {

        //building the deck, starting the loop by suit in outer loop, inner loop with rank
        int counter = 0;
        for (SUIT suit : SUIT.values()){
            for (RANK rank : RANK.values()) {
                deck[counter] = new Card(suit, rank);
                counter++;
            }
        }

        //shuffling deck using a random index variable and swapping the values in the deck
        Random random = new Random();

        for (int i = 0; i < deck.length;  i++) {
            int randomIndex = random.nextInt(52);

            //cards to be swapped
            Card sortedCard = deck[i];
            Card randomCard = deck[randomIndex];

            //swapping
            deck[randomIndex] = sortedCard;
            deck[i] = randomCard;

        }

    }

    protected void displayDeck() {
        StringBuilder output = new StringBuilder();
        for (Card card : deck) {
            output.append(card.RANK).append(" of ").append(card.SUIT).append("\n");
        }
        System.out.println(output);
    }
}
