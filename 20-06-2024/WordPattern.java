import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class WordPattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter pattern:");
        String ptrn=sc.next();
        sc.nextLine();
        System.out.println("Enter word:");
        String word=sc.nextLine();
        boolean res1=isValidPattern1(ptrn,word);
        if(res1)
        System.out.println("is valid");
        else
        System.out.println("is NOT valid");

        boolean res2=isValidPattern2(ptrn,word);
        if(res2)
        System.out.println("is valid");
        else
        System.out.println("is NOT valid");

        boolean res3=isValidPattern3(ptrn,word);
        if(res3)
        System.out.println("is valid");
        else
        System.out.println("is NOT valid");
    }

    //soln-1
    public static boolean  isValidPattern1(String ptrn, String word) {
       Map<Character,String> map=new HashMap<>();
       String[] arr=word.split(" ");
       if(ptrn.length()!=arr.length)
        return false;
        for(int i=0;i<ptrn.length();i++) {
            if(map.containsKey(ptrn.charAt(i))) {
                if(!map.get(ptrn.charAt(i)).equals(arr[i]))
                return false;
            } 
            else 
            if(map.containsValue(arr[i]))
            return false;

            map.put(ptrn.charAt(i),arr[i]);
        }
        return true;
    }

    //soln-2

    public static boolean isValidPattern2(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        
        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(c, word);
            }
            
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false;
                }
            } else {
                wordToChar.put(word, c);
            }
        }
        
        return true;
    }

//soln-3
    public static   boolean isValidPattern3(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            if (map.containsKey(c)) {
                if (!map.get(c).equals(word)) {
                    return false;
                }
            } else {
                if (set.contains(word)) {
                    return false;
                }
                map.put(c, word);
                set.add(word);
            }
        }
        
        return true;
    }
}
