/**
 * Extend this class
 * Write formula for what we learn
 * Alexis Petito
 */
package StatsLibrary;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class StatsLibrary {
    public double findMean(ArrayList<Double> userInputNumbers) {
        double sum = 0;

        for (double singleElement : userInputNumbers) {
            sum = sum + singleElement;

        }

        //Storing value for clarity
        double result = sum / userInputNumbers.size();
        return result;
    }

    //Find Median
    public double findMedian(ArrayList<Double> userInputNumbers) {
        Collections.sort(userInputNumbers);
        int size = userInputNumbers.size();
        double median;

        //if array is even find average of middle values else get middle value
        if (size % 2 == 0) {
            double middle1 = userInputNumbers.get((size / 2) + 1);
            double middle2 = userInputNumbers.get((size / 2) - 1);
            median = (middle1 + middle2) / 2;
        } else {
            median = userInputNumbers.get(size / 2);
        }
        return median;
    }

    //Find Mode
    //Checks when there is no mode
    public double findMode(ArrayList<Double> userInputNumbers) {
        Collections.sort(userInputNumbers);
        ArrayList<Double> modes = new ArrayList<>();

        int highestCount = 0;
        // iterate through sorted list starting at index 0
        for (Double currentNumber : userInputNumbers) {
            int count = 0;
            // compare to numbers increase count accordingly
            for (Double number : userInputNumbers) {
                if (currentNumber.equals(number)) {
                    count++;
                }
            }

            if (count > highestCount) {
                highestCount = count;
                modes.clear(); // Clear the list for higher count
                modes.add(currentNumber); // Add the new mode
                //if the there is a tie between the highest count and count / it's not a duplicate mode
            } else if (count == highestCount && !modes.contains(currentNumber)) {
                modes.add(currentNumber); // Add to list of modes
            }
        }

        //If there are no numbers that occur more than once or 2 numbers occur the same amount of times greater than 1 return not a number (no mode)
        if (highestCount == 0 || modes.size() > 1) {
            return Double.NaN;
        }

        return modes.get(0);
    }


    //Standard deviation from list
    public double standardDeviation(ArrayList<Double> userInputNumbers) {
        double mean = findMean(userInputNumbers);

        ArrayList<Double> subtractMean = new ArrayList<>();
        //Subtract mean from each data point
        for (double singleElement : userInputNumbers) {
            subtractMean.add(singleElement - mean);
        }

        ArrayList<Double> squareDeviations = new ArrayList<>();
        //Square each deviation
        for (double singleElement : subtractMean) {
            squareDeviations.add(singleElement * singleElement);
        }

        int sizeMinus1 = squareDeviations.size() - 1;
        double sum = 0;
        //Sum squared deviations
        for (double singleElement : squareDeviations) {
            sum = sum + singleElement;
        }

        //Divide the sum by one less than the number of data points and return square root of result
        return Math.sqrt(sum / sizeMinus1);
    }

    public BigInteger factorial(int num) {
        if (num == 0) {
            return BigInteger.ONE;
        } else {
            BigInteger factorial = BigInteger.ONE;
            for (int i = 1; i <= num; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            return factorial;
        }
    }

    public BigInteger combinations(int objects, int times) {

        BigInteger objectsFactorial = factorial(objects);
        BigInteger timesFactorial = factorial(times);

        int objectsMinusTimes = objects - times;

        BigInteger objectsMinusTimesFactorial = factorial(objectsMinusTimes);

        BigInteger numerator = objectsFactorial;
        BigInteger denominator = timesFactorial.multiply(objectsMinusTimesFactorial);


        return numerator.divide(denominator);
    }

    public BigInteger permutations(int objects, int objectsSelected) {

        BigInteger objectsFactorial = factorial(objects);

        int objectsMinusObjectsSelected = objects - objectsSelected;

        BigInteger denominatorFactorial = factorial(objectsMinusObjectsSelected);

        BigInteger numerator = objectsFactorial;
        BigInteger denominator = denominatorFactorial;

        return numerator.divide(denominator);
    }

    public double independentIntersection(double a, double b) {
        return a * b;
    }

    public double dependentIntersection(double a, double bGivenA) {
        return a * bGivenA;
    }

    public double exclusiveUnion(double a, double b, double aAndB) {
        double union = a + b;
        return union * (1 - aAndB);
    }

    public double notExclusiveUnion(double a, double b, double aAndB) {

        return a + b - aAndB;
    }

    public String determineIndependenceOrDependent(double a, double b, double aAndB) {
        if (a * b == aAndB) {
            return "They are independent.";
        } else {
            return "They are dependent.";
        }

    }

    public double conditionalProbability(double aAndB, double b) {
        return aAndB / b;
    }

    public double bayesTheorem(double a, double b, double aGivenB) {
        return aGivenB * a / b;
    }

    public double binomialDistribution(double p, int n, int y) {
        // calculate p' known as q
        double q = 1 - p;

        // Calculate the combinations
        int combinations = combinations(n, y).intValue();

        double pExponentY = Math.pow(p, y);
        double qExponentNMinusY = Math.pow(q, n - y);

        // Multiply to get Binomial Distribution
        return combinations * pExponentY * qExponentNMinusY;
    }

}
