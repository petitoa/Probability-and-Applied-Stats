package BirthdayChecker;

import java.util.ArrayList;
import java.util.Random;

public class Person {
    int birthday;


    public int randomBirthday() {
        Random random = new Random();
        birthday = random.nextInt(1, 365);
        return birthday;
    }

    public ArrayList<Integer> setBirthdays(int people) {
        ArrayList<Integer> birthdays = new ArrayList<>();
        for (int i = 0; i < people; i++) {
            birthdays.add(randomBirthday());
        }
        return birthdays;
    }

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
