import java.util.Scanner;

public class RepeatedString {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter String:");
        String s=sc.next();

        System.out.println("Enter n:");
        int n=sc.nextInt();

        long res1=repeatedString1(s,n);
        System.err.println(res1);

        long res2=repeatedString2(s,n);
        System.err.println(res2);

        long res3=repeatedString3(s,n);
        System.err.println(res3);

        
    }

    private static long repeatedString1(String s, int n) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < n) {
            sb.append(s);
        }
        String repeated = sb.substring(0, (int) n);
        return repeated.chars().filter(c -> c == 'a').count();
    }

    public static long repeatedString2(String s, long n) {
        long countInFullString = s.chars().filter(c -> c == 'a').count();
        long fullRepetitions = n / s.length();
        long remainingChars = n % s.length();

        long totalAs = fullRepetitions * countInFullString;
        for (int i = 0; i < remainingChars; i++) {
            if (s.charAt(i) == 'a') {
                totalAs++;
            }
        }

        return totalAs;
    }

    public static long repeatedString3(String s, long n) {
        long countInFullString = s.chars().filter(c -> c == 'a').count();
        long fullRepetitions = n / s.length();
        long remainingChars = n % s.length();

        long totalAs = fullRepetitions * countInFullString;
        totalAs += s.substring(0, (int) remainingChars).chars().filter(c -> c == 'a').count();

        return totalAs;
    }
}
