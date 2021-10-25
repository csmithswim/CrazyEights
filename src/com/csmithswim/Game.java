package com.csmithswim;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    protected ArrayList<String> players = new ArrayList<>();
    protected ArrayList<ArrayList<Card> > hands = new ArrayList<>();
    protected ArrayList<Card> discardPile = new ArrayList<>();
    protected Deck            dealingDeck = new Deck();
    protected boolean running = true;
    protected StringBuilder consoleMessage = new StringBuilder();

    protected void run () {
        Scanner scanner = new Scanner(System.in);

        addPlayers();

        for (String player : players) {
            hands.add(dealingDeck.initialDraw());
        }

        discardPile.add(dealingDeck.drawCard());

        while (running) {
            runRound();
        }
    }

    protected void runRound() {
        for (int i = 0; i < players.size(); i = i % players.size()) {
            runTurn(i);
            if (hands.get(i).size() == 0) {
                System.out.println(players.get(i) + "Wins!!!!");
                running = false;
                break;
            }
            i++;
        }
    }

    protected void runTurn(int player) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            consoleMessage.append("\n").append(players.get(player)).append("'s turn.\n\n").append("Hand: \n").append(displayHand(hands.get(player)));
            System.out.println(consoleMessage);
            consoleMessage.replace(0, consoleMessage.length() - 1, "Discard pile: " + discardPile.get(discardPile.size() - 1).toString());
            System.out.println(consoleMessage);

            System.out.print("1.Discard\n2.Draw\n");

            String input = scanner.nextLine();

            if ("1".equals(input)) {
                int flag = hands.get(player).size();
                System.out.print("What card do you want to remove? Enter each one separated by spaces.\n");
                String cardInput = scanner.nextLine();
                discardCard(cardInput, hands.get(player));
                if (flag == hands.get(player).size()) {
                    continue;
                }
                break;

            //Does not keep track of player's cards when reshuffles
            } else if ("2".equals(input)) {
                hands.get(player).add(dealingDeck.drawCard());
                //
                Card topCard = discardPile.get(discardPile.size() - 1);
                if (dealingDeck.getDeckLength() == 0) {
                    dealingDeck.addAndShuffleDiscardPile(discardPile);
                    discardPile.clear();
                    discardPile.add(topCard);
                }
                continue;
            }
        }
    }

    protected ArrayList<String> addPlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players?");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.println("Player " + i + ": ");
            String name = scanner.nextLine();
            players.add(name);
        }
        return players;
    }

    protected String displayHand(ArrayList<Card> hand) {
        StringBuilder output = new StringBuilder("");
        int counter = 1;
        for (Card card : hand) {
            output.append(counter + "  ").append(card.RANK).append(" of ").append(card.SUIT).append("\n");
            counter++;
        }
        return new String(output);
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
            if (inputCard.RANK == RANK.EIGHT) {
                while (true) {
                    System.out.print("What suit do you want to change to? Options are HEARTS/CLUBS/SPADES/DIAMONDS\n");
                    Scanner scanner   = new Scanner(System.in);
                    String  suitInput = scanner.nextLine().toUpperCase();
                    if ("hearts".equalsIgnoreCase(suitInput) || "clubs".equalsIgnoreCase(suitInput)
                            || "spades".equalsIgnoreCase(suitInput) || "diamonds".equalsIgnoreCase(suitInput)) {
                        discardPile.add(inputCard);
                        discardPile.get(discardPile.size() - 1).SUIT = SUIT.valueOf(suitInput);
                        hand.remove(hand.indexOf(inputCard));
                        break;
                    }
                }
            } else if (inputCard.SUIT == discardPile.get(discardPile.size() - 1).SUIT) {
                hand.remove(hand.indexOf(inputCard));
                discardPile.add(inputCard);
            } else if (inputCard.RANK == discardPile.get(discardPile.size() - 1).RANK) {
                discardPile.add(inputCard);
                hand.remove(hand.indexOf(inputCard));
            } else {
                System.out.println("You cannot discard " + inputCard.toString());
            }
        }
        return hand;
    }
}



