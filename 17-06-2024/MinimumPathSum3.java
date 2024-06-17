
import java.util.Scanner;

public class MinimumPathSum3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        System.out.println("Enter m:");
        int m=sc.nextInt();
        int[][] mat=new int[n][m];

        for(int i=0;i<n;i++)
        for(int j=0;j<m;j++)
        mat[i][j]=sc.nextInt();
        
        int ans3=findMinimumPathSum3(mat);
        System.err.println("minimum path:"+ans3);

}
public static int findMinimumPathSum3(int[][] grid) {
    int row =grid.length;
    int column =grid[0].length;
    int[][] dp =new int[row][column];

    dp[0][0] = grid[0][0];
    for (int i = 1; i < row; i++) {
        dp[i][0]=dp[i - 1][0] + grid[i][0];
    }

    for (int j = 1;j<column;j++) {
        dp[0][j] =dp[0][j - 1]+grid[0][j];
    }

    for (int i = 1;i<row;i++) {
        for (int j = 1; j < column; j++) {
            dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
        }
    }

    return dp[row - 1][column - 1];
}
}