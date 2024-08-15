import java.util.Scanner;

public class LongestCommonSubString {
      public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
	  System.out.println("Enter string1:");
	  String s1=sc.next();
      System.out.println("Enter string2:");
	  String s2=sc.next();
      int res1=findCommonSubstring1(s1,s2);
      System.out.println(res1);

      int res2=findCommonSubstring2(s1,s2);
      System.out.println(res2);
      }

    private static int findCommonSubstring1(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }

    public static int findCommonSubstring2(String str1, String str2) {
        int maxLength = 0;
        int m = str1.length();
        int n = str2.length();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int length = 0;
                while (i + length < m && j + length < n && str1.charAt(i + length) == str2.charAt(j + length)) {
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
