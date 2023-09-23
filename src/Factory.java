import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedWriter;

//when choosing random numbers skew the miles in car
public class Factory {

    ArrayList<String> carType = new ArrayList<>();
    ArrayList<String> color = new ArrayList<>();
    Random random = new Random();

    public Factory() {
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

    public int getRandomYear() {
        return random.nextInt(1973, 2023 + 1);
    }

    public int getRandomMiles() {
        return random.nextInt(0, 250000 + 1);
    }

    public String getRandomCarType() {
        return carType.get(random.nextInt(carType.size()));
    }

    public String getRandomColor() {
        return color.get(random.nextInt(color.size()));
    }

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
