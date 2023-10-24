package Project1.CarFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The CarCsvReader class reads created car data from a CSV file.
 * It parses the CSV file and creates Car objects from the data.
 *
 * @author petitoa
 */
public class CarCsvReader {
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "cars.csv";
        File file = new File(filename);

        ArrayList<Car> cars = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {

            // Delimiter set to comma or new line
            scanner.useDelimiter(",|\n");

            // Store and skip the header
            String header = scanner.nextLine();

            // Read car data from CSV file and create Car objects
            while (scanner.hasNextLine()) {
                String carType = scanner.next().trim();
                int year = Integer.parseInt(scanner.next().trim());
                String color = scanner.next().trim();
                int miles = Integer.parseInt(scanner.next().trim());
                cars.add(new Car(carType, year, color, miles));

            }

            // Print Header
            System.out.println(header);

            // Print Car objects
            for (Car car : cars) {
                System.out.println(car.getCarType() + "," + car.getYear() + "," + car.getColor() + "," + car.getMiles());
            }
        }
    }
}

