import org.junit.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.*;

public class Filter2Test {
    @Test 
    public void removeNumbers () {
        BlockingQueue<String> myQueue1 =  new LinkedBlockingQueue<> (10);
        BlockingQueue<String> myQueue2= new LinkedBlockingQueue<> (10);
        String file = "twentyfiveLines.txt";
        Filter filter1 = new Filter1(file, myQueue1); //create a instance of first filter
        Filter2 filter2= new Filter2(filter1,myQueue2);
        String testOne = filter2.removeNonAlpha("Hi 4");
        Assert.assertEquals(testOne,"Hi");
    }
}