import java.util.Scanner;

public class RepeatedSubStringPattern {
    public static void  main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string:");
        String str=sc.next();
        boolean ans1=repeatedSubstringPattern1(str);
        System.out.println(ans1);
        boolean ans2=repeatedSubstringPattern2(str);
        System.out.println(ans2);
        boolean ans3=repeatedSubstringPattern3(str);
        System.out.println(ans3);
    }

    //soln-1
    private static boolean repeatedSubstringPattern1(String str) {
        String doubleString=str+str;
        return doubleString.substring(1,doubleString.length()-1).contains(str);
    }

    //soln-2
    public static boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        int[] lps = new int[n];
        for (int i = 1, len = 0; i < n;) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        
        int len = lps[n - 1];
        return len > 0 && n % (n - len) == 0;
    }
    

    //soln-3
    public static boolean repeatedSubstringPattern3(String s) {
        int n = s.length();
        
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                
                for (int j = 0; j < n / i; j++) {
                    sb.append(sub);
                }
                
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}