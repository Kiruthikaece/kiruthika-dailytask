import java.util.Arrays;
import java.util.Scanner;

public class SearchInsertPosition {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
    System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
    System.out.println("Enter target:");
    int target=sc.nextInt();

	int res1=searchPosition1(arr,target);
    System.out.println(res1);

	int res2=searchPosition2(arr,target);
    System.out.println(res2);
}

  
//soln-1
    private static int searchPosition1(int[] arr,int target) {
        int left=0,right=arr.length;
        Arrays.sort(arr);
        while(left<right) {
            int mid=(left+right)/2;

            if(arr[mid]==target)
            return mid;

            if(arr[mid]>target)
            right=mid-1;
            else
            left=mid+1;
            
        }

        return left;
    }

    //soln-2
    
    private static int searchPosition2(int[] arr, int target) {
         int position=-1;

         for(int i=0;i<arr.length;i++) {
            if(arr[i]==target)
            return i;
            else if(arr[i]<target)
            position=i;
         }

         if(position+1<arr.length)
         return position+1;
         else
         return arr.length;
    }
}