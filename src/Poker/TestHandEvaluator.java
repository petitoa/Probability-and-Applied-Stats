package Poker;

import java.util.ArrayList;

public class TestHandEvaluator {

    public static void main(String[] args) {
        HandEvaluator test = new HandEvaluator();

        ArrayList<String> testHandDrawnResult = test.testDrawHand(5);

        // first param numOfHands second param handSize
        String testEvaluateHands = test.evaluateHands(200000, 5);

        System.out.println("This is a test hand: " + testHandDrawnResult);
        System.out.println("This is the result of 10000 hands with 5 cards in hand: \n" + testEvaluateHands);

    }
}
