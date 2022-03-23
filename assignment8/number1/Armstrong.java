public class Armstrong {
    int start;
    int end;
    int[] armstrongNumbers;

    public Armstrong(int start, int end){
        this.start = start;
        this.end = end;
        this.armstrongNumbers = new int[end];
    }

    int numLength;

    public int[] getArmstrongs() {
        for (int i = this.start; i <= this.end; i++) {
            System.out.println();
            numLength = String.valueOf(i).length();
            System.out.println("Length of num: " + numLength);
            for (int x = 0; x < numLength; x++) {
                System.out.println("Num's " + x + "th digit: " + i%(10*(x+1)) );
            }
            System.out.println();
        }
        armstrongNumbers[0] = 140;
        armstrongNumbers[1] = 200;
        return armstrongNumbers;
    }

}