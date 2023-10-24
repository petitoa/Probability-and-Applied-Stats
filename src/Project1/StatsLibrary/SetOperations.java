package Project1.StatsLibrary;

import java.util.ArrayList;

/**
 * This class provides methods for performing set operations on lists of strings.
 *
 * @author petitoa
 */
public class SetOperations {

    /**
     * Finds the union of two ArrayLists of strings.
     *
     * @param daysOfTheWeek The first ArrayList which is all the days of the week.
     * @param subsetA       The second ArrayList which is subset a.
     * @return The union of the two ArrayLists.
     */
    public ArrayList<String> findUnion(ArrayList<String> daysOfTheWeek, ArrayList<String> subsetA) {
        ArrayList<String> union = new ArrayList<>();

        for (String currentDay : daysOfTheWeek) {
            if (!union.contains(currentDay)) {
                union.add(currentDay);
            }
        }

        for (String currentDaySubset : subsetA) {
            if (!union.contains(currentDaySubset)) {
                union.add(currentDaySubset);
            }
        }
        return union;
    }

    /**
     * Finds the intersection of two ArrayLists of strings.
     *
     * @param daysOfTheWeek The first ArrayList which is all the days of the week.
     * @param subsetA       The second ArrayList which is subset a.
     * @return The intersection of the two ArrayLists.
     */
    public ArrayList<String> findIntersection(ArrayList<String> daysOfTheWeek, ArrayList<String> subsetA) {
        ArrayList<String> intersection = new ArrayList<>();

        for (String currentDay : daysOfTheWeek) {
            if (subsetA.contains(currentDay)) {
                intersection.add(currentDay);
            }
        }
        return intersection;
    }

    /**
     * Finds the complement of two ArrayLists of strings.
     *
     * @param daysOfTheWeek The first ArrayList which is all the days of the week.
     * @param subsetA       The second ArrayList which is subset a.
     * @return The complement of the two ArrayLists.
     */
    public ArrayList<String> findComplement(ArrayList<String> daysOfTheWeek, ArrayList<String> subsetA) {
        ArrayList<String> complement = new ArrayList<>();

        for (String currentDay : daysOfTheWeek) {
            //if the current day in daysOfTheWeek is not contained in subset A
            if (!subsetA.contains(currentDay)) {
                complement.add(currentDay);
            }
        }
        return complement;
    }

}
