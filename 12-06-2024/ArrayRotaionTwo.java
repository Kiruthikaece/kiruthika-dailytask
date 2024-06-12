import java.util.Scanner;

public class ArrayRotaionTwo {
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
    }

    public static void ArrayRotation(int[] arr,int d) {
        int n=arr.length;
         d=d%n;
        int temp[] = new int[n];
         int k = 0;
        for (int i = d; i < n; i++) {
        temp[k] = arr[i];
        k++;
       }
       for (int i = 0; i < d; i++) {
        temp[k] = arr[i];
        k++;
       }
      for (int i = 0; i < n; i++) 
        arr[i] = temp[i];
    

    for (int i = 0; i < n; i++) 
        System.out.print(arr[i]+" ");
    
}
}
