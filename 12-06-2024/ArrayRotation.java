import java.util.Scanner;

public class ArrayRotation {
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
        ArrayRotation1(arr,rotate);
    }

    // soln-1
    public static void ArrayRotation1(int[] arr,int rotate) {
       int k=0;
       while(k<rotate) {
        int temp=arr[0];
        for(int i=0;i<arr.length-1;i++)
        arr[i]=arr[i+1];
        arr[arr.length-1]=temp;
        k++;
       }

       for(int i=0;i<arr.length;i++)
       System.out.print(arr[i]+" ");
    }

 

   
}