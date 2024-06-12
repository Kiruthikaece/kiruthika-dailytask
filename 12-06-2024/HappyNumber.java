import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number:");
        int n=sc.nextInt();
        boolean res1=isHappyNumber1(n);
        if(res1==true)
        System.out.println(n+" is Happy number");
        else
        System.out.println(n+" is Not Happy number");

        boolean res2=isHappyNumber2(n);
        if(res2==true)
        System.out.println(n+" is Happy number");
        else
        System.out.println(n+" is Not Happy number");

        boolean res3=isHappyNumber3(n);
        if(res3==true)
        System.out.println(n+" is Happy number");
        else
        System.out.println(n+" is Not Happy number");
    }

    private static boolean isHappyNumber3(int n) {
        int slow,fast;
        slow=n;
        fast=n;
        do
        {
            slow = numSquareSum(slow);
            fast = numSquareSum(numSquareSum(fast));
        }
        while (slow != fast);
        return (slow == 1);
    }

    private static int numSquareSum(int n) {
        int squareSum = 0;
        while (n!= 0)
        {
        squareSum += (n % 10) * (n % 10);
        n /= 10;
        }
        return squareSum;
    }

    private static boolean isHappyNumber2(int n) {
        Set<Integer>set=new HashSet<>();
        
        while(true) {
           n=findSquare(n);
           if(set.contains(n))
           return false;
           if(n==1)
           return true;
           set.add(n);
        }
        
    }

    public static int findSquare(int n)
{
    int num = 0;
    while (n != 0) {
        int digit = n % 10;
        num += digit * digit;
        n /= 10;
    }
    return num;
}

    public static boolean isHappyNumber1(int n) {
        int res=0;
         while(res!=1 && res!=2)  {
            res=0;
            while(n!=0) {
                int d=n%10;
                res+=d*d;
                n=n/10;
            } 
            if(res==1)
            return true;
            n=res;
         
         }

         return false;
    }
}
