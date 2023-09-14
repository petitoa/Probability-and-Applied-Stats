import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class montyHall {
    public static ArrayList<Integer> assignGoatsAndCarDoors() {
        ArrayList<Integer> doors = new ArrayList<>(3);
        int goat = 0;
        int car = 1;

        // add 2 goats and car to list
        doors.add(goat);
        doors.add(goat);
        doors.add(car);

        // Shuffle the doors to randomize their positions
        Collections.shuffle(doors);

        return doors;
    }

    public double doorChanged() {
        ArrayList<Integer> results = new ArrayList<>();

        final int ITERATIONS = 10000;
        for (int i = 0; i < ITERATIONS; i++) {
            ArrayList<Integer> doorsChanged = new ArrayList<>(assignGoatsAndCarDoors());
            Random random = new Random();

            //Randomly choose door and remove so it's not opened next.
            int chosenDoor1 = doorsChanged.get(random.nextInt(3));
            doorsChanged.remove(chosenDoor1);

            //"Open" a random door that does not contain the car. Remove, so it can't be chosen.
            int goatIndex = doorsChanged.indexOf(0);
            if (goatIndex != -1) {
                doorsChanged.remove(goatIndex);
            }

            //Switch to last option
            int chosenDoor2 = doorsChanged.get(0);

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