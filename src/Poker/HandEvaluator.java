package Poker;

import java.util.*;

public class HandEvaluator {
    ArrayList<Card> deck = new ArrayList<>();

    private String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    private String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    Random rng = new Random();

    public HandEvaluator() {
        makeDeck();
    }

    private void makeDeck() {
        for (int suit = 0; suit < 4; suit++) {
            for (int value = 0; value < 13; value++) {
                deck.add(new Card(value, suit));
            }
        }
        Collections.shuffle(deck);
    }

    private void resetDeck() {
        deck.clear();
        makeDeck();
    }

    public Card drawCard() {
        int randomIndex = rng.nextInt(deck.size());
        return deck.remove(randomIndex);
    }


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

    public ArrayList<ArrayList<Card>> dealHand(int numOfHands, int handSize) {
        ArrayList<ArrayList<Card>> drawnHands = new ArrayList<>();

        for (int i = 0; i < numOfHands; i++) {
            ArrayList<Card> hand = drawHand(handSize);
            drawnHands.add(hand);
            resetDeck();
        }
        return drawnHands;
    }


    public ArrayList<String> testDrawHand() {
        ArrayList<Card> hand = drawHand(5);
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
        // values - 1 so you dont go out of bounds when comparing
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
        return hasPair && hasThreeOfAKind && valueCounts.size() == 2;
    }


    public boolean hasStraightFlush(ArrayList<Card> hand) {
        return hasStraight(hand) && hasFlush(hand);
    }

    public boolean hasRoyalFlush(ArrayList<Card> hand) {
        return hasStraight(hand) && hasFlush(hand);
    }

    public boolean hasHighCard(ArrayList<Card> hand) {
        ArrayList<Integer> valuesEncountered = new ArrayList<>();

        for (Card card : hand) {
            int value = card.getValue(); // Collect card values, not suits
            valuesEncountered.add(value);
        }

        Collections.sort(valuesEncountered);

        // Check if the highest card value is Ace (value 12)
        return valuesEncountered.get(valuesEncountered.size() - 1) == 12;
    }

    public double calculatePercentage(ArrayList<Integer> toBeCounted, int numOfHands) {
        int sum = 0;

        for (int value : toBeCounted) {
            sum += value;
        }

        return ((double) sum / numOfHands) * 100;
    }

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
