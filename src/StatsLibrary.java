/** Extend this class
 * Write formula for what we learn
 * name
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

    //Write These
    //Fine Median
    public double findMedian(ArrayList<Double> userInputNumbers){
        Collections.sort(userInputNumbers);
        int size = userInputNumbers.size();
        if(size % 2 == 0){
            double middle1 = userInputNumbers.get((size/2) + 1);
            double middle2 = userInputNumbers.get((size/2) - 1);
            double median = (middle1 + middle2) / 2;
        } else {
            median = userInputNumbers.get(size / 2);
        }
    return median;

    }
    //Find Mode
    //public double findMode(ArrayList<Double> userInputNumbers){

    //}
    //Standard deviation from list
    //public double standardDeviation(ArrayList<Double> userInputNumbers){

    //}
}
