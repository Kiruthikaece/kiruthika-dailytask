
import java.util.Scanner;

public class FindPeakElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        int res1=findPeakElement1(arr);
        System.out.println(res1);

        int res2=findPeakElement2(arr);
        System.out.println(res2);

        int res3=findPeakElement3(arr);
        System.out.println(res3);
    }

    private static int findPeakElement1(int[] arr) {
         
        int n=arr.length;

        int max=0,maxElement=arr[0];
          for(int i=1;i<n-1;i++) {
             if(arr[i]>arr[i-1] && arr[i] > arr[i+1] && arr[i]>maxElement)
              max=i;
          }

          if(arr[n-1]>arr[n-2])
          return n-1;

          return max;
    }

    public static int findPeakElement2(int[] nums) {
        if(nums.length==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]) return mid;
            else if(nums[mid]>nums[mid-1]&&nums[mid]<nums[mid+1]) low=mid;
            else high=mid;
        }
        return 0;
    }

    private static int findPeakElement3(int[] nums) {
            if(nums.length==1)
        return 0;
        int max=nums[0];
        for(int i=1;i<nums.length;i++)
        if(nums[i]>max)
        max=nums[i];

       for(int i=0;i<nums.length;i++)
       if(nums[i]==max)
       return i;

       return 0;
    }
}