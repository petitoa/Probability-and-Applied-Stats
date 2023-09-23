import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarCsvReader {
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "cars.csv";
        File file = new File(filename);

        ArrayList<Car> cars = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {

            scanner.useDelimiter(",|\n");
            String header = scanner.nextLine();


            while (scanner.hasNextLine()) {
                String carType = scanner.next().trim();
                int year = Integer.parseInt(scanner.next().trim());
                String color = scanner.next().trim();
                int miles = Integer.parseInt(scanner.next().trim());
                cars.add(new Car(carType, year, color, miles));

            }

            System.out.println(header);
            for (Car car : cars) {
                System.out.println(car.getCarType() + "," + car.getYear() + "," + car.getColor() + "," + car.getMiles());
            }
        }
    }
}

