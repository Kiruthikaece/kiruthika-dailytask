import java.util.HashMap;
import java.util.Scanner;

public class findDifference {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string1:");
        String str1=sc.next();
        System.out.println("Enter string2:");
        String str2=sc.next();
        char res1=findDifference1(str1,str2);
        System.out.println(res1);
        char res2=findDifference2(str1,str2);
        System.out.println(res2);
        char res3=findDifference3(str1,str2);
        System.out.println(res3);
        
    }

    //soln-1
    private static char findDifference2(String s, String t) {
        
            int[] count = new int[26];
            
            for (char c : t.toCharArray()) 
                count[c - 'a']++;
            
            
            for (char c : s.toCharArray()) 
                count[c - 'a']--;
        
            
            for (int i = 0; i < 26; i++) 
                if (count[i] > 0) {
                    return (char) (i + 'a');
                }
            
            
            return '\0';
        }
    
    //soln-2

    private static char findDifference1(String s, String t) {
        int x = 0;
        
        for (char i : s.toCharArray())
            x = x ^ i;
        
        for (char i : t.toCharArray())
            x = x ^ i;
        
        return (char) x;
    }

    //soln-3

    public static char findDifference3(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (char c : s.toCharArray()) {
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        
        for (char c : map.keySet()) {
            return c;
        }
        
        return '\0';
    }
}
