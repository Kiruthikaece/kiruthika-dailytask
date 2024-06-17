import java.util.Scanner;

public class MinimumPathSum {
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
        int ans1=findMinimumPathSum1(mat);
        System.err.println("minimum path:"+ans1);
     

}
public static int findMinimumPathSum1(int[][] grid) {
    int row=grid.length;
     int column=grid[0].length;
   
   for(int i=0;i<row;i++) {
    for(int j=0;j<column;j++) {
       if(i==0 && j==0)
       grid[0][0]=grid[0][0];
       else if(i==0 && j!=0) 
       grid[i][j]=grid[i][j-1]+grid[i][j];
       else if(i!=0 && j==0) 
       grid[i][j]=grid[i-1][j]+grid[i][j];
       else
       grid[i][j]=grid[i][j]+Math.min(grid[i][j-1],grid[i-1][j]);
       
   }
   }
 
      return grid[row-1][column-1];
}



}
