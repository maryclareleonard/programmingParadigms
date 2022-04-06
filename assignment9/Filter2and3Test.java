import org.junit.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.*;

public class Filter2and3Test {
	@Test 
	public void removeNumbers () {
		BlockingQueue<String> myQueue1 =  new LinkedBlockingQueue<> (10);
		BlockingQueue<String> myQueue2= new LinkedBlockingQueue<> (10);
		String file = "twentyfiveLines.txt";
		Filter1 filter1 = new Filter1(file, myQueue1); //create a instance of first filter
		Filter2 filter2= new Filter2(filter1,myQueue2);
		System.out.println("Testing Removing Numbers with Filter2 removeNonAlpha Function.");
		System.out.println("Pass 'Hi 4' to Filter 2 removeNonAlpha function.");
		String testOne = filter2.removeNonAlpha("Hi 4");
		Assert.assertEquals(testOne,"Hi ");
		System.out.println("Should return 'Hi ' from Filter 2 removeNonAlpha function.");
		System.out.println();
	}
	
	@Test 
    public void removeSpecialChar () {
	    BlockingQueue<String> myQueue1 =  new LinkedBlockingQueue<> (10);
		BlockingQueue<String> myQueue2= new LinkedBlockingQueue<> (10);
		String file = "twentyfiveLines.txt";
		Filter1 filter1 = new Filter1(file, myQueue1); //create a instance of first filter
		Filter2 filter2= new Filter2(filter1,myQueue2);
		System.out.println("Testing Removing Special Char with Filter2 removeNonAlpha Function.");
		System.out.println("Pass 'Hi-Jim' to Filter 2 removeNonAlpha function.");
		String testOne = filter2.removeNonAlpha("Hi-Jim");
		Assert.assertEquals(testOne,"HiJim");
		System.out.println("Should return 'HiJim' from Filter 2 removeNonAlpha function.");
		System.out.println();
	}

	@Test 
    public void removeSpecialCharAndNum () {
	    BlockingQueue<String> myQueue1 =  new LinkedBlockingQueue<> (10);
		BlockingQueue<String> myQueue2= new LinkedBlockingQueue<> (10);
		String file = "twentyfiveLines.txt";
		Filter1 filter1 = new Filter1(file, myQueue1); //create a instance of first filter
		Filter2 filter2= new Filter2(filter1,myQueue2);
		System.out.println("Testing Removing Special Char and Numberswith Filter2 removeNonAlpha Function.");
		System.out.println("Pass 'Hi-Jim 4' to Filter 2 removeNonAlpha function.");
		String testOne = filter2.removeNonAlpha("Hi-Jim 4");
		Assert.assertEquals(testOne,"HiJim ");
		System.out.println("Should return 'HiJim ' from Filter 2 removeNonAlpha function.");
		System.out.println();
	}

	@Test 
    public void splitTextTest () {
		System.out.println("Testing line text split Filter3 splitTextIntoWords Function.");
        BlockingQueue<String> myQueue1= new LinkedBlockingQueue<> (10);
        BlockingQueue<String> myQueue2= new LinkedBlockingQueue<> (10);
        BlockingQueue<String> myQueue3= new LinkedBlockingQueue<> (10);

        String file = "twentyfiveLines.txt";
        Filter1 filter1 = new Filter1(file, myQueue1); //create a instance of first filter
        Filter2 filter2= new Filter2(filter1,myQueue2);
		Filter3 filter3 = new Filter3(filter2,myQueue3);
		System.out.println("Pass 'Hi my name is Maryclare' to Filter 3 splitTextIntoWords function.");
        String [] testOne = filter3.splitTextIntoWords("Hi my name is Maryclare.");
		System.out.println("Should return 'my' from Filter 3 splitTextIntoWords function.");
        Assert.assertEquals(testOne[1],"my");
		System.out.println();
    }

	@Test 
    public void splitTextTestExtraSpace () {
		System.out.println("Testing line text split Filter3 splitTextIntoWords Function with EXTRA spaces.");
        BlockingQueue<String> myQueue1= new LinkedBlockingQueue<> (10);
        BlockingQueue<String> myQueue2= new LinkedBlockingQueue<> (10);
        BlockingQueue<String> myQueue3= new LinkedBlockingQueue<> (20);

        String file = "twentyfiveLines.txt";
        Filter1 filter1 = new Filter1(file, myQueue1); //create a instance of first filter
        Filter2 filter2= new Filter2(filter1,myQueue2);
		Filter3 filter3 = new Filter3(filter2,myQueue3);
		System.out.println("Pass 'Hi     my name is Maryclare' to Filter 3 splitTextIntoWords function.");
        String [] testOne = filter3.splitTextIntoWords("Hi     my name is Maryclare.");
		System.out.println("Should return 'my' from Filter 3 splitTextIntoWords function.");
        Assert.assertEquals(testOne[1],"my");
		System.out.println();
    }

}
