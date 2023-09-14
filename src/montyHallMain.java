/**
 * Alexis Petito
 * Question A.)
 * E1 = nice prize, E2 = Dud1, E3 = Dud3
 * P(E1) = 1/3, P(E2) = 1/3, P(E3) = 1/3
 * Probability that the contestant selects curtain hiding nice prize = P(E1) = 1/3
 * Question B.)
 * In part a it is shown that the probability of the good prize is 1/3
 * In the event that one Dud is removed and you are asked to choose again the probability would become
 * E1 = nice prize, E2 = Dud1, E3 = Dud3
 * P(E1) = 1/3, P(E2) = 1/3, P(E3) = 1/3
 * EX.) P(E1) + P(E2) = 2/3 because the game show host removing a dud acts as another pick
 * if you switch the curtain the probability becomes 2/3, so switching the doors is the best choice.
 */


public class montyHallMain {
    public static void main(String[] args) {
        montyHall test = new montyHall();

        double doorNotChangedResult = test.doorNotChanged();
        double doorChangedResult = test.doorChanged();

        System.out.println("The percentage of wins when you don't switch doors : " + doorNotChangedResult + "%" + "\n" + "The percentage of wins when you switch doors : " + doorChangedResult + "%");


    }
}
