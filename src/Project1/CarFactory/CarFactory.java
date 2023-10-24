package Project1.CarFactory;

import java.util.ArrayList;
import java.util.Random;

/**
 * The CarFactory class creates random Car objects.
 * It generates random car types, colors, years, and miles to create Car instances.
 *
 * @author petitoa
 */
public class CarFactory {

    ArrayList<String> carType = new ArrayList<>();
    ArrayList<String> color = new ArrayList<>();
    Random random = new Random();

    /**
     * Constructs a new CarFactory object.
     * Initializes ArrayList of car types and colors.
     */
    public CarFactory() {
        //Add car types to array
        carType.add("Hatchback");
        carType.add("SUV");
        carType.add("Sedan");
        carType.add("Sedan");
        carType.add("Truck");
        carType.add("Coupe");
        carType.add("Convertible");

        //Add colors to array
        color.add("Red");
        color.add("Red");
        color.add("Blue");
        color.add("Yellow");
        color.add("White");
        color.add("Black");
        color.add("Cream");

    }

    /**
     * Generates a random year for a car between 1973 and 2023.
     *
     * @return A random year.
     */
    public int getRandomYear() {
        return random.nextInt(1973, 2023 + 1);
    }

    /**
     * Generates a random miles for a car between 0 and 250,000.
     *
     * @return A random number of miles.
     */
    public int getRandomMiles() {
        return random.nextInt(0, 250000 + 1);
    }

    /**
     * Gets a random car type from the ArrayList of car types.
     *
     * @return A random car type.
     */
    public String getRandomCarType() {
        return carType.get(random.nextInt(carType.size()));
    }

    /**
     * Gets a random color from the ArrayList of colors.
     *
     * @return A random color.
     */
    public String getRandomColor() {
        return color.get(random.nextInt(color.size()));
    }

    /**
     * Creates a list of random Car objects.
     *
     * @param numOfCars The number of Car objects to create.
     * @return An ArrayList of randomly generated Car objects.
     */
    ArrayList<Car> createCars(int numOfCars) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < numOfCars; i++) {
            String carType = getRandomCarType();
            int year = getRandomYear();
            String color = getRandomColor();
            int miles = getRandomMiles();
            cars.add(new Car(carType, year, color, miles));
        }
        return cars;
    }

}
