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
            if ( s.charAt(i) == s.charAt(i+1)) 
                count++;
            else {
                if (count > 0) {
                    secondPos = i-count;
                    System.out.println(secondPos);
                    first = s.substring(0,secondPos);
                    second = s.charAt(i) + "*" + Integer.toString(count+1);
                    third = s.substring(i+1,s.length()-1);
                    System.out.println(first + second + third);
                    count = 0;
                }
            }
        }
        return s;
    }
}