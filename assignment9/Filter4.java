import java.util.concurrent.BlockingQueue;
import java.util.*;

public class Filter4 implements Filter{
    Filter prevFilter;
    BlockingQueue<String> myQueueIncoming;
    BlockingQueue<String> myQueueOutgoing;
    HashMap<String, Integer>  wordCountMap;
    String [] words;
    int count;

    public Filter4 (HashMap<String, Integer>  wordCountMap, Filter filter3) {
        this.prevFilter = filter3;
        this.myQueueIncoming = this.prevFilter.getQueue();
        this.wordCountMap = wordCountMap;
    }
    
    //not used but for completeness
    public BlockingQueue<String> getQueue() {
        return myQueueOutgoing;
    }

    //must implement the inherited abstract method Runnable.run()
    @Override
    public void run() {  
        try {
            String word = myQueueIncoming.take(); //read line to queue if space
            while (word != null) {
                if (word == "EOF") {  //end of file
                    break; //exit while loop 
                }
                if (wordCountMap.containsKey(word)) {
                    wordCountMap.put(word, wordCountMap.get(word) + 1);
                }
                else {
                    wordCountMap.put(word, 1); 
                }
                word = myQueueIncoming.take();
            }
            printHashMap();
        } catch (InterruptedException ie0 ){
            System.out.println("An error occured: " + ie0);
            ie0.printStackTrace(); 
        }
    }

    public void printHashMap() {
        for (String key: wordCountMap.keySet()) {
            System.out.println(key + " occurs " + wordCountMap.get(key) + " times.");
        }
    }
}
