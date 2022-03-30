import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        //NUMBER 1
        System.out.println("Number 1: Armstrong Numbers");
        Armstrong test1 = new Armstrong(0,2000);
        test1.getArmstrongs();
        System.out.println();
        System.out.println();
        printBreak();

        //NUMBER 2
        System.out.println("Number 2: FizzBuzz");
        FizzBuzz test2 = new FizzBuzz(1,100);
        test2.printLogic();
        printBreak();

        //NUMBER 3
        System.out.println("Number 3: DogIntelligence");
        List<String> list1 = readFile("dog.txt");
        //using empty constructor
        System.out.println("Create dogintelEmpty with no argument constructor");
        DogIntelligence dogintellEmpty = new DogIntelligence();
        System.out.println(dogintellEmpty);    
        //creating dogs 
        System.out.println("Create dogintel0");
        DogIntelligence dogintell0 = new DogIntelligence(list1.get(0));
        System.out.println(dogintell0);
        System.out.println("Create dogintel1"); 
        DogIntelligence dogintell1 = new DogIntelligence(list1.get(1));
        System.out.println(dogintell1); 
        //semi-tests for equality
        System.out.println("dogintell0 equal to itself: ");
        System.out.println(dogintell0.equals(dogintell0));
        System.out.println("dogintell1 equal to itself: ");
        System.out.println(dogintell1.equals(dogintell1));
        System.out.println("dogintell0 equal to dogintel1: ");
        System.out.println(dogintell0.equals(dogintell1));
        //hashing
        System.out.println("");
        System.out.println("Hashing Test:");
        System.out.println("DogIntell0: " + dogintell0.hash());
        System.out.println("DogIntell1: " + dogintell1.hash());
        System.out.println("DogIntellEmpty: " + dogintellEmpty.hash()); 

        //NUMBER 4
    } 
    public static void printBreak() {
        System.out.println();
        System.out.println(); 
    }

    public static List<String> readFile(String txt) {
        List<String> list1 = new ArrayList<String>();
        try {
            File text = new File(txt);
            Scanner myReader = new Scanner(text);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);
                list1.add(data);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return list1;
    }

}
