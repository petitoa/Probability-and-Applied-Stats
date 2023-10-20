package Poker;

import java.util.ArrayList;

/**
 * A test class for evaluating and testing the functionality of the {@link HandEvaluator} class.
 *
 * @author petitoa
 */
public class TestHandEvaluator {

    public static void main(String[] args) {
        HandEvaluator test = new HandEvaluator();

        ArrayList<String> testHandDrawnResult = test.testDrawHand(5);

        // first param numOfHands second param handSize
        String testEvaluateHands = test.evaluateHands(200000, 5);

        System.out.println("This is a test hand: " + testHandDrawnResult);
        System.out.println("This is the result of 200000 hands with 5 cards in hand: \n" + testEvaluateHands);

    }
}
