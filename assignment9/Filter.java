import java.util.concurrent.BlockingQueue;

interface Filter extends Runnable{
    //note normall a class extends an interface but an 
    //interface implements an interface
    //then concrete filter class just needs to implement Filter
    //indirectly implements Runnable interface as well

    public abstract BlockingQueue<String> getQueue();
}