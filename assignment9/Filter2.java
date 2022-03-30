public class Filter2 implements Filter{

    Filter prevFilter;

    public Filter2 (Filter filter1) {
        this.prevFilter = filter1;
    }
    //must implement the inherited abstract method Runnable.run()
    @Override
    public void run() {

    }
}
