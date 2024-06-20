import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumPathSum {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         System.out.println("Enter n:");
         int n=sc.nextInt();
         int[][] mat=new int[n][];

         for (int i = 0; i < n; i++) {
            mat[i] = new int[i + 1];
        }
         for(int i=0;i<n;i++) {
            for(int j=0;j<=i;j++)
            mat[i][j]=sc.nextInt();
         }
        
        int res1=findMinimumPathSum1(mat);
        System.out.println("Minimum path sum:"+res1);

        int res2=findMinimumPathSum2(mat);
        System.out.println("Minimum path sum:"+res2);

        int res3=findMinimumPathSum2(mat);
        System.out.println("Minimum path sum:"+res3);
    }

    //soln-1

    public static int findMinimumPathSum1(int[][] mat) {
        int sum=0;
        for(int i=0;i<mat.length;i++) {
            int min=mat[i][0];
            for(int j=1;j<mat[i].length;j++)
            if(mat[i][j]<min)
            min=mat[i][j];

            sum+=min;
        }
        return sum;
    }

    //soln-2

    public static int findMinimumPathSum2(int[][] mat) {
        int n = mat.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = mat[n - 1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = mat[i][j] + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }

    //soln-3

    public static int findMinimumPathSum3(int[][] mat) {
        Map<String, Integer> map = new HashMap<>();
        return findRecursively(mat, 0, 0, map);
    }

    private static int findRecursively(int[][] mat, int i, int j, Map<String, Integer> map) {
        if (i == mat.length) {
            return 0;
        }

        String key = i + "," + j;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int left = findRecursively(mat, i + 1, j, map);
        int right = findRecursively(mat, i + 1, j + 1, map);
        int minPath = mat[i][j] + Math.min(left, right);

        map.put(key, minPath);
        return minPath;
    }

}
