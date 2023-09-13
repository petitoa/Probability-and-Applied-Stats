import java.util.ArrayList;

public class testSetOperations {

    public static void main(String[] args) {
        setOperations test = new setOperations();

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


        System.out.println("The union of both arrays: " + unionResults);
        System.out.println("The intersection of both arrays: " + intersectionResults);
        System.out.println("The complement of subset A: " + complementResults);
    }
}
