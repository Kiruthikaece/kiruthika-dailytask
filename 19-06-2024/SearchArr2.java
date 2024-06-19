
import java.util.Scanner;

public class SearchArr2 {
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
        
        int res2=rotataionArr2(arr,target);
        System.out.println("target index:"+res2);
       
    }

    //soln-2
    private static int rotataionArr2(int[] arr, int target) {
        int low=0,high=arr.length-1;
        while(low<=high) {
            int mid=(low+high)/2;

            if(arr[mid]==target)
                return mid;

                if(arr[low]<=arr[mid])
                {
                    if(arr[low]<=target && target<arr[mid])
                    high=mid-1;
                    else
                    low=mid+1;
                }
                else {
                    if(arr[mid]<target && target<=arr[high])
                    low=mid+1;
                    else
                    high=mid-1;
                }
        }

        return -1;
    }
}