package Project1.Poker;

/**
 * The Card class represents a playing card with a specific value and suit.
 * It is used to create individual playing card objects.
 *
 * @author petitoa
 */
public class Card {
    private int value;
    private int suit;

    /**
     * Constructs a new Card object with the specified value and suit.
     *
     * @param value The value of the card as an integer value from 2 represented by (0) to Ace represented by (12).
     * @param suit  The suit of the card as an integer value (e.g., 0 for Hearts, 1 for Diamonds, 2 for Clubs, 3 for Spades).
     */
    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * Gets the value of the card.
     *
     * @return The value of the card.
     */
    public int getValue() {
        return value;
    }

    /**
     * Gets the suit of the card.
     *
     * @return The suit of the card.
     */
    public int getSuit() {
        return suit;
    }


}
