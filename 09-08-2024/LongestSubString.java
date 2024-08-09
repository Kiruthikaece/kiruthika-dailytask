import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LongestSubString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.err.println("Enter string:");
        String s=sc.next();
        int res1=longestSubstring1(s);
        System.out.println(res1);
        int res2=longestSubstring2(s);
        System.out.println(res2);
        int res3=longestSubstring3(s);
        System.out.println(res3);
    }

    private static int longestSubstring1(String s) {
        Set<Character> set=new HashSet<>();
        int left=0,max=0;
        for(int i=0;i<s.length();i++) {
            if(!set.contains(s.charAt(i))) {
                set.add((s.charAt(i)));
                max=Math.max(max,i-left+1);
            }else {
                while(set.contains((s.charAt(i)))) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add((s.charAt(i)));

        }
        return max;
    }

    public static int longestSubstring2(String s) {
       Map<Character,Integer> map=new HashMap<>();
       int c=0;
       int maximum_length=0;
       for(int i=0;i<s.length();i++) {
           if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i))>=c)
           c= map.get(s.charAt(i))+1;

           map.put(s.charAt(i),i);
            maximum_length = Math.max(maximum_length, i - c + 1);
       }
       return maximum_length;
    }

     public static int longestSubstring3(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            if (charIndex[s.charAt(right)] >= left) {
                left = charIndex[s.charAt(right)] + 1;
            }
            charIndex[s.charAt(right)] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}