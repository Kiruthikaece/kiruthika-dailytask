import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        List<List<Integer>> result1 = generatePascalTriangleIterative(n);
        System.out.println(result1);

        List<List<Integer>> result2 = generatePascalTriangleRecursive(n);
        System.out.println(result2);

        List<List<Integer>> result3 = generatePascalTriangleBinomial(n);
        System.out.println(result3);
    }

    //soln-1
    public static List<List<Integer>> generatePascalTriangleIterative(int numRows) {
        
        List<List<Integer>> triangle = new ArrayList<>();
        
        if (numRows == 0) {
            return triangle;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            
            for (int j = 1; j < i; j++) 
            row.add(prevRow.get(j - 1) + prevRow.get(j));
            row.add(1);
            triangle.add(row);
        }

        return triangle;
    }

    //soln-2
    public static List<List<Integer>> generatePascalTriangleRecursive(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows > 0) {
            generateRow(triangle, numRows - 1);
        }
        return triangle;
    }

    private static List<Integer> generateRow(List<List<Integer>> triangle, int rowIndex) {
        if (rowIndex == 0) {
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            triangle.add(firstRow);
            return firstRow;
        }

        List<Integer> prevRow = generateRow(triangle, rowIndex - 1);
        List<Integer> row = new ArrayList<>();   
        row.add(1);
        for (int j = 1; j < rowIndex; j++) 
        row.add(prevRow.get(j - 1) + prevRow.get(j));
        row.add(1); 
        triangle.add(row);
        return row;
    }


    //soln-3

    public static List<List<Integer>> generatePascalTriangleBinomial(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) {
                row.add(binomialCoefficient(i, j));
            }

            triangle.add(row);
        }

        return triangle;
    }

    private static int binomialCoefficient(int n, int k) {
        int res = 1;
        if (k > n - k) {
            k = n - k;
        }
        for (int i = 0; i < k; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
}
