package StatsLibrary;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * This class is used for testing the functionality of the StatsLibrary class, which provides various functions for probability and statistics.
 *
 * @author petitoa
 */
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

        BigInteger factorialResults = test.factorial(5);
        BigInteger combinationResults = test.combinations(13, 5);
        BigInteger permutationResults = test.permutations(10, 5);

        double independentIntersectionResults = test.independentIntersection(0.5, 0.4);
        double dependentIntersectionResults = test.dependentIntersection(0.5, 0.4);
        double exclusiveUnionResults = test.exclusiveUnion(0.5, 0.4, 0.7);
        double notExclusiveUnionResults = test.notExclusiveUnion(0.5, 0.4, 0.7);
        String independentOrDependentResults = test.determineIndependenceOrDependent(0.3, 0.5, 0.15);

        double conditionalProbabilityResults = test.conditionalProbability(.3, .5);
        double bayesTheoremResults = test.bayesTheorem(.2, .4, .1);

        double binomialExpectedValueResults = test.binomialExpectedValue(10, .2);
        double binomialVarianceResults = test.binomialVariance(10, .2);
        double binomialDistributionResults = test.binomialDistribution(.8, 10, 7);

        double geometricExpectedValueResults = test.geometricExpectedValue(.2);
        double geometricVarianceResults = test.geometricVariance(.2);
        double geometricDistributionResults = test.geometricDistribution(.2, 8);

        double hypergeometricDistributionResults = test.hypergeometricDistribution(5, 4, 10, 4);

        System.out.println("The mean of the test numbers: " + meanResults);
        System.out.println("The median of the test numbers: " + medianResults);
        System.out.println("The standard deviation of the test numbers: " + standardDeviation);
        System.out.println("The factorial of the test number: " + factorialResults);
        System.out.println("The number of the combination n objects r times: " + combinationResults);
        System.out.println("The number of permutations in n objects with r objects selected: " + permutationResults);

        if (Double.isNaN(modeResults)) {
            System.out.println("There is no mode for these test numbers");
        } else {
            System.out.println("The mode for the test numbers: " + modeResults);
        }

        System.out.println("The independent intersection of the test numbers: " + independentIntersectionResults);
        System.out.println("The dependent intersection of the test numbers: " + dependentIntersectionResults);
        System.out.println("The exclusive union of the test numbers: " + exclusiveUnionResults);
        System.out.println("The not exclusive union of the test numbers: " + notExclusiveUnionResults);
        System.out.println("Are the test numbers independent or dependent? " + independentOrDependentResults);

        System.out.println("The conditional probability of P(A and B) & P(B)? " + conditionalProbabilityResults);
        System.out.println("The Bayes Theorem result is? " + bayesTheoremResults);

        System.out.println("The Binomial Distribution Expected Value is: " + binomialExpectedValueResults);
        System.out.println("The Binomial Distribution Variance is: " + binomialVarianceResults);
        System.out.println("The Binomial Distribution is: " + binomialDistributionResults);

        System.out.println("The Geometric Distribution Expected Value is: " + geometricExpectedValueResults);
        System.out.println("The Geometric Distribution Variance is: " + geometricVarianceResults);
        System.out.println("The Geometric Distribution is: " + geometricDistributionResults);

        System.out.println("This is the Hypergeometric Distribution: " + hypergeometricDistributionResults);

    }
}
