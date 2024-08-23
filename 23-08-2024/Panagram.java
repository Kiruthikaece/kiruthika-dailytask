import java.util.HashSet;
import java.util.Set;

public class Panagram {
    public static void main(String[] args) {
        String s="We promptly judged antique ivory buckles for the prize";
        String res1=isPanagram1(s);
        System.out.println(res1);

        String res2=isPanagram2(s);
        System.out.println(res2);
    }

    private static String isPanagram1(String s) {
        boolean ispresent=true;
      s=s.toLowerCase();
            for(char ch='a';ch<='z';ch++) {
                if(!s.contains(String.valueOf(ch))) {
                    ispresent=false;
                    break;
                }
            }
            
            if(ispresent)  
            return "pangram";
            else
            return "not pangram";
    }

    public static String isPanagram2(String s) {
        Set<Character> letters = new HashSet<>();
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.add(c);
            }
        }
        return letters.size() == 26 ? "pangram" : "not pangram";
    }
}
