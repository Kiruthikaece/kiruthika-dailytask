import java.util.Scanner;

public class LargestOddNumberString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number:");
        String num=sc.next();
        String res1=findLargestOddNumber1(num);
        System.out.println(res1);
        String res2=findLargestOddNumber2(num);
        System.out.println(res2);
        String res3=findLargestOddNumber3(num);
        System.out.println(res3);
    }
    //soln-1
    private static String findLargestOddNumber3(String num) {
         int maxIndex=-1;
         for(int i=0;i<num.length();i++) {
            if((num.charAt(i)-'0')%2!=0)
             maxIndex=i;
         }
         if(maxIndex==-1)
         return "";

         return num.substring(0,maxIndex+1);
    }

    //soln-2
    private static String findLargestOddNumber2(String num) {
        int i = num.length() - 1;
        while (i >= 0) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
            i--;
        }
        return "";
    }

    //soln-3
    private static String findLargestOddNumber1(String num) {
        String res="";
         for(int i=num.length()-1;i>=0;i--)
         if((num.charAt(i)-'0')%2!=0)
         return num.substring(0,i+1);

         return res;
    }
}