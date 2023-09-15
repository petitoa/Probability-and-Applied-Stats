import java.util.Random;

//determine probability of any 2 people sharing a birthday in the class
//20 people
// learn git workflow 1 page single space essay off atlassian
// clone someone else's repo and commit code to their repo print a screen shot of the change log showing the changes you made to someone else's repository.
public class Person {
    int id;
    int birthday;


    public Person(int id, int birthday) {
        this.id = id;
        this.birthday = birthday;

    }


    public int setBirthday(int id){
        Random random = new Random();
        for(int people : id){
            this.birthday = random.nextInt(365);
        }
    }



}
