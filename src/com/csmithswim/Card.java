package com.csmithswim;

enum SUIT {
    HEARTS, SPADES, DIAMONDS, CLUBS
}

enum RANK {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
    TEN, JACK, QUEEN, KING, ACE
}

public class Card {

    protected SUIT SUIT;
    protected RANK RANK;

    Card(SUIT SUIT, RANK RANK) {
        this.SUIT = SUIT;
        this.RANK = RANK;
    }

    protected SUIT getSuit(Card card) {
        return this.SUIT;
    }

    protected RANK getRank(Card card) {
        return this.RANK;
    }


    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(RANK).append("  ").append(SUIT);
        System.out.println(output);
        return new String(output);
    }
}

