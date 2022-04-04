import java.util.concurrent.BlockingQueue;
public class Filter2 implements Filter{

    Filter prevFilter;
    BlockingQueue<String> myQueueIncoming;
    BlockingQueue<String> myQueueOutgoing;

    public Filter2 (Filter filter1, BlockingQueue<String> myQueueIncoming, BlockingQueue<String> myQueueOutgoing ) {
        this.prevFilter = filter1;
        this.myQueueIncoming = myQueueIncoming;
        this.myQueueOutgoing = myQueueOutgoing;
    }
    //must implement the inherited abstract method Runnable.run()
    @Override
    public void run() {
        try {
            String line = myQueueIncoming.take(); //read line to queue if space
            while (line != null) {
                line = removeNonAlpha(line);
                line = line.toUpperCase();
                try {
                    myQueueOutgoing.put(line); //add line to queue if space
                    System.out.println(line);
                } catch (InterruptedException ie0 ){
                    System.out.println("An error occured: " + ie0);
                    ie0.printStackTrace(); 
                }
                line = myQueueIncoming.take();
            }
        } catch (InterruptedException ie0 ){
            System.out.println("An error occured: " + ie0);
            ie0.printStackTrace(); 
        }
        
    }

    public String removeNonAlpha( String line) {
        return line.replaceAll("[^A-Za-z]", "");
    }

}
