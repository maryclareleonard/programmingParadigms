import java.io.*;
import static java.util.Arrays.asList;
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
        printBreak();

        //NUMBER 4
        System.out.println("Number 4: Nested Lists"); 
        List<Object> passedList = a(a(1), 2, a(a(null, null), 5), a(a(a())), a(a(a(6))), 7, null, a());
        System.out.println("Passed List is " + passedList);
        List<Object> finalList = FlattenList.flatten(passedList);
        System.out.println("Flattened (without Nulls): " + finalList);
        printBreak();

        //NUMBER 5
        System.out.println("Number 5: Book Discounts");  
        LinkedList<String> bookList1 = new LinkedList<String>();
        bookList1.add("1st");
        bookList1.add("1st");
        bookList1.add("2nd");
        bookList1.add("2nd");
        bookList1.add("4th");
        bookList1.add("3rd");
        bookList1.add("4th");
        bookList1.add("4th");
        bookList1.add("5th");
        System.out.println("Book List: " + bookList1);
        Books book1 = new Books(bookList1);
        System.out.println("Minimum subtotal is: " + book1.findSubtotal());
        LinkedList<String> bookList2 = new LinkedList<String>();
        bookList2.add("1st");
        bookList2.add("2nd");
        bookList2.add("3rd");
        System.out.println("Book List: " + bookList2);
        Books book2 = new Books(bookList2);
        System.out.println("Minimum subtotal is: " + book2.findSubtotal());
        //System.out.println(bookList1);
        printBreak();

    } 

    private static List<Object> a(Object... a) {
		return asList(a);
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
