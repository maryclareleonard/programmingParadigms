import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class Pipeline{

    BlockingQueue<String> myQueue1;
    BlockingQueue<String> myQueue2;
    BlockingQueue<String> myQueue3;
    BlockingQueue<String> myQueue4;
    String file;

    public Pipeline (String txt) {
        this.file = txt;
        this.myQueue1 = new LinkedBlockingQueue<> (10);
        this.myQueue2 = new LinkedBlockingQueue<> (10);
        this.myQueue3 = new LinkedBlockingQueue<> (20);
        this.myQueue4 = new LinkedBlockingQueue<> (10);
    }

    public void startPipeline() {
        //create first filter
        Filter filter1 = new Filter1(file, myQueue1); //create a instance of first filter
        Runnable runnable1 = filter1; //create a runnable instance(
        Thread thread = new Thread(runnable1); //pop it into a thread
        thread.start(); //start the thread

        //create second filter
        Filter filter2 = new Filter2(filter1,myQueue1, myQueue2); //must know of first 1, constructor takes arg
        Runnable runnable2 = filter2;
        Thread thread2 = new Thread(runnable2);
        thread2.start();

        //create third filter
        Filter filter3 = new Filter3(filter2, myQueue2, myQueue3); //must know of first 1, constructor takes arg
        Runnable runnable3 = filter3;
        Thread thread3 = new Thread(runnable3);
        thread3.start();

        //create fourth filter
        Filter filter4 = new Filter4(filter1, myQueue3); //must know of first 1, constructor takes arg
        Runnable runnable4 = filter4;
        Thread thread4 = new Thread(runnable4);
        thread4.start(); 

    }
}
