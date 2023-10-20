package Poker;

import java.util.*;

/**
 * The HandEvaluator class represents a utility for evaluating poker hands and calculating their probabilities.
 * It provides methods to draw cards, create hands, print hands, evaluate hands, and calculate percentages for various poker hand types.
 *
 * @author petitoa
 */
public class HandEvaluator {
    ArrayList<Card> deck = new ArrayList<>();

    private String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    private String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    Random rng = new Random();

    /**
     * Constructs a new HandEvaluator object and initializes the deck of cards.
     */
    public HandEvaluator() {
        makeDeck();
    }

    /**
     * Creates a standard deck of 52 playing cards and shuffles it.
     */
    private void makeDeck() {
        for (int suit = 0; suit < 4; suit++) {
            for (int value = 0; value < 13; value++) {
                deck.add(new Card(value, suit));
            }
        }
        Collections.shuffle(deck);
    }

    /**
     * Resets the deck by clearing it and calling {@link #makeDeck()}.
     */
    private void resetDeck() {
        deck.clear();
        makeDeck();
    }

    /**
     * Draws a random card from the deck and removes it from the deck.
     *
     * @return The drawn Card object.
     */
    public Card drawCard() {
        int randomIndex = rng.nextInt(deck.size());
        return deck.remove(randomIndex);
    }


    /**
     * Draws a specified number of cards to form a poker hand.
     *
     * @param handSize The size of the poker hand to draw.
     * @return An ArrayList containing the drawn Card objects representing the poker hand.
     */
    public ArrayList<Card> drawHand(int handSize) {
        ArrayList<Card> hand = new ArrayList<>();

        for (int i = 0; i < handSize; i++) {
            Card cardDrawn = drawCard();
            deck.remove(cardDrawn);
            hand.add(cardDrawn);
        }
        resetDeck();
        return hand;
    }

    /**
     * Deals multiple poker hands resetting the deck after each hand is drawn.
     *
     * @param numOfHands The number of poker hands to deal.
     * @param handSize   The size of each poker hand.
     * @return An ArrayList containing ArrayLists of Card objects, representing each dealt poker hand.
     */
    public ArrayList<ArrayList<Card>> dealHand(int numOfHands, int handSize) {
        ArrayList<ArrayList<Card>> drawnHands = new ArrayList<>();

        for (int i = 0; i < numOfHands; i++) {
            ArrayList<Card> hand = drawHand(handSize);
            drawnHands.add(hand);
            resetDeck();
        }
        return drawnHands;
    }


    /**
     * Draws a poker hand with the specified number of cards and maps suit and value to each for display.
     *
     * @param handSize The number of cards to draw for the hand.
     * @return An ArrayList representing the drawn poker hand.
     */
    public ArrayList<String> testDrawHand(int handSize) {
        ArrayList<Card> hand = drawHand(handSize);
        resetDeck();

        // store assigned cards
        ArrayList<String> assignedCards = new ArrayList<>();

        // assign Values for each card in hand
        for (Card card : hand) {
            int suit = card.getSuit();
            int value = card.getValue();
            String assignedValues = values[value] + " of " + suits[suit];
            assignedCards.add(assignedValues);
        }
        return assignedCards;
    }

    /**
     * Determines if a poker hand contains a pair of cards with the same value.
     *
     * @param hand The poker hand to check for a pair.
     * @return true if the hand contains a pair, otherwise false.
     */
    public boolean hasPair(ArrayList<Card> hand) {
        ArrayList<Integer> valuesEncountered = new ArrayList<>();

        int count = 1;
        for (Card card : hand) {
            int value = card.getValue();

            if (valuesEncountered.contains(value)) {
                count++;
            }

            valuesEncountered.add(value);
        }

        // check for two matching values
        boolean hasPair = (count == 2);
        return hasPair;
    }

    /**
     * Determines if a poker hand contains three cards with the same value (three of a kind).
     *
     * @param hand The poker hand to check for three of a kind.
     * @return true if the hand contains three of a kind, otherwise false.
     */
    public boolean hasThreeOfAKind(ArrayList<Card> hand) {
        //start at index 0
        for (int i = 0; i < hand.size(); i++) {
            int count = 1;
            // start at i + 1 to create offset
            for (int j = i + 1; j < hand.size(); j++) {
                if (hand.get(i).getValue() == hand.get(j).getValue()) {
                    count++;
                }
            }
            // see if three of a kind
            if (count == 3) {
                return true; // Found three of a kind
            }
        }
        return false; // No three of a kind found
    }

