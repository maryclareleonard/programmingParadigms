public class Main {
    public static void main(String[] args) {
        Armstrong test1 = new Armstrong(0,10);

        int [] armstrongs1 = test1.getArmstrongs();
        System.out.println("Here are the Armstrongs: ");
        for (int i=0; i < armstrongs1.length; i++) {
            if (armstrongs1[i] != 0) {
                System.out.println(armstrongs1[i]);
            }
        }
    } 

}
