import java.util.Arrays;
import java.util.Scanner;

public class SubarrayLength {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        int res1=findLargeSubarrayLength1(arr);
        System.out.println("Maximum largest increasing subarray:"+res1);
        int res2=findLargeSubarrayLength2(arr);
        System.out.println("Maximum largest increasing subarray:"+res2);
        int res3=findLargeSubarrayLength3(arr);
        System.out.println("Maximum largest increasing subarray:"+res3);
    }


    //soln-1
    public static int findLargeSubarrayLength1(int[] arr) {
        int count=1,maxlength=0;
        for(int i=0;i<arr.length-1;i++)  
        if(arr[i]<arr[i+1]) {
            count++;
        }
        else {
            maxlength=Math.max(maxlength,count);
            count=1;
        }

        if(maxlength<count)
        maxlength=count;
        return maxlength;
    }

    //soln-2
    public static int findLargeSubarrayLength2(int[] arr) {
        int maxCount=0,count=1;;
        for(int i=0;i<arr.length;i++) {
             count=1;
            for(int j=i;j<arr.length-1;j++) {
                if(arr[j+1]>arr[j])
                count++;
                else
                break;
            }
            maxCount=Math.max(maxCount,count); 
        }
        if(maxCount<count)
        maxCount=count;

        return maxCount;
    }


    //soln-3

    public static int findLargeSubarrayLength3(int[] arr) {
        int maxCount=1;
        int[] temp=new int[arr.length];
        temp[0]=1;
        for(int i=1;i<arr.length;i++) {
         if(arr[i]>arr[i-1])
         temp[i]=temp[i-1]+1;
         else
         temp[i]=1;
         maxCount=Math.max(maxCount,temp[i]);
        }

        return maxCount;
     }
}
