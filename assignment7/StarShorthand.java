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
        for (int i=0; i < s.length()-1; i++) {
            if ( s.charAt(i) == s.charAt(i+1)) 
                count++;
            System.out.println(count);
        }
        return s;
    }
}