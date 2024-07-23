
import java.util.Scanner;

public class NimGame {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        boolean res1=nimGame1(n);
        System.out.println(res1);
        boolean res2=nimGame2(n);
        System.out.println(res2);
      
    }

   

    private static boolean nimGame1(int n) {
       if(n<=3)
       return true;

       boolean[] dp=new boolean[n+1];

       dp[1]=dp[2]=dp[3]=true;

       for(int i=4;i<n+1;i++) 
       dp[i]=!dp[i-1] || !dp[i-2] || !dp[i-3];

       return dp[n];
    }

    private static boolean nimGame2(int n) {

        return n%4!=0;
    }

   
}
