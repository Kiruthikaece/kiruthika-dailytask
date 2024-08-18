import java.util.Scanner;

public class MinCostClimbStairs {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        int res1=findMinCost1(arr);
        System.out.println(res1);
        int res2=findMinCost2(arr);
        System.out.println(res2);
    }

    private static int findMinCost1(int[] cost) {
        int[] dp=new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];

        for(int i=2;i<cost.length;i++)
        dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);

        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }

    
public static int findMinCost2(int[] cost) {
	int n = cost.length;
	int[] dp = new int[n];
	return Math.min(minCost(cost, n-1,dp), minCost(cost, n-2,dp));
}
private static int minCost(int[] cost, int n,int[] dp) {
	if (n < 0) return 0;
	if (n==0 || n==1) return cost[n];
	if (dp[n] != 0) return dp[n];
	dp[n] = cost[n] + Math.min(minCost(cost, n-1,dp), minCost(cost, n-2,dp));
	return dp[n];
}
}
