import java.util.Scanner;

public class FunnyString {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          System.out.println("Enter string:");
          String str=scanner.next();
        String res1=funnyString1(str);
        System.out.println(res1);
        String res2=funnyString2(str);
        System.out.println(res2);
        String res3=funnyString3(str);
        System.out.println(res3);
    }
    public static String funnyString1(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++) {
            int diffOriginal = Math.abs(s.charAt(i) - s.charAt(i - 1));
            int diffReversed = Math.abs(s.charAt(n - i) - s.charAt(n - i - 1));
            if (diffOriginal != diffReversed) {
                return "Not Funny";
            }
        }
        return "Funny";
    }

    public static String funnyString2(String s) {
        int n = s.length();
        for (int i = 1, j = n - 2; i < n; i++, j--) {
            int diffOriginal = Math.abs(s.charAt(i) - s.charAt(i - 1));
            int diffReversed = Math.abs(s.charAt(j) - s.charAt(j + 1));
            if (diffOriginal != diffReversed) {
                return "Not Funny";
            }
        }
        return "Funny";
    }

    public static String funnyString3(String s) {
        int n = s.length();
        int[] originalDiffs = new int[n - 1];
        int[] reversedDiffs = new int[n - 1];

        for (int i = 1; i < n; i++) {
            originalDiffs[i - 1] = Math.abs(s.charAt(i) - s.charAt(i - 1));
            reversedDiffs[i - 1] = Math.abs(s.charAt(n - i) - s.charAt(n - i - 1));
        }

        for (int i = 0; i < n - 1; i++) {
            if (originalDiffs[i] != reversedDiffs[i]) {
                return "Not Funny";
            }
        }

        return "Funny";
    }
}
