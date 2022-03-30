public class Main {
    public static void main(String[] args) {
        Filter filter1 = new Filter1(); //create a instance of first filter
        Runnable runnable1 = filter1; //create a runnable instance(
        Thread thread = new Thread(runnable1); //pop it into a thread
        thread.start(); //start the thread
    }
}