    /**
     * Determines if a poker hand contains four cards with the same value (four of a kind).
     *
     * @param hand The poker hand to check for four of a kind.
     * @return true if the hand contains four of a kind, otherwise false.
     */
    public boolean hasFourOfAKind(ArrayList<Card> hand) {
        //start at index 0
        for (int i = 0; i < hand.size(); i++) {
            int count = 1;
            // start at index 1 to create offset
            for (int j = i + 1; j < hand.size(); j++) {
                if (hand.get(i).getValue() == hand.get(j).getValue()) {
                    count++;
                }
            }
            // see if four of a kind
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if a poker hand contains a straight consisting of five values in a row.
     *
     * @param hand The poker hand to check for a straight.
     * @return true if the hand contains a straight, otherwise false.
     */
    public boolean hasStraight(ArrayList<Card> hand) {
        ArrayList<Integer> valuesEncountered = new ArrayList<>();

        for (Card card : hand) {
            int value = card.getValue();

            // add values not encountered to avoid duplicates
            if (!valuesEncountered.contains(value)) {
                valuesEncountered.add(value);
            }
        }
        Collections.sort(valuesEncountered);


        int straightCount = 1;
        // values - 1 so, you don't go out of bounds when comparing
        for (int i = 0; i < valuesEncountered.size() - 1; i++) {
            //compare value + 1 to next value
            if (valuesEncountered.get(i) + 1 == valuesEncountered.get(i + 1)) {
                straightCount++;
            } else {
                straightCount = 1;
            }
        }

        return (straightCount >= 5);
    }

    /**
     * Determines if a poker hand contains five cards of the same suit (a flush).
     *
     * @param hand The poker hand to check for a flush.
     * @return true if the hand contains a flush, otherwise false.
     */
    public boolean hasFlush(ArrayList<Card> hand) {
        ArrayList<Integer> suitsEncountered = new ArrayList<>();

        for (Card card : hand) {
            int value = card.getSuit();
            suitsEncountered.add(value);

            Collections.sort(suitsEncountered);

        }
        int flushCount = 1;
        // suit - 1 so you dont go out of bounds when comparing
        for (int i = 0; i < suitsEncountered.size() - 1; i++) {
            //compare suit + 1 to next value
            if (Objects.equals(suitsEncountered.get(i), suitsEncountered.get(i + 1))) {
                flushCount++;
            } else {
                flushCount = 1;
            }
        }

        return (flushCount >= 5);
    }

    /**
     * Determines if a poker hand contains a full house (three of a kind and a pair).
     *
     * @param hand The poker hand to check for a full house.
     * @return true if the hand contains a full house, otherwise false.
     */
    public boolean hasFullHouse(ArrayList<Card> hand) {
        Map<Integer, Integer> valueCounts = new HashMap<>();

        for (Card card : hand) {
            int value = card.getValue();

            // Get the current count or set to 0
            int currentCount = valueCounts.getOrDefault(value, 0);

            // Increment count by 1 and store it back in the map
            int newCount = currentCount + 1;
            valueCounts.put(value, newCount);
        }

        boolean hasPair = false;
        boolean hasThreeOfAKind = false;

        for (int value : valueCounts.keySet()) {
            int count = valueCounts.get(value);

            if (count == 2) {
                hasPair = true;
            }
            if (count == 3) {
                hasThreeOfAKind = true;
            }
        }

        // return true if both a pair and three of a kind with different values
        return hasPair && hasThreeOfAKind && valueCounts.size() >= 2;
    }

    /**
     * Determines if a poker hand contains a straight flush (a straight and a flush).
     *
     * @param hand The poker hand to check for a straight flush.
     * @return true if the hand contains a straight flush, otherwise false.
     */
    public boolean hasStraightFlush(ArrayList<Card> hand) {
        return hasStraight(hand) && hasFlush(hand);
    }

    /**
     * Determines if a poker hand contains a royal flush (a straight flush and flush highest card Ace).
     *
     * @param hand The poker hand to check for a royal flush.
     * @return true if the hand contains a royal flush, otherwise false.
     */
    public boolean hasRoyalFlush(ArrayList<Card> hand) {
        return hasStraight(hand) && hasFlush(hand);
    }

    /**
     * Determines if a poker hand contains high card.
     *
     * @param hand The poker hand to check for a high card.
     * @return true if the hand contains only a high card, otherwise false.
     */
    public boolean hasHighCard(ArrayList<Card> hand) {
        return !hasPair(hand) && !hasThreeOfAKind(hand) && !hasFourOfAKind(hand) && !hasStraight(hand) && !hasFlush(hand) && !hasFullHouse(hand);
    }

    /**
     * Calculates the percentage of occurrence of specific winning hands in a set number of hands.
     *
     * @param toBeCounted The list of outcomes to be counted.
     * @param numOfHands  The total number of trials or hands.
     * @return The percentage of occurrence of the specified outcomes.
     */
    public double calculatePercentage(ArrayList<Integer> toBeCounted, int numOfHands) {
        int sum = 0;

        for (int value : toBeCounted) {
            sum += value;
        }

        return ((double) sum / numOfHands) * 100;
    }

    /**
     * Evaluates a specified number of poker hands and the size of each poker hand. Calculates the percentage
     * of each possible hand type (e.g., pair, three of a kind, straight, etc.) that occurs in the hands.
     *
     * @param numOfHands The number of poker hands to evaluate.
     * @param handSize   The size of each poker hand.
     * @return A formatted string containing the percentage of occurrence for each hand type.
     */
    public String evaluateHands(int numOfHands, int handSize) {
        ArrayList<ArrayList<Card>> hands = dealHand(numOfHands, handSize);
        ArrayList<Integer> pair = new ArrayList<>();
        ArrayList<Integer> threeOfAKind = new ArrayList<>();
        ArrayList<Integer> fourOfAKind = new ArrayList<>();
        ArrayList<Integer> straight = new ArrayList<>();
        ArrayList<Integer> flush = new ArrayList<>();
        ArrayList<Integer> fullHouse = new ArrayList<>();
        ArrayList<Integer> straightFlush = new ArrayList<>();
        ArrayList<Integer> royalFlush = new ArrayList<>();
        ArrayList<Integer> highCard = new ArrayList<>();

        for (ArrayList<Card> hand : hands) {
            if (hasPair(hand)) {
                pair.add(1);
            }
            if (hasThreeOfAKind(hand)) {
                threeOfAKind.add(1);
            }
            if (hasFourOfAKind(hand)) {
                fourOfAKind.add(1);
            }
            if (hasStraight(hand)) {
                straight.add(1);
            }
            if (hasFlush(hand)) {
                flush.add(1);
            }
            if (hasFullHouse(hand)) {
                fullHouse.add(1);
            }
            if (hasStraightFlush(hand)) {
                straightFlush.add(1);
            }
            if (hasRoyalFlush(hand)) {
                royalFlush.add(1);
            }
            if (hasHighCard(hand)) {
                highCard.add(1);
            }
        }


        double percentagePair = calculatePercentage(pair, numOfHands);
        double percentageThreeOfAKind = calculatePercentage(threeOfAKind, numOfHands);
        double percentageFourOfAKind = calculatePercentage(fourOfAKind, numOfHands);
        double percentageStraight = calculatePercentage(straight, numOfHands);
        double percentageFlush = calculatePercentage(flush, numOfHands);
        double percentageFullHouse = calculatePercentage(fullHouse, numOfHands);
        double percentageStraightFlush = calculatePercentage(straightFlush, numOfHands);
        double percentageRoyalFlush = calculatePercentage(royalFlush, numOfHands);
        double percentageHighCard = calculatePercentage(highCard, numOfHands);

        // Print the percentages
        String result = "Percentage of Pair: " + String.format("%.6f", percentagePair) + "%\n" +
                "Percentage of Three of a Kind: " + String.format("%.6f", percentageThreeOfAKind) + "%\n" +
                "Percentage of Four of a Kind: " + String.format("%.6f", percentageFourOfAKind) + "%\n" +
                "Percentage of Straight: " + String.format("%.6f", percentageStraight) + "%\n" +
                "Percentage of Flush: " + String.format("%.6f", percentageFlush) + "%\n" +
                "Percentage of Full House: " + String.format("%.6f", percentageFullHouse) + "%\n" +
                "Percentage of Straight Flush: " + String.format("%.6f", percentageStraightFlush) + "%\n" +
                "Percentage of Royal Flush: " + String.format("%.6f", percentageRoyalFlush) + "%\n" +
                "Percentage of High Card: " + String.format("%.6f", percentageHighCard) + "%\n";

        return result;
    }
}
