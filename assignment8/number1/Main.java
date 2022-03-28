public class Main {
    public static void main(String[] args) {
        System.out.println("Number 1: Armstrong Numbers");
        Armstrong test1 = new Armstrong(0,2000);
        test1.getArmstrongs();
        System.out.println();
        System.out.println();

        System.out.println("Number 2: FizzBuzz");
        FizzBuzz test2 = new FizzBuzz(1,100);
        test2.printLogic();
    } 

}
