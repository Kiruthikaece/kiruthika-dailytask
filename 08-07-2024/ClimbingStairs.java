import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ans1= findways1(n);
        System.err.println(ans1);
        // int ans2= findways2(n,new ArrayList<>());
        // System.err.println(ans2);
        // int ans3 = findways3(n);
        // System.err.println(ans3);
    }

    private static int findways3(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        dp[i]=dp[i-1]+dp[i-2];

        return dp[n];
    }

    private static int findways2(int n,List<Integer> dp) {
        if(n<=1)
        return 1;

        if(dp.get(n)!=0)
        return dp.get(n);

         dp.add((findways2(n-1,dp)+findways2(n-2,dp)));

         return dp.get(n);
    }

    private static int findways1(int n) {
         if(n<=1)
         return 1;

         return findways1(n-1)+findways1(n-2);
    }

}
