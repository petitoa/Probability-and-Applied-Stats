package Poker;

public class Card {
    private int value;
    private int suit;

    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    // getters
    public int getValue() {
        return value;
    }


    public int getSuit() {
        return suit;
    }


}
