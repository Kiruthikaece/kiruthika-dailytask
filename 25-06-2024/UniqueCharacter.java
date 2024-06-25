import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueCharacter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String:");
        String n=sc.next();
        int ans1=findUniqueCharacter1(n);
        System.out.println("Unique character position:"+ans1);
        int ans2=findUniqueCharacter2(n);
        System.out.println("Unique character position:"+ans2);
        int ans3=findUniqueCharacter3(n);
        System.out.println("Unique character position:"+ans3);
    }

    //soln-1
    private static int findUniqueCharacter1(String s) {
        int[] letter=new int[26];
        for(int i=0;i<s.length();i++)
        letter[s.charAt(i)-'a']++;

        for(int i=0;i<s.length();i++)
        if(letter[s.charAt(i)-'a']==1)
        return i;

        return -1;
    }

    //soln-2
    public static int findUniqueCharacter2(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
  
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


    //soln-3
    public static int findUniqueCharacter3(String s) {
      
        for(int i=0;i<s.length();i++) {
            int count=1;
            for(int j=0;j<s.length();j++) {
                if(s.charAt(i)==s.charAt(j) &&j!=i)
                count++;
            }
            if(count==1)
            return i;
        }

        return -1;
    }
}
