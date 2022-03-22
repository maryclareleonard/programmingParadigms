package part1;
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

        for (int i=0; i < s.length()-1; i++) {
            if ( s.charAt(i) == s.charAt(i+1)) {
                count = count + 1;
            }
            else {
                if (count > 0) {
                    secondPos = i-count;
                    first = s.substring(0,secondPos);
                    second = s.charAt(i) + "*" + Integer.toString(count+1);
                    third = s.substring(count+2,s.length());
                    s = first + second + third; 
                    System.out.println("s: " + s);
                    count = 0;
                }
            }
        }

        if (count > 0) {
                System.out.println("here");
                System.out.println(count);
                secondPos = s.length()-(count+1);
                first = s.substring(0,secondPos);
                System.out.println(first);
                second = s.charAt(secondPos) + "*" + Integer.toString(count+1);
                System.out.println(second);
                s = first + second; 
        }
        return s;
    }
}