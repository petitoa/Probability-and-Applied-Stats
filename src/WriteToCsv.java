import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToCsv {
    public static void main(String[] args) {
        Factory test = new Factory();

        ArrayList<Car> cars = test.createCars(1000);

        try {
            FileWriter fw = new FileWriter("cars.csv");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("CarType,Year,Color,Miles");

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


