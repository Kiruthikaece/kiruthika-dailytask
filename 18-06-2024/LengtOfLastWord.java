import java.util.Scanner;

public class LengtOfLastWord {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string:");
        String str=sc.nextLine();
        int res1=lengthLastWord1(str);
        System.out.println("Last word count:"+res1);
        int res2=lengthLastWord2(str);
        System.out.println("Last word count:"+res2);

        int res3=lengthLastWord3(str);
        System.out.println("Last word count:"+res3);
    }

    private static int lengthLastWord1(String s) {
        int count=0;
        s=s.trim();
        for(int i=s.length()-1;i>=0;i--) {
          if(s.charAt(i)==' '&& count!=0)
          return count;
          else if(s.charAt(i)!=' ')
          count++;
        }
        return count;
    }

    public static int lengthLastWord2(String s) {
        String[] words = s.trim().split("\\s+");
        return words[words.length - 1].length();
    }

    public static int lengthLastWord3(String s) {
        s = s.trim();
        int lastSpaceIndex = s.lastIndexOf(' ');
        return s.length() - lastSpaceIndex - 1;
    }
}
