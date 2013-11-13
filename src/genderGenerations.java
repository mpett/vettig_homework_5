/**
 * Created with IntelliJ IDEA.
 * User: martinpettersson
 * Date: 2013-11-13
 * Time: 20:31
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import java.util.Random;
public class genderGenerations {
    private static ArrayList<Integer> people;
    private final static int MALE = 1;
    private final static int FEMALE = 2;
    private static int GENERATIONS;
    private final static Random r = new Random();
    public static void main(String[] args) {

        if(args.length != 0) {
            GENERATIONS = Integer.parseInt(args[0]);
        } else System.err.println("Missing generations argument");

        people = new ArrayList<Integer>();
        people.add(FEMALE);
        people.add(MALE);
        System.out.println(people.size());

        for(int i = 0; i < GENERATIONS; i++)
            proliferate();

        int numMale = 0;
        int numFemale = 0;
        for(int person : people) {
            if(person == MALE)
                numMale++;
            else if(person == FEMALE)
                numFemale++;
        }

        double femaleQuota = (double) numFemale / people.size();
        double maleQuota = (double) numMale / people.size();

        System.out.println("Result after " + GENERATIONS + " generations:");
        System.out.println("Number of males: " + numMale);
        System.out.println("Number of females: " + numFemale);
        System.out.println("Male quota: " + maleQuota);
        System.out.println("Female quota: " + femaleQuota);
    }

    private static void proliferate() {
        boolean hasNoSon = true;
        int males = 0;
        int females = 0;
        while (hasNoSon) {
            int newPerson = r.nextInt(2) + 1;
            if(newPerson == FEMALE) {
                people.add(FEMALE);
                females++;
            } else if(newPerson == MALE) {
                people.add(MALE);
                males++;
                break;
            }
        }
        System.out.println("Produced " + males + "  males and " + females + " females.");
    }
}
