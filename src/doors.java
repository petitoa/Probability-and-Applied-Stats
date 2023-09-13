import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class doors {
    public static ArrayList<Integer> assignGoatsAndCarDoors() {
        ArrayList<Integer> doors = new ArrayList<>(3);
        int goat = 0;
        int car = 1;

        Random random = new Random();

        doors.add(car);

        doors.add(random.nextInt(3), goat);
        doors.add(random.nextInt(3), goat);

        return doors;
    }

    public boolean doorChanged(ArrayList<Integer> doors){
        return null;
    }

    public boolean doornotChanged()
}
