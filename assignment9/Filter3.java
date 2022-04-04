import java.util.concurrent.BlockingQueue;

public class Filter3 implements Filter{
    Filter prevFilter;
    BlockingQueue<String> myQueueIncoming;
    BlockingQueue<String> myQueueOutgoing;
    String [] words;
    int i;

    public Filter3 (Filter filter2, BlockingQueue<String> myQueueIncoming, BlockingQueue<String> myQueueOutgoing ) {
        this.prevFilter = filter2;
        this.myQueueIncoming = myQueueIncoming;
        this.myQueueOutgoing = myQueueOutgoing;
    }

    //must implement the inherited abstract method Runnable.run()
    @Override
    public void run() {
        try {
            String line = myQueueIncoming.take(); //read line to queue if space
            while (line != null) {
                words = splitTextIntoWords(line);
                i = 0;
                try {
                    while (i < words.length -1 ) {
                        System.out.println("Word: " + words[i]);
                        myQueueOutgoing.put(words[i]); //add line to queue if space
                        System.out.println("i: " + i);
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
