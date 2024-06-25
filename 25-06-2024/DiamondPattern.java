import java.util.Scanner;

public class DiamondPattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        System.out.println("using recursion");
        printDiamondPattern1(n,0,true);
        System.out.println("using StringBuilder");
        printDiamondPattern2(n);
        System.out.println("using Nested loop");
        printDiamondPattern3(n);
    }

    //soln-1
    private static void printDiamondPattern1(int n,int row,boolean isHalf) {
          if(isHalf) {
            if(row<n) {
                printPattern(row,n);
                printDiamondPattern1(n,row+1,true);
            }
            else
            printDiamondPattern1(n,row-2,false);
          }  
          else {
            if(row>=0) {
                printPattern(row,n);
                printDiamondPattern1(n,row-1,false);
            }
          }
    }

    private static void printPattern(int row, int n) {
        for(int j=0;j<n-row-1;j++)
        System.out.print(" ");
        for(int j=0;j<=row;j++)
        System.out.print("* ");
        System.out.println();
    }

    //soln-2
    private static void printDiamondPattern2(int n) {
         StringBuilder str=new StringBuilder();
         for(int i=0;i<n;i++) {
            str.append(" ".repeat(n-i-1));
            for(int j=0;j<=i;j++)
            str.append("* ");
            str.append("\n");
         }
         for(int i=n-2;i>=0;i--) {
            str.append(" ".repeat(n-i-1));
            for(int j=0;j<=i;j++)
            str.append("* ");
            str.append("\n");

         }

         System.out.println(str.toString());
    }

    //soln-3
    public static void printDiamondPattern3(int n) {
        int space=n-1;
         for(int i=1;i<n;i++) {
            for(int k=0;k<space;k++)
            System.out.print(" ");
            for(int j=1;j<=i;j++) 
            System.out.print("* ");
            System.out.println();
            space--;
         }

        space=0;
         for(int i=n;i>0;i--) {
            for(int k=0;k<space;k++)
            System.out.print(" ");
            for(int j=1;j<=i;j++) 
            System.out.print("* ");
            System.out.println();
            space++;
         }
    }
}