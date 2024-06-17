import java.util.Scanner;

public class MinimumPathSum2 {
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
      
        int ans2=findMinimumPathSum2(mat);
        System.err.println("minimum path:"+ans2);
    

}
public static int findMinimumPathSum2(int[][] grid) {
    int[][] memo = new int[grid.length][grid[0].length];
    return findMinimumRecursively(grid, 0, 0, memo);
}

private static int findMinimumRecursively(int[][] grid, int i, int j, int[][] memo) {
    if (i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;
    if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
    if (memo[i][j] != 0) return memo[i][j];

    int right = findMinimumRecursively(grid, i, j + 1, memo);
    int down = findMinimumRecursively(grid, i + 1, j, memo);

    memo[i][j] = grid[i][j] + Math.min(right, down);
    return memo[i][j];
}
}
