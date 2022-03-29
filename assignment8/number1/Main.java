import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Number 1: Armstrong Numbers");
        Armstrong test1 = new Armstrong(0,2000);
        test1.getArmstrongs();
        System.out.println();
        System.out.println();
        printBreak();

        System.out.println("Number 2: FizzBuzz");
        FizzBuzz test2 = new FizzBuzz(1,100);
        test2.printLogic();
        printBreak();

        System.out.println("Number 3: DogIntelligence");
        readFile("dog.text");

    } 
    public static void printBreak() {
        System.out.println();
        System.out.println(); 
    }

    public static void readFile(String txt) {
        File file = new File(txt); //create file instance
        FileReader fr = new FileReader(file); //reads file 
        BufferedReader br = new BufferedReader(fr); //create buffering character input stream
        StringBuffer sb = new StringBuffer(); //constructs string
        String line; 

    }
}
