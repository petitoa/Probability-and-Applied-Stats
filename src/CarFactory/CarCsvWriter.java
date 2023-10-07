package CarFactory;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The CarCsvWriter class writes Car data to a CSV file.
 * Takes a ArrayList of Car objects, formats the data, and stores it in a CSV file.
 *
 * @author petitoa
 */
public class CarCsvWriter {
    public static void main(String[] args) {
        CarFactory test = new CarFactory();

        ArrayList<Car> cars = test.createCars(1000);

        try {
            FileWriter fw = new FileWriter("cars.csv");
            BufferedWriter bw = new BufferedWriter(fw);

            // Write Header
            bw.write("CarType,Year,Color,Miles");

            // Write Car objects data to the CSV file separated by commas
            for (Car car : cars) {
                bw.newLine();
                bw.write(car.getCarType() + "," + car.getYear() + "," + car.getColor() + "," + car.getMiles());
            }

            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}


