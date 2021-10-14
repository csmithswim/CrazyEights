package com.csmithswim;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

//    protected String[] players = {"Tom", "Jerry"};

    protected ArrayList<Card> playerOneHand = new ArrayList<>();
    protected ArrayList<Card> playerTwoHand = new ArrayList<>();

    protected ArrayList<Card> discardPile = new ArrayList<>();

    //Card to test conditionals is always discardDeck.get(discardDeck.size() - 1)

    //A card can be discarded onto discardPile IF suite matches || rank matches || rank == 8


    protected void run () {

        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();

        deck.displayDeck();

        playerOneHand = deck.initialDraw();

        discardPile.add(deck.drawCard());

        displayHand(discardPile);

        playerOneHand.add(deck.drawCard());

        displayHand(playerOneHand);

        System.out.println("What card do you want to remove?");
        int input = scanner.nextInt();

        discardCard(input - 1, playerOneHand);

        displayHand(playerOneHand);
    }

    protected void displayHand(ArrayList<Card> hand) {
        StringBuilder output = new StringBuilder("");
        int counter = 1;
        for (Card card : hand) {
            output.append(counter + "  ").append(card.RANK).append(" of ").append(card.SUIT).append("\n");
            counter++;
        }
        System.out.println(output);
    }

    protected ArrayList<Card> discardCard(int input, ArrayList<Card> hand) {
        boolean canDiscard = false;
        Card card = hand.get(input);

        if (card.RANK == discardPile.get(discardPile.size() - 1).RANK
                || card.SUIT == discardPile.get(discardPile.size() - 1).SUIT
                || card.RANK == RANK.EIGHT) {
            System.out.println("Valid card selection, card now added to discard pile.");
            hand.remove(input);
        } else {
            System.out.println("Invalid card selection!");
        }

        return hand;
    }
}
