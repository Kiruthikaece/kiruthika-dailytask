import java.util.Scanner;

public class ArrayRotationThree {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter rotation:");
        int rotate=sc.nextInt();
        ArrayRotation(arr,rotate);
        for(int i:arr)
        System.out.print(i+" ");
    }

public static void ArrayRotation(int arr[], int d) {
    int n = arr.length;
    d = d % n;
    reverse(arr, 0, d - 1);
    reverse(arr, d, n - 1);
    reverse(arr, 0, n - 1);
}

  public static void reverse(int arr[], int start, int end) {
    while (start < end) {
        int temp = arr[start]; 
        arr[start] = arr[end]; 
        arr[end] = temp;
        start++;
        end--;
}
}
}
