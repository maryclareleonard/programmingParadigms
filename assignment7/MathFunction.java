public class MathFunction {
    public static void main(String[] args) {
        System.out.println("Hello World");

        System.out.println("calculator(2,'+',2)");
        System.out.println(calculator(2,'+',2));

        System.out.println("calculator(2,'*',2)");
        System.out.println(calculator(2,'*',2));

        System.out.println("calculator(4,'/',2)");
        System.out.println(calculator(4,'/',2));

        System.out.println("calculator(4,'-',2)");
        System.out.println(calculator(4,'-',2));

        System.out.println("calculator(5,'/',2)");
        System.out.println(calculator(5,'/',2));
    }
    public static int calculator(int x, char operand, int y){
        if (operand == '+')
            return x + y;
        else if (operand == '-')
            return x - y;
        else if (operand == '*')
            return x * y;
        else if (operand == '/')
            return x / y;
        else
            System.out.println("Invalid Operand");
            return -1 ;
    }

}