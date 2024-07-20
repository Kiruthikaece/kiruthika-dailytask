
import java.util.*;

public class ValidAnagram {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("String 1:");
        String s=sc.next();
        System.out.println("String 2:");
        String t=sc.next();
        System.err.println(isValidAnagram1(s,t));
        System.err.println(isValidAnagram2(s,t));
    }

    private static boolean isValidAnagram1(String s, String t) {
        char ch[]=s.toCharArray();
        char ch2[]=t.toCharArray();
        Arrays.sort(ch);
        Arrays.sort(ch2);

        s=new String(ch);
        t=new String(ch2);

        return s.equals(t);
    }

    private static boolean isValidAnagram2(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();

        for(char ch:s.toCharArray())
        map.put(ch,map.getOrDefault(ch, 0)+1);


        for(char ch:t.toCharArray())
        map.put(ch,map.getOrDefault(ch, 0)-1);

        for(int val:map.values()) 
        if(val!=0)
        return false;

        return true;
    }


}
