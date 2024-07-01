import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class ReverseVowels {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String:");
        String s=sc.next();
        String ans1=reverseVowels1(s);
        System.out.println("Reverse Vowels:"+ans1);
        String ans2=reverseVowels2(s);
        System.out.println("Reverse Vowels:"+ans2);
        String ans3=reverseVowels3(s);
        System.out.println("Reverse Vowels:"+ans3);
    }

    //soln-1
    public static String reverseVowels1(String s) {
       Stack<Character>  stack=new Stack<>();
        for(int i=0;i<s.length();i++)
        if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'||s.charAt(i)=='A'||s.charAt(i)=='E'||s.charAt(i)=='I'||s.charAt(i)=='O'||s.charAt(i)=='U')
        stack.push(s.charAt(i));

        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++) {
         if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'||s.charAt(i)=='A'||s.charAt(i)=='E'||s.charAt(i)=='I'||s.charAt(i)=='O'||s.charAt(i)=='U' && !stack.isEmpty())
         str.append(stack.pop());
         else
          str.append(s.charAt(i));
        }

        return str.toString();
    }

    //soln-2
    public static String reverseVowels2(String s) {
         Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');

        int i=0,j=s.length()-1;
        
        char[] ch=s.toCharArray();
        while(i<j) {
            while(i<j &&!vowels.contains(ch[i]))
            i++;
            while(i<j &&!vowels.contains(ch[j]))
            i++;

            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            i++;
            j--;
        }

        return new String(ch);
    }

    //soln-3
    public static String reverseVowels3(String s) { 
        boolean[] vowels = new boolean[128];
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels[c] = true;
        }
        char[] cs = s.toCharArray();
        int i = 0, j = cs.length - 1;
        while (i < j) {
            while (i < j && !vowels[cs[i]]) {
                ++i;
            }
            while (i < j && !vowels[cs[j]]) {
                --j;
            }
            if (i < j) {
                char t = cs[i];
                cs[i] = cs[j];
                cs[j] = t;
                ++i;
                --j;
            }
        }
        return String.valueOf(cs);
    }



}
