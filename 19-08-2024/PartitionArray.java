
import java.util.Scanner;

public class PartitionArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter arr length:");
        int n=sc.nextInt();
        int[] arr=new int[n];

        System.out.println("Enter arr:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        System.out.println("Enter k:");
        int k=sc.nextInt();

        int res=partitionArr1(arr,k);
        System.out.println(res);

        int res2=partitionArr2(arr,k);
        System.out.println(res2);
    }

    private static int partitionArr1(int[] arr, int k) {
        return partitionHelp(0,arr,k);
    }

    static int partitionHelp(int ind, int[] num, int k) {
        int n = num.length;
        if (ind == n) return 0;

        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        for (int j = ind; j < Math.min(ind + k, n); j++) {
            len++;
            maxi = Math.max(maxi, num[j]);
            int sum = len * maxi + partitionHelp(j + 1, num, k);
            maxAns = Math.max(maxAns, sum);
        }
        return maxAns;
    }

   public static int partitionArr2(int[] num, int k) {
        int n = num.length;
        int[] dp = new int[n + 1];
        
        for (int ind = n - 1; ind >= 0; ind--) {
            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;
        for (int j = ind; j < Math.min(ind + k, n); j++) {
                len++;
                maxi = Math.max(maxi, num[j]);
                int sum = len * maxi + dp[j + 1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[ind] = maxAns;
        }
        return dp[0];
    }
}
