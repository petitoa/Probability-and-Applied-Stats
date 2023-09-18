import java.math.BigInteger;
import java.util.ArrayList;

public class TestStatsLibrary {

    public static void main(String[] args) {
        StatsLibrary test = new StatsLibrary();

        ArrayList<Double> testNumbers = new ArrayList<>();

        testNumbers.add(1.1);
        testNumbers.add(2.0);
        testNumbers.add(3.2);
        testNumbers.add(4.0);
        testNumbers.add(1.1);
        testNumbers.add(5.0);
        testNumbers.add(6.0);
        testNumbers.add(7.0);


        double meanResults = test.findMean(testNumbers);
        double medianResults = test.findMedian(testNumbers);
        double standardDeviation = test.standardDeviation(testNumbers);
        double modeResults = test.findMode(testNumbers);
        BigInteger combinationResults = test.combinations(13, 5);
        BigInteger permutationResults = test.permutations(10, 5);

        System.out.println("This is the average of test numbers: " + meanResults);
        System.out.println("This is the median of test numbers: " + medianResults);
        System.out.println("This is the standard deviation of test numbers: " + standardDeviation);
        System.out.println("This is the number of the combination n objects r times: " + combinationResults);
        System.out.println("This is the number of permutations in n objects with r objects selected: " + permutationResults);

        if (Double.isNaN(modeResults)) {
            System.out.println("There is no mode for these test numbers");
        } else {
            System.out.println("This is the mode for the test numbers: " + modeResults);
        }

    }
}
