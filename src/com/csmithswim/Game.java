package com.csmithswim;
import java.util.ArrayList;
import java.util.Arrays;
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

//        deck.displayDeck();

        playerOneHand = deck.initialDraw();

        discardPile.add(deck.drawCard());

        displayDiscardPile(discardPile);

        playerOneHand.add(deck.drawCard());

        displayHand(playerOneHand);

        System.out.println("What card do you want to remove? Enter each one separated by spaces.");
        String input = scanner.nextLine();


        discardCard(input, playerOneHand);

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

    protected void displayDiscardPile(ArrayList<Card> discardPile) {
        StringBuilder output = new StringBuilder("Discard Pile: ");
        for (Card card : discardPile) {
            output.append(card.RANK).append(" of ").append(card.SUIT).append("\n");
        }
        System.out.println(output);
    }

    protected boolean validateDiscardSelection(String input, ArrayList<Card> hand) {
        String[] inputArray = input.split(" ");

        boolean flag = true;
        //rankCount > 1
        //suitCount < 2

        int rankCount = 0;
        int suitCount = 0;
        Card[] inputCardArray = new Card[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            inputCardArray[i] = hand.get(Integer.parseInt(inputArray[i]) -1);
        }

        for (int i = 0; i < inputCardArray.length; i++) {
            for (int j = 0; j < inputCardArray.length; j++) {
                if (inputCardArray[i].RANK == inputCardArray[j].RANK){
                    rankCount++;
                    break;
                }
            }
        }
        System.out.println("Rank count: " + rankCount);
        System.out.println("Suit count: " + suitCount);
        System.out.println(inputCardArray.length);
        System.out.println(!input.isEmpty());
        if (rankCount != inputCardArray.length || input.isEmpty()) {
            System.out.println("Invalid choices, rank count must equal to input length");
            flag = false;
        }
        return flag;
    }

    protected ArrayList<Card> discardCard(String input, ArrayList<Card> hand) {
        String[] inputArray     = input.split(" ");
        boolean  flag           = true;
        int      rankCount      = 0;
        Card[]   cardInputArray = new Card[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            cardInputArray[i] = hand.get(Integer.parseInt(inputArray[i]) - 1);
        }

        for (int i = 0; i < cardInputArray.length; i++) {
            for (int j = 0; j < cardInputArray.length; j++) {
                if (cardInputArray[i].RANK == cardInputArray[j].RANK) {
                    rankCount++;
                    break;
                }
            }
        }

        if (rankCount != cardInputArray.length || input.isEmpty()) {
            System.out.println("Invalid choices, rank count must equal to input length");
        }

        for (Card inputCard : cardInputArray) {
            if (inputCard.RANK == discardPile.get(discardPile.size() - 1).RANK) {
                hand.remove(hand.indexOf(inputCard));
            } else if (inputCard.SUIT == discardPile.get(discardPile.size() - 1).SUIT) {
                hand.remove(hand.indexOf(inputCard));
            } else if (inputCard.RANK == RANK.EIGHT) {
                hand.remove(hand.indexOf(inputCard));
            } else {
                System.out.println("Invalid entry! These cards do not match discard pile!");
            }
        }
        return hand;
    }
}



        //Allow for multiple cards of the same RANK to be discarded
        //Implement a system to change the suit when an 8 is played




