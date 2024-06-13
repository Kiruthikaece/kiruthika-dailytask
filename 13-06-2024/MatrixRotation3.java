import java.util.Scanner;

public class MatrixRotation3 {
    public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
        System.out.println("Enter mextix row");
        int n=sc.nextInt();
        int[][] mat=new int[n][n];
        for(int i=0;i<n;i++) 
        for(int j=0;j<n;j++)
        mat[i][j]=sc.nextInt();
        rotation90Degree(mat);
    }

    public static void rotation90Degree(int[][] mat) {
       int n=mat.length;
       int[][] ans=new int[n][n];

       for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++) {
            ans[j][n-1-i]=mat[i][j];
        }
       }

       System.out.println("Matrix rotation\n");
       for(int i=0;i<n;i++) {
           for(int j=0;j<n;j++)
           System.out.print(ans[i][j]+" ");
           System.out.println();
       }


    }
}
