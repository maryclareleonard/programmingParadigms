import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class Main {
    public static void main(String[] args) {

        BlockingQueue<String> myQueueIncoming = new LinkedBlockingQueue<> (10);
        BlockingQueue<String> myQueueOutgoing = new LinkedBlockingQueue<> (10);

        //create first filter
        Filter filter1 = new Filter1(myQueueIncoming); //create a instance of first filter
        Runnable runnable1 = filter1; //create a runnable instance(
        Thread thread = new Thread(runnable1); //pop it into a thread
        thread.start(); //start the thread

        //create second filter
        Filter filter2 = new Filter2(filter1, myQueueIncoming, myQueueOutgoing); //must know of first 1, constructor takes arg
        Runnable runnable2 = filter2;
        Thread thread2 = new Thread(runnable2);
        thread2.start();

    }
}
