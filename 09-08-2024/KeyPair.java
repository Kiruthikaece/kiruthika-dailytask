import java.util.Arrays;
import java.util.Scanner;

public class KeyPair {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
    System.out.println("Enter sum:");
    int x=sc.nextInt();
	boolean res1=keyPair1(arr,x);
    System.out.println(res1);
	boolean res2=keyPair2(arr,x,0,1);
    System.out.println(res2);
    boolean res3=keyPair3(arr,x);
    System.out.println(res3);
}

    private static boolean keyPair1(int[] arr, int x) {
        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++)
              if(arr[i]+arr[j]==x)
              return true;
        }
        
        return false;
     }

    private static boolean keyPair2(int[] arr, int x, int i, int j) {
         if(i>=arr.length-1)
         return false;

         

         if(j>=arr.length) {
            i=i+1;
            j=i+1;
         }

         if(arr[i]+arr[j]==x)
         return true;
       

         return keyPair2(arr,x,i,j+1);
    }

    private static boolean keyPair3(int[] arr, int x) {
         
        Arrays.sort(arr);
        int start=0,end=arr.length-1;

        while(start<end) {
            if(arr[start]+arr[end]==x)
            return true;
            else if(arr[start]+arr[end]>x)
            end--;
            else
            start++;
        }
        return false;
    }
}

