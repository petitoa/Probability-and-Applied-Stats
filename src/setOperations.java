import java.util.ArrayList;

public class setOperations {
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

    public ArrayList<String> findIntersection(ArrayList<String> daysOfTheWeek, ArrayList<String> subsetA) {
        ArrayList<String> intersection = new ArrayList<>();

        for (String currentDay : daysOfTheWeek) {
            if (subsetA.contains(currentDay)) {
                intersection.add(currentDay);
            }
        }
        return intersection;
    }

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
