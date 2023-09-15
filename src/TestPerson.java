public class TestPerson {
    public static void main(String[] args) {
        Person test = new Person();

        // First parameter is number of people second parameter is number of iterations
        double birthdayProblem = test.birthdayProblem(20, 10000);

        System.out.println("The probability of 2 people sharing a birthday in a class is: " + birthdayProblem + "%");


    }
}