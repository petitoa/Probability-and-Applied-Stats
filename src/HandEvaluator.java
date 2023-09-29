import java.util.ArrayList;
import java.util.Random;

public class HandEvaluator {
    ArrayList<Card> hand = new ArrayList<>();
    ArrayList<Card> deck = new ArrayList<>();

    public HandEvaluator() {
        // Maybe populate deck
        //use random rng for random number generator
        //4 loops one of each suite use new card(suit, value)
        // add to deck
        int setValue = 0;
        for (int i = 0; i < 13; i++) {
            int suit = 0;
            deck.add(new Card(suit, setValue));
            setValue++;
        }

        int setValue1 = 0;
        for (int i = 0; i < 13; i++) {
            int suit = 1;
            deck.add(new Card(suit, setValue1));
            setValue1++;
        }


        int setValue2 = 2;
        for (int i = 0; i < 13; i++) {
            int suit = 2;
            deck.add(new Card(suit, setValue2));
            setValue2++;
        }

        int setValue3 = 3;
        for (int i = 0; i < 13; i++) {
            int suit = 4;
            deck.add(new Card(suit, setValue3));
            setValue3++;
        }


    }

    public void drawCard() {
        //take random card from deck
        //add to hand array
        // remove card from deck
    }

}
