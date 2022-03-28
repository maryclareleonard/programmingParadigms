public class FizzBuzz {
    int numStart;
    int numEnd;

    public FizzBuzz(int numStart, int numEnd){
        this.numStart = numStart;
        this.numEnd = numEnd;
    } 

    public void printLogic() {
        for (int i = numStart; i <= numEnd; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) { System.out.println("FizzBuzz");}
                else { System.out.println("Fizz");}
            }
            else if (i % 5 == 0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }
    }
}
