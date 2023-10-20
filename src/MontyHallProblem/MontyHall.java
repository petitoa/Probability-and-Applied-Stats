package MontyHallProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * The MontyHall class is a simulation of the Monty Hall problem.
 * It provides methods for running simulations where a player can choose to switch doors or not in a game show of 3 doors and 1 prize.
 *
 * @author petitoa
 */
public class MontyHall {
    /**
     * Assigns two goats and a single car to three doors and shuffles their positions, so they are random.
     *
     * @return An ArrayList of integers representing the doors with goats represented by (0) and a car represented by (1).
     */
    public static ArrayList<Integer> assignGoatsAndCarDoors() {
        ArrayList<Integer> doors = new ArrayList<>(3);
        int goat = 0;
        int car = 1;

        // add 2 goats and car to ArrayList
        doors.add(goat);
        doors.add(goat);
        doors.add(car);

        // Shuffle the doors to randomize their positions
        Collections.shuffle(doors);

        return doors;
    }

    /**
     * Simulates the Monty Hall problem where the player decides to switch doors.
     *
     * @return The probability of winning when the player switches doors, as a percentage.
     */
    public double doorChanged() {
        ArrayList<Integer> results = new ArrayList<>();

        final int ITERATIONS = 10000;
        for (int i = 0; i < ITERATIONS; i++) {
            ArrayList<Integer> doorsChanged = new ArrayList<>(assignGoatsAndCarDoors());
            Random random = new Random();

            //Randomly choose door and remove so it's not opened next.
            int chosenDoor1 = doorsChanged.get(random.nextInt(3));
            doorsChanged.remove(chosenDoor1);

            //"Open" a random door that does not contain the car.
            int goatIndex = doorsChanged.indexOf(0);
            if (goatIndex != -1) {
                // Remove a goat so it can't be chosen.
                doorsChanged.remove(goatIndex);
            }

            //Switch to last option
            int chosenDoor2 = doorsChanged.get(0);

            // If the second chosen door contains a car
            if (chosenDoor2 == 1) {
                results.add(chosenDoor2);
            }

        }

        int wins = 0;
        for (int element : results) {
            wins += element;
        }

        return ((double) wins / ITERATIONS) * 100;
    }

    /**
     * Simulates the Monty Hall problem when the player decides not to switch doors.
     *
     * @return The probability of winning when the player does not switch doors, as a percentage.
     */
    public double doorNotChanged() {
        ArrayList<Integer> results = new ArrayList<>();

        final int ITERATIONS = 10000;
        for (int i = 0; i < ITERATIONS; i++) {
            ArrayList<Integer> doorsNotChanged = new ArrayList<>(assignGoatsAndCarDoors());
            Random random = new Random();

            //Randomly choose door because it's always P(1/3)
            int chosenDoor = doorsNotChanged.get(random.nextInt(3));

            if (chosenDoor == 1) {
                results.add(chosenDoor);
            }

        }

        int wins = 0;
        for (int element : results) {
            wins += element;
        }

        return ((double) wins / ITERATIONS) * 100;
    }

}