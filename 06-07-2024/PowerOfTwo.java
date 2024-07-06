import java.util.Scanner;

public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        boolean res1=findPowerTwo1(n);
        System.out.println(res1);
        boolean res2=findPowerTwo2(n);
        System.out.println(res2);
        boolean res3=findPowerTwo3(n);
        System.out.println(res3);
    }

        //soln-3
    public static boolean findPowerTwo3(int n) {
        if (n == 0) 
        return false;
        
        while (n > 0) {
            if (n == 1) 
            return true;
            if (n % 2 != 0)
             break;
            n /= 2;
        }
        return false;
    }

    //soln-2
    private static boolean findPowerTwo2(int n) {
        if (n <= 0) 
            return false; 
        
        return (n & (n - 1)) == 0;
    }

    //soln-1
    private static boolean findPowerTwo1(int n) {
        if(n==1)
        return true;
        if(n<=0 || n%2!=0)
        return false;

        return findPowerTwo1(n/2);
    }
}
