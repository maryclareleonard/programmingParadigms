import java.util.concurrent.BlockingQueue;

public class Filter4 implements Filter{
    Filter prevFilter;
    BlockingQueue<String> myQueueIncoming;
    BlockingQueue<String> myQueueOutgoing;
    String [] words;
    int count;

    public Filter4 (Filter filter3, BlockingQueue<String> myQueueIncoming) {
        this.prevFilter = filter3;
        this.myQueueIncoming = myQueueIncoming;
        //this.myQueueOutgoing = myQueueOutgoing;
    }

    //must implement the inherited abstract method Runnable.run()
    @Override
    public void run() {
        try {
            String word = myQueueIncoming.take(); //read line to queue if space
            while (word != null) {
                System.out.println("Final Stage: " + word);
                System.out.println("Count: " + count);
                count++;
                /*try {
                    while (i < words.length -1 ) {
                        System.out.println("Word: " + words[i]);
                        myQueueOutgoing.put(words[i]); //add line to queue if space
                        System.out.println("i: " + i);
                        i++;
                    }
                } catch (InterruptedException ie0 ){
                    System.out.println("An error occured: " + ie0);
                    ie0.printStackTrace(); 
                }*/
                word = myQueueIncoming.take();
            }
        } catch (InterruptedException ie0 ){
            System.out.println("An error occured: " + ie0);
            ie0.printStackTrace(); 
        }
    }
}
