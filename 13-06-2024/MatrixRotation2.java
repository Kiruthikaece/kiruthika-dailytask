import java.util.Scanner;

public class MatrixRotation2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter mextix row");
        int n=sc.nextInt();
        int[][] mat=new int[n][n];
        for(int i=0;i<n;i++) 
        for(int j=0;j<n;j++)
        mat[i][j]=sc.nextInt();
        rotation90Degree2(mat);
    }
//soln-2

public static void rotation90Degree2(int[][] mat) {
    int n=mat.length;

    for(int i=0;i<n/2;i++) {
    for(int j=i;j<n-i-1;j++) {
        int temp=mat[i][j];
        mat[i][j]=mat[n-j-1][i];
        mat[n-j-1][i]=mat[n-i-1][n-j-1];
        mat[n-i-1][n-j-1]=mat[j][n-i-1];
        mat[j][n-i-1]=temp;
        }
    }

    System.out.println("Matrix rotation\n");
    for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++)
        System.out.print(mat[i][j]+" ");
        System.out.println();
    }
}
}