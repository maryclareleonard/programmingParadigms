import java.io.BufferedReader; //import class to handle errors
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class Filter1 implements Filter{

    BlockingQueue<String> myQueue;
    String file;

    public Filter1(String file, BlockingQueue<String> myQueueIncoming) {
        this.file = file;
        this.myQueue = myQueueIncoming;
    }

    public BlockingQueue<String> getQueue() {
        return myQueue;
    }
    //must implement the inherited abstract method Runnable.run()
    @Override
    public void run() {
        try {
            //buffered reader is synchronized (thread safe) - scanner is not
            BufferedReader reader = new BufferedReader(new FileReader(file));
            try {
                String line = reader.readLine();
                while (line != null) { 
                    /*System.out.println("Line: " + line);*/
                    try {
                        myQueue.put(line); //add line to queue if space
                    } catch (InterruptedException ie0 ){
                        System.out.println("An error occured: " + ie0);
                        ie0.printStackTrace(); 
                    }
                    line = reader.readLine();
                }
                //reached end of file so pass secret message
                try {
                    myQueue.put("EOF"); //add line to queue if space
                } catch (InterruptedException ie0 ){
                    System.out.println("An error occured: " + ie0);
                    ie0.printStackTrace(); 
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
