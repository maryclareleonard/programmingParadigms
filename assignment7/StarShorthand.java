public class StarShorthand {
    public static void main(String[] args) {
        System.out.println("toStarShorthand(abbccc)");
        System.out.println(toStarShorthand("abbccc"));

        System.out.println("toStarShorthand(77777geff)");
        System.out.println(toStarShorthand("77777geff"));

        System.out.println("toStarShorthand(abc)");
        System.out.println(toStarShorthand("abc"));

        System.out.println("toStarShorthand()");
        System.out.println(toStarShorthand("")); 
    }
    public static String toStarShorthand(String s){

        int count = 0;
        String first;
        String second;
        String third;
        int secondPos;

        for (int i=0; i <= s.length()-2; i++) {
            if ( s.charAt(i) == s.charAt(i+1)) {
                count = count + 1;
            }
            else {
                if (count > 0) {
                    secondPos = i-count;
                    first = s.substring(0,secondPos);
                    //System.out.println(Integer.toString(count+1));
                    second = s.charAt(i) + "*" + Integer.toString(count+1);
                    //System.out.println(second);
                    third = s.substring(i+1,s.length()-1);
                    //System.out.println(third);
                    s = first + second + third; 
                    //System.out.println(s);
                    count = 0;
                }
            }
        }
        //to get repetition at end
        if (count > 0) {
            int i = s.length()-2;
            secondPos = i;
            first = s.substring(0,secondPos);
            second = s.charAt(i) + "*" + Integer.toString(count+2);
            third = s.substring(i+1,s.length()-1);
            s = first + second + third; 
            //System.out.println(m); 
        }
        return s;
    }
}