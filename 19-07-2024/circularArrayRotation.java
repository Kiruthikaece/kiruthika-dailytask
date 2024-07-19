import java.util.Scanner;

public class circularArrayRotation {
    

    public static void rotateArrayInPlace(int[] a, int k) {
        int n = a.length;
        k = k % n;

        reverseArray(a, 0, n - 1);
        reverseArray(a, 0, k - 1);
        reverseArray(a, k, n - 1);
    }

    private static void reverseArray(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    public static int[] circularArrayRotation2(int[] a, int k, int[] queries) {
        rotateArrayInPlace(a, k);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = a[queries[i]];
        }

        return result;
    }

    public static int[] circularArrayRotation1(int[] a, int k, int[] queries) {
        int n = a.length;
        k = k % n;  

        int[] rotatedArray = new int[n];
        for (int i = 0; i < n; i++) {
            rotatedArray[(i + k) % n] = a[i];
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = rotatedArray[queries[i]];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter n:");
        int n = scanner.nextInt();
        System.out.println("Enter k:");
        int k = scanner.nextInt();
        System.out.println("Enter q:");
        int q = scanner.nextInt();

        System.out.println("Enter array:");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println("Enter queries:");
        int[] queries = new int[q];
        for (int i = 0; i < q; i++) {
            queries[i] = scanner.nextInt();
        }

        int[] result = circularArrayRotation1(a, k, queries);
        for (int value : result) {
            System.out.print(value+" ");
        }
        System.out.println();

        int[] result2 = circularArrayRotation2(a, k, queries);
        for (int value : result2) {
            System.out.print(value+" ");
        }

        scanner.close();
    }
}


