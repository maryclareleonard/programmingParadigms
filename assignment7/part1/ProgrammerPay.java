package part1;
public class ProgrammerPay {
    public static void main(String[] args) {
        System.out.println("payDiff(147,33,526)");
        System.out.println(payDiff(147,33,526));

        System.out.println("payDiff(147,526,33)");
        System.out.println(payDiff(147,526,33));

        System.out.println("payDiff(33,72,74)");
        System.out.println(payDiff(33,72,74));

        System.out.println("payDiff(74,72,33)");
        System.out.println(payDiff(74,72,33));

        System.out.println("payDiff(147,147,526)");
        System.out.println(payDiff(147,147,526));

        System.out.println("payDiff(526,526,526)");
        System.out.println(payDiff(526,526,526));

        System.out.println("payDiff(1,5,9)");
        System.out.println(payDiff(1,5,9));

    }
    public static int payDiff(int x, int y, int z){
        if ( x >= y && x >= z)
            if (y >= z)
                return x - z;
            else 
                return x - y;
        else if ( y >= x && y >= z)
            if ( x >= z)
                return y - z;
            else 
                return y - x;
        else if ( z >= x && z >= y)
            if (x >= y)
                return z - y;
            else
                return z - x;
        else 
            System.out.println("ERROR");
            return -1;
    }

}