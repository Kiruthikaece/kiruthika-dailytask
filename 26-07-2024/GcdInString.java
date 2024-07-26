import java.util.Scanner;

public class GcdInString {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter String1:");
	String s1=sc.next();
    System.out.println("Enter String2:");
	String s2=sc.next();
	String res1=gcdOfString1(s1,s2);
    System.err.println(res1);
    String res2=gcdOfString2(s1,s2);
    System.err.println(res2);
    String res3=gcdOfString3(s1,s2);
    System.err.println(res3);
}

        public static String gcdOfString1(String str1, String str2) {
            if (!(str1 + str2).equals(str2 + str1)) {
                return "";
            }
            int gcdLength = gcd(str1.length(), str2.length());
            return str1.substring(0, gcdLength);
        }
    
        private static int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    

        public static String gcdOfString2(String str1, String str2) {
            int len1 = str1.length();
            int len2 = str2.length();
            int minLength = Math.min(len1, len2);
            
            for (int i = minLength; i >= 1; i--) {
                if (len1 % i == 0 && len2 % i == 0) {
                    String candidate = str1.substring(0, i);
                    if (isDivisible(str1, candidate) && isDivisible(str2, candidate)) {
                        return candidate;
                    }
                }
            }
            return "";
        }
    
        private static boolean isDivisible(String s, String sub) {
            int len = s.length();
            int subLen = sub.length();
            if (len % subLen != 0) return false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len / subLen; i++) {
                sb.append(sub);
            }
            return s.equals(sb.toString());
        }
    
        public static String gcdOfString3(String str1, String str2) {
            if (str1.equals(str2)) {
                return str1;
            }
            if (str1.length() > str2.length()) {
                return gcdOfString3(str1.substring(str2.length()), str2);
            } else {
                return gcdOfString3(str1, str2.substring(str1.length()));
            }
        }
    
}