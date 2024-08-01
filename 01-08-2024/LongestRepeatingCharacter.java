import java.util.Scanner;

public class LongestRepeatingCharacter {
  
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter s:");
        String s=sc.next();
        System.out.println("Enter k:");
        int k=sc.nextInt();

        int res1=characterReplacement1(s,k);
        System.out.println(res1);
    }
   

    

    public static int characterReplacement1(String s, int k) {
        int ans = 0;
        int n = s.length();
        for (char c = 'A'; c <= 'Z'; c++) {
            int i = 0, j = 0, replaced = 0;
            while (j < n) {
                if (s.charAt(j) == c) {
                    j++;
                } else if (replaced < k) {
                    j++;
                    replaced++;
                } else if (s.charAt(i) == c) {
                    i++;
                } else {
                    i++;
                    replaced--;
                }
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }

    public  static int characterReplacement2(String s, int k) {
        int left = 0;
        int maxFreq = 0;
        int count = 0;
        int[] freq = new int[26];
        for (int right = 0; right < s.length(); ++right) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
            while (right - left + 1 - maxFreq > k) {
                freq[s.charAt(left++) - 'A']--;
            }
            count = Math.max(count, right - left + 1);
        }
        return count;
    }
}
