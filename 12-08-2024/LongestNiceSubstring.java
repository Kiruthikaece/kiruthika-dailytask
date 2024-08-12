import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestNiceSubstring {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string:");
        String str=sc.next();
        String s1=longestNiceSubstring1(str);
        System.out.println(s1);

        String s2=longestNiceSubstring2(str);
        System.out.println(s2);
    }

    private static String longestNiceSubstring1(String s) {

       Set<Character> set=new HashSet<>();

         for(char x:s.toCharArray())
         set.add(x);

         for(int i=0;i<s.length();i++) {

            if(set.contains(Character.toUpperCase(s.charAt(i))) && 
               set.contains(Character.toLowerCase(s.charAt(i))))
               continue;

               String s1=longestNiceSubstring1(s.substring(0,i));
               String s2=longestNiceSubstring1(s.substring(i+1));

               return s1.length()>s2.length()?s1:s2;
         }
         return s;
    }

    public static String longestNiceSubstring2(String s) {
        int maxLength = 0;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxLength + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isNice(sub)) {
                    if (sub.length() > maxLength) {
                        maxLength = sub.length();
                        result = sub;
                    }
                }
            }
        }

        return result;
    }

     private static boolean isNice(String sub) {
        for (char c = 'a'; c <= 'z'; c++) {
            char upper = Character.toUpperCase(c);
            char lower = Character.toLowerCase(c);
            if ((sub.indexOf(upper) != -1 && sub.indexOf(lower) == -1) ||
                    (sub.indexOf(upper) == -1 && sub.indexOf(lower) != -1)) {
                return false;
            }
        }
        return true;
    }
}