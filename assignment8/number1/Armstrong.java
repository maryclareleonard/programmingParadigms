import java.lang.Math;

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
    int denom;
    int thDigit;
    int currSum;
    int indexArmstrongs = 0;


    public void getArmstrongs() {
        
        for (int i = this.start; i <= this.end; i++) {
            currSum = 0;
            //System.out.println();
            numLength = String.valueOf(i).length();
            //System.out.println("Length of num: " + numLength);
            for (int x = 0; x < numLength; x++) {
                if (x == 0) { denom = 1;}
                else        { denom = (int)(Math.pow(10,x)); 
                    //System.out.println("Denom: " + denom);
                }
                thDigit = (i/(denom))%10; 
                //System.out.println("Num's " + x + "th digit: " + thDigit);
                currSum = addToSum(currSum, thDigit, numLength);
            }
            if (currSum == i) {
                armstrongNumbers[indexArmstrongs] = i;
                indexArmstrongs++;
            }
            //System.out.println("Sum: " + currSum);
        }
        System.out.println("Here are the Armstrongs: ");
        for (int pos = 0; pos < indexArmstrongs; pos++ ){
            System.out.println(armstrongNumbers[pos]);
        }
        //return armstrongNumbers;
    }

    public int addToSum(int currSum, int digit, int length) {
        //System.out.println("Digit: " + digit);
        //System.out.println("Length: " + length);
        //System.out.println("CurrSum: " + currSum ); 
        return currSum + (int)(Math.pow(digit,length));
    }
    

}