import java.util.ArrayList;

public class testStatsLibrary {

    public static void main(String[] args){
        StatsLibrary test = new StatsLibrary();

        ArrayList<Double> testNumbers = new ArrayList<>();

        testNumbers.add(1.1);
        testNumbers.add(2.0);
        testNumbers.add(3.2);
        testNumbers.add(4.0);
        testNumbers.add(5.0);
        testNumbers.add(6.0);
        testNumbers.add(7.0);

        double testerResults = test.findMean(testNumbers);
        System.out.println("This is the average of test numbers: " + testerResults);

    }
}
