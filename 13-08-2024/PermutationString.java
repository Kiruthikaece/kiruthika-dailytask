import java.util.Arrays;
import java.util.Scanner;

public class PermutationString {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter String1:");
	String str1=sc.next();

    System.out.println("Enter String2:");
	String str2=sc.next();

	boolean res1=permutation1(str1,str2);
    System.out.println(res1);
	boolean res2=permutation2(str1,str2);
    System.out.println(res2);
   
}

public static  boolean permutation1(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (Arrays.equals(s1Freq, s2Freq)) {
                return true;
            }
            s2Freq[s2.charAt(i + s1.length()) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']--;
        }
        
        return Arrays.equals(s1Freq, s2Freq);
    }

    public static boolean permutation2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String sortedS1 = new String(s1Arr);

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            char[] s2SubArr = s2.substring(i, i + s1.length()).toCharArray();
            Arrays.sort(s2SubArr);
            if (Arrays.equals(s1Arr, s2SubArr)) {
                return true;
            }
        }

        return false;
    }
}
