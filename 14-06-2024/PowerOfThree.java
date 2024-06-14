import java.util.Scanner;

public class PowerOfThree {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number:");
        int n=sc.nextInt();
        boolean res3=isPowerOfThree3(n);
        if(res3)
        System.out.println(n+" is a 3 power");
        else
        System.out.println(n+" is Not a 3 power");

        boolean res2=isPowerOfThree2(n);
        if(res2)
        System.out.println(n+" is a 3 power");
        else
        System.out.println(n+" is Not a 3 power");

        boolean res1=isPowerOfThree1(n,1);
        if(res1)
        System.out.println(n+" is a 3 power");
        else
        System.out.println(n+" is Not a 3 power");
    }

    //soln-1
    public static boolean isPowerOfThree1(int n, int i) {
        boolean t=false;
          if(n==1)
          return true;
          
          while(n!=1) {
            if(n%3!=0) {
                t=false;
                break;
            }
            else
            t=true;

            n=n/3;
          }

          return t;
    }

    //soln-2
    public static boolean isPowerOfThree2(int n) {
        if(n==1)
          return true;
        if(n%3!=0)
        return false;

        return isPowerOfThree2(n/3);
         
    }

    //soln-3
    public static boolean isPowerOfThree3(int n) {

        if(n==1)
        return true;

        int mul=1;
        for(int i=1;i<=n/2;i++) {
            mul*=3;
            if(mul==n)
            return true;
        }
       
        return false;
    }
}
