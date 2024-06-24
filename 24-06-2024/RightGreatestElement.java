import java.util.Arrays;
import java.util.Scanner;

public class RightGreatestElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length:");
        int len=sc.nextInt();
        System.out.println("Enter array:");
        int[] arr=new int[len];
        for(int i=0;i<len;i++)
        arr[i]=sc.nextInt();
        // findGreatestArray1(arr);
        // findGreatestArray2(arr);
        findGreatestArray3(arr);
    }

    //soln-1

    public static void findGreatestArray3(int[] arr) {
        int max=arr[arr.length-1];
          for(int i=arr.length-2;i>=0;i--) {
            int temp=arr[i];
            arr[i]=max;
            if(temp>max)
            max=temp;

          }
          arr[arr.length-1]=-1;

          for(int x:arr)
          System.out.print(x+" ");
    }

    
    //soln-2
     public static void findGreatestArray2(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int i = n - 2; i >= 0; i--) {
            result[i] = Math.max(arr[i + 1], result[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = result[i];
        }

        for (int x : arr)
            System.out.print(x + " ");
    }

     //soln-3
     public static void findGreatestArray1(int[] arr) {
        for(int i=0;i<arr.length-1;i++) {
           int max=Integer.MIN_VALUE;
           for(int j=i+1;j<arr.length;j++) {
               if(arr[j]>max)
               max=arr[j];
           }
           arr[i]=max;
        }

        arr[arr.length-1]=-1;

        for(int x:arr)
        System.out.print(x+" ");

   }

}