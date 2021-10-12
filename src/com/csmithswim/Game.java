package com.csmithswim;
import java.util.Scanner;


public class Game {

    int[] players;

    Deck deck;

    public void run () {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();

        deck.createAndShuffleDeck();

        deck.displayDeck();



    }
}
