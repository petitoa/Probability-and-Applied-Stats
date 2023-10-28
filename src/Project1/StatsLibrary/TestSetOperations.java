package Project1.StatsLibrary;

import java.util.ArrayList;

/**
 * This class is used for testing the SetOperations class, which provides functions to perform set operations on ArrayLists.
 *
 * @author petitoa
 */
public class TestSetOperations {

    public static void main(String[] args) {
        SetOperations test = new SetOperations();

        ArrayList<String> daysOfTheWeek = new ArrayList<>();

        daysOfTheWeek.add("Monday");
        daysOfTheWeek.add("Tuesday");
        daysOfTheWeek.add("Wednesday");
        daysOfTheWeek.add("Thursday");
        daysOfTheWeek.add("Friday");
        daysOfTheWeek.add("Saturday");
        daysOfTheWeek.add("Sunday");

        ArrayList<String> subsetA = new ArrayList<>();

        subsetA.add("Tuesday");
        subsetA.add("Thursday");
        subsetA.add("Saturday");


        ArrayList<String> unionResults = test.findUnion(daysOfTheWeek, subsetA);
        ArrayList<String> intersectionResults = test.findIntersection(daysOfTheWeek, subsetA);
        ArrayList<String> complementResults = test.findComplement(daysOfTheWeek, subsetA);

        System.out.println("Set Days of Week: " + daysOfTheWeek);
        System.out.println("Subset A: " + subsetA);
        System.out.println("\nSet Operations:");
        System.out.println("The union of both arrays: " + unionResults);
        System.out.println("The intersection of both arrays: " + intersectionResults);
        System.out.println("The complement of subset A: " + complementResults);
    }
}
