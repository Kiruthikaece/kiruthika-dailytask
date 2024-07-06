import java.util.Scanner;

public class PascalTriangle  {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        printPascal1(n);
        printPascal2(n);
        printPascal3(n);
    }

    //soln-1
    public static void printPascal1(int n) {
        int[][] arr=new int[n][n];

        for(int i=0;i<n;i++) {
            arr[i]=new int[i+1];
            for(int j=0;j<=i;j++) {
               if(j==0 || i==j)
               arr[i][j]=1;
               else
               arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<=i;j++)
            System.out.print(arr[i][j]+" ");
            System.out.println();
        }
        
     }

//soln-2
     public static void printPascal2(int n)
     {
         for (int line = 1; line <= n; line++) {
             for (int j = 0; j <= n - line; j++) 
                 System.out.print(" ");

             int C = 1;
             for (int i = 1; i <= line; i++) {
                 System.out.print(C + " ");
                 C = C * (line - i) / i;
             }
             System.out.println();
         }


     }

     //soln-3
     public static void printPascal3(int n) {
        for (int line = 0; line < n; line++) {
            for (int j = 0; j <= line; j++) {
                System.out.print(pascalRecursive(line, j) + " ");
            }
            System.out.println();
        }
    }

    public static int pascalRecursive(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return pascalRecursive(n - 1, k - 1) + pascalRecursive(n - 1, k);
    }
}