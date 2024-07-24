
import java.util.Scanner;

public class VowelsGame {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter String:");
        String s=sc.next();

        boolean res1=vowelGame1(s);
        System.err.println(res1);

        boolean res2=vowelGame2(s);
        System.err.println(res2);

        
    }

    private static boolean vowelGame1(String s) {
        int vowelCount=0;

        for(int i=0;i<s.length();i++) {
           if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='o' ||  s.charAt(i)=='i'|| s.charAt(i)=='u')
           vowelCount++;
        }

        if(vowelCount==0)
        return false;

        if(vowelCount%2!=0)
        return true;

        return true;

    }

    private static boolean vowelGame2(String s) {
       for(int i=0;i<s.length();i++) {
        if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='o' ||  s.charAt(i)=='i'|| s.charAt(i)=='u') 
        return true;
       }

       return false;
    }

    
}