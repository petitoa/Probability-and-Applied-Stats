package BirthdayChecker;

/**
 * A test class for evaluating and testing the functionality of the {@link Person} class to solve the birthday problem.
 *
 * @author petitoa
 */
public class TestPerson {
    public static void main(String[] args) {
        Person test = new Person();

        // First parameter is number of people second parameter is number of iterations
        double birthdayProblem = test.birthdayProblem(20, 10000);

        System.out.println("The probability of 2 people sharing a birthday in a class is: " + birthdayProblem + "%");


    }
}