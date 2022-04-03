import java.io.BufferedReader; //import class to handle errors
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Filter1 implements Filter{

    BlockingQueue<String> myQueue;

    public Filter1(BlockingQueue<String> myQueueIncoming) {
        this.myQueue = myQueueIncoming;
    }
    //must implement the inherited abstract method Runnable.run()
    @Override
    public void run() {
        try {
            //buffered reader is synchronized (thread safe) - scanner is not
            BufferedReader reader = new BufferedReader(new FileReader("fileLong.txt"));
            try {
                String line = reader.readLine();
                while (line != null) { 
                    System.out.println(line);
                    try {
                        myQueue.put(line); //add line to queue if space
                    } catch (InterruptedException ie0 ){
                        System.out.println("An error occured: " + ie0);
                        ie0.printStackTrace(); 
                    }
                    line = reader.readLine();
                }
            } catch (IOException i) {
                System.out.println("An error occured: " + i);
                i.printStackTrace();
            }
            try { reader.close(); } catch (IOException i2) {
                System.out.println("An error occured: " + i2);
                i2.printStackTrace(); 
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occured: " + e);
            e.printStackTrace();
        }
    }

}
