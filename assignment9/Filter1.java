import java.io.BufferedReader; //import class to handle errors
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.stream.Collectors; //implement various reduction operations

public class Filter1 implements Filter{

    public Filter1() {}
    //must implement the inherited abstract method Runnable.run()
    @Override
    public void run() {
        try {
            //buffered reader is synchronized (thread safe) - scanner is not
            BufferedReader input = new BufferedReader(new FileReader("file.txt"));
            System.out.println(readAllLinesWithStream(input));

        }
        catch (FileNotFoundException e) {
            System.out.println("An error occured: " + e);
            e.printStackTrace();
        }
        
    }

    public String readAllLinesWithStream(BufferedReader reader) {
        System.out.println("here");
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }
}
