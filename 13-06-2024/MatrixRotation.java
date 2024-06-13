import java.util.Scanner;

public class MatrixRotation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter mextix row");
        int n=sc.nextInt();
        int[][] mat=new int[n][n];
        for(int i=0;i<n;i++) 
        for(int j=0;j<n;j++)
        mat[i][j]=sc.nextInt();
        rotation90Degree1(mat);
   
    }

 //soln-1

    public static void rotation90Degree1(int[][] mat) {
        int n=mat.length;

        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }

        for(int i=0;i<n;i++) {
            int low=0,high=n-1;
            while(low<high) {
                int temp=mat[i][low];
                mat[i][low]=mat[i][high];
                mat[i][high]=temp;
                low++;
                high--;
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