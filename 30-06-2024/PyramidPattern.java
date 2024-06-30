import java.util.Scanner;

public class PyramidPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        printPyramid1(n);
        printPyramid2(n);
        printPyramid3(n);
    }

    public static void printPyramid1(int n) {
        int num = 1;
        int rows = (int) ((-1 + Math.sqrt(1 + 8 * n)) / 2); 
        
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                if (num <= n) {
                    System.out.print(num + " ");
                    num++;
                }
            }
            System.out.println();
        }
    }


    public static void printPyramid2(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int num = 0;
        int rows = (int) ((-1 + Math.sqrt(1 + 8 * n)) / 2); 

        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                if (num < n) {
                    System.out.print(arr[num] + " ");
                    num++;
                }
            }
            System.out.println();
        }
    }


    public static void printPyramid3(int n) {
        StringBuilder sb = new StringBuilder();
        int num = 1;
        int rows = (int) ((-1 + Math.sqrt(1 + 8 * n)) / 2);
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) {
                sb.append(" ");
            }
            for (int k = 1; k <= i; k++) {
                if (num <= n) {
                    sb.append(num).append(" ");
                    num++;
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
