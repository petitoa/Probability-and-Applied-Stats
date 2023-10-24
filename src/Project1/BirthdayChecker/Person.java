package Project1.BirthdayChecker;

import java.util.ArrayList;
import java.util.Random;

/**
 * The Person class represents individuals with birthdays and provides methods related to the birthday problem.
 *
 * @author petitoa
 */

public class Person {
    int birthday;


    /**
     * Generates a random birthday.
     *
     * @return A random integer representing a birthday between 1 and 365.
     */
    public int randomBirthday() {
        Random random = new Random();
        birthday = random.nextInt(1, 365);
        return birthday;
    }

    /**
     * Sets birthdays for a specified number of people calling {@link #randomBirthday()}.
     *
     * @param people The number of people for the problem who need birthdays set.
     * @return An ArrayList of integers representing the birthdays.
     */
    public ArrayList<Integer> setBirthdays(int people) {
        ArrayList<Integer> birthdays = new ArrayList<>();
        for (int i = 0; i < people; i++) {
            birthdays.add(randomBirthday());
        }
        return birthdays;
    }

    /**
     * Calculates the probability of a birthday match in a group of n people over multiple iterations.
     *
     * @param people     The number of people in the group.
     * @param iterations The number of iterations to run.
     * @return The probability of at least one birthday match as a percentage.
     */
    public double birthdayProblem(int people, int iterations) {
        int matchingBirthdays = 0;
        for (int i = 0; i < iterations; i++) {
            // Create ArrayList with random birthdays for number of people
            ArrayList<Integer> birthdays = setBirthdays(people);
            // ArrayList of encountered birthdays
            ArrayList<Integer> encounteredBirthdays = new ArrayList<>();
            // Iterate through birthdays ArrayList
            for (Integer birthday : birthdays) {
                // If the current birthday is found in encounteredBirthdays
                if (encounteredBirthdays.contains(birthday)) {
                    matchingBirthdays++;
                    break; // stop when you find match
                }
                encounteredBirthdays.add(birthday);

            }


        }

        return ((double) matchingBirthdays / iterations) * 100;
    }
}
