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

        double independentIntersectionResults = test.independentIntersection(0.5, 0.4);
        double dependentIntersectionResults = test.dependentIntersection(0.5, 0.4);
        double exclusiveUnionResults = test.exclusiveUnion(0.5, 0.4, 0.7);
        double notExclusiveUnionResults = test.notExclusiveUnion(0.5, 0.4, 0.7);
        String independentOrDependentResults = test.determineIndependenceOrDependent(0.3, 0.5, 0.15);

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

        System.out.println("This is the independent intersection of test numbers: " + independentIntersectionResults);
        System.out.println("This is the dependent intersection of test numbers: " + dependentIntersectionResults);
        System.out.println("This is the exclusive union of test numbers: " + exclusiveUnionResults);
        System.out.println("This is the not exclusive union of test numbers: " + notExclusiveUnionResults);
        System.out.println("Are the test numbers independent or dependent? " + independentOrDependentResults);

    }
}
