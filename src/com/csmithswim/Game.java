package com.csmithswim;
import java.util.ArrayList;
import java.util.Scanner;
import com.csmithswim.Deck;


public class Game {

    protected String[] players = {"Tom", "Jerry"};

    protected ArrayList<Card> playerOneHand;
    protected ArrayList<Card> playerTwoHand;



    protected void run () {

        Deck deck = new Deck();

        playerOneHand = deck.dealToPlayer();
//        playerTwoHand = deck.dealToPlayer();

        displayHand();
        deck.displayDeck();
        deck.displayDeckLength();


    }

    protected void displayHand() {
        StringBuilder output = new StringBuilder("");
        for (Card card : playerOneHand) {
            output.append(card.RANK).append(" of ").append(card.SUIT).append("\n");
        }
        System.out.println(output);
    }
}
