import java.util.concurrent.BlockingQueue;

public class Filter3 implements Filter{
    Filter prevFilter;
    BlockingQueue<String> myQueueIncoming;
    BlockingQueue<String> myQueueOutgoing;
    String [] words;
    int i;

    public Filter3 (Filter filter2, BlockingQueue<String> myQueueOutgoing ) {
        this.prevFilter = filter2;
        this.myQueueIncoming = this.prevFilter.getQueue();
        this.myQueueOutgoing = myQueueOutgoing;
    }

    public BlockingQueue<String> getQueue() {
        return myQueueOutgoing;
    }
    //must implement the inherited abstract method Runnable.run()
    @Override
    public void run() {
        try {
            String line = myQueueIncoming.take(); //read line to queue if space
            while (line != null) {
                if (line == "EOF") {  //end of file
                    try {
                        myQueueOutgoing.put("EOF"); 
                    } catch (InterruptedException ie0 ){
                        System.out.println("An error occured: " + ie0);
                        ie0.printStackTrace(); 
                    }
                    break; //exit while loop 
                }
                words = splitTextIntoWords(line);
                i = 0;
                try {
                    while (i < words.length) {
                        //System.out.println("Word: " + words[i]);
                        myQueueOutgoing.put(words[i]); //add line to queue if space
                        //System.out.println("i: " + i);
                        i++;
                    }
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

    String [] splitTextIntoWords(String line) {
        String[] splited = line.split("\\s+");
        //System.out.println("Splited: " + splited[0] + "_" + splited[1]);
        return splited;
    }
}
