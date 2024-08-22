import java.util.Scanner;

public class MaxRepeatingWord {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter sequence");
        String s=sc.next();
        System.out.println("Enter word");
        String w=sc.next();
        int res1=findMaxRepeatingWord1(s,w);
        System.out.println(res1);
        int res2=findMaxRepeatingWord2(s,w);
        System.out.println(res2);
    }

    private static int findMaxRepeatingWord1(String sequence, String word) {
        StringBuilder s=new StringBuilder(word);
      int c=0;

      while(sequence.contains(s)) {
        c++;
      System.out.println(c+"cc.."+s.toString());
      s.append(word);
      }
      System.out.println(c+"cc.."+s.toString());

      return c;
    }

    public static int findMaxRepeatingWord2(String sequence, String word) {
      int n = sequence.length();
      int m = word.length();
      int[] dp = new int[n + 1];
      int maxRepeat = 0;

      for (int i = m; i <= n; i++) {
          if (sequence.substring(i - m, i).equals(word)) {
              dp[i] = dp[i - m] + 1;
              maxRepeat = Math.max(maxRepeat, dp[i]);
          }
      }

      return maxRepeat;
  }
}
