import java.util.*;

class Anagram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string1:");
        String s1 = sc.next();
        System.out.println("Enter string2:");
        String s2 = sc.next();
        isAnagram1(s1, s2);
        isAnagram2(s1, s2);
        isAnagram3(s1, s2);
    }


// soln-1
    public static void isAnagram1(String s1, String s2) {
        boolean isAnagram = true;
        char[] ch1 = s1.toLowerCase().toCharArray();
        char[] ch2 = s2.toLowerCase().toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != ch2[i]) {
                isAnagram = false;
                break;
            }
        }

        if (isAnagram)
            System.out.println("Two Strings are anagram");
        else
            System.out.println("Two Strings are not anagram");
    }

// soln-2
    public static void isAnagram2(String str1, String str2) {
        boolean areAnagram = true;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        if (str1.length() != str2.length()) {
            System.out.println("Two strings are not anagram");
            return;
        }

        int[] count = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++;
            count[str2.charAt(i) - 'a']--;
        }

        for (int i : count) {
            if (i != 0) {
                areAnagram = false;
                break;
            }
        }

        if (areAnagram)
            System.out.println("Two strings are anagram");
        else
            System.out.println("Two strings are not anagram");
    }


//soln-3
    public static void isAnagram3(String str1, String str2) {
        boolean isAnagram = true;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        if (str1.length() != str2.length()) {
            System.out.println("Two strings are not anagram");
            return;
        }

        char[] characters = str1.toCharArray();
        StringBuilder strb = new StringBuilder(str2);

        for (char ch : characters) {
            int index = strb.indexOf("" + ch);
            if (index != -1)
                strb.deleteCharAt(index);
            else {
                isAnagram = false;
                break;
            }
        }
        
        if (strb.length() == 0 && isAnagram)
            System.out.println("Two strings are anagram");
        else
            System.out.println("Two strings are not anagram");
    }
}
