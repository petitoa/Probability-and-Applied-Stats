/** Extend this class
 * Write formula for what we learn
 * Alexis Petito
 */
import java.util.ArrayList;
import java.util.Collections;

public class StatsLibrary {
    //Mean, Method

    //Default constructor
    //public StatsLibrary(){

    //}

    //Non-Empty
    //public StatsLibrary(String input){

    //}

    //public StatsLibrary(Integer partyTime){

    //}
    public double findMean(ArrayList<Double> userInputNumbers){
        double sum = 0;

        for(double singleElement : userInputNumbers){
            sum = sum + singleElement;

        }

        //Storing value for clarity
        double result = sum / userInputNumbers.size();
        return result;
    }

    //Find Median
    public double findMedian(ArrayList<Double> userInputNumbers){
        Collections.sort(userInputNumbers);
        int size = userInputNumbers.size();
        double median;

        if(size % 2 == 0){
            double middle1 = userInputNumbers.get((size/2) + 1);
            double middle2 = userInputNumbers.get((size/2) - 1);
            median = (middle1 + middle2) / 2;
        } else {
            median = userInputNumbers.get(size / 2);
        }
    return median;
    }
    //Find Mode
    //public double findMode(ArrayList<Double> userInputNumbers){
        //double mode;
        //for(double singleElement : userInputNumbers){
            //sum = sum + singleElement;
            //return sum;
        //}
    //}
    //Standard deviation from list
    public double standardDeviation(ArrayList<Double> userInputNumbers){
        double mean = findMean(userInputNumbers);

        ArrayList<Double> subtractMean = new ArrayList<>();
        //Subtract mean from each data point
        for(double singleElement : userInputNumbers){
            subtractMean.add(singleElement - mean);
        }

        ArrayList<Double> squareDeviations = new ArrayList<>();
        //Square each deviation
        for(double singleElement : subtractMean){
            squareDeviations.add(singleElement * singleElement);
        }

        int sizeMinus1 = squareDeviations.size() - 1;
        double sum = 0;
        //Sum squared deviations
        for(double singleElement : squareDeviations){
            sum = sum + singleElement;
        }

        //Divide the sum by one less than the number of data points and return square root of result
        return Math.sqrt(sum / sizeMinus1);
    }
}
