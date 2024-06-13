import java.util.Scanner;

public class StringPalindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string:");
        String str=sc.next();
        boolean res1=isPalindrome1(str);
        if(res1)
        System.out.println(str+" is palindrome");
        else
        System.out.println(str+" is NOT palindrome");

        boolean res2=isPalindrome2(str);
        if(res2)
        System.out.println(str+" is palindrome");
        else
        System.out.println(str+" is NOT palindrome");

        boolean res3=isPalindrome3(str);
        if(res3)
        System.out.println(str+" is palindrome");
        else
        System.out.println(str+" is NOT palindrome");
    }

   
    //soln-1
    public static boolean isPalindrome1(String str) {
      
      int i=0,j=str.length()-1;
      while(i<j) {
        if(str.charAt(i)!=str.charAt(j))
        return false;
        i++;
        j--;
      }

      return true;
       
    }

 //soln-2
    public static boolean isPalindrome2(String str) {
       StringBuilder s=new StringBuilder();
       for(int i=0;i<str.length();i++)
       s.append(str.charAt(i));
       s.reverse();
       
       return str.equals(s.toString());
    }

     //soln-3
    public static boolean isPalindrome3(String str) {
        int n=str.length();
        for(int j=0,k=n-1;j<n/2;j++,k--)
        if(str.charAt(j)!=str.charAt(k))
        return false;

        return true;
      
     }

}
