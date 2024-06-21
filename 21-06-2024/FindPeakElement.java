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
        System.out.println("Peak element:"+res1);
        int res2=findPeakElement2(arr);
        System.out.println("Peak element:"+res2);
        int res3=findPeakElement3(arr);
        System.out.println("Peak element:"+res3);
    }

    //soln-1
    public static int findPeakElement3(int[] arr) {
        int n=arr.length;
        if(n==1)
        return 0;

        int l=0,r=n-1;
        while(l<=r) {
            int mid=(l+r)/2;
            if(arr[mid]>arr[mid-1] && arr[mid] > arr[mid+1])
            return mid;
            if(mid<n-1 && arr[mid]<arr[mid+1])
            l=mid+1;
            else
            r=mid-1;
        }

        if(arr[0]>arr[1])
        return 0;
        else
        return n-1;
    }

    //soln-2
    public static int findPeakElement1(int[] nums) {
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
    
    //soln-3
    public static int findPeakElement2(int[] nums) {
        if(nums.length==1)
        return 0;
         int maxNo=nums[0],maxIndex=0;
           for(int i=1;i<nums.length-1;i++) {
              if(nums[i]>nums[i-1] && nums[i]>nums[i+1] && nums[i]>maxNo)
              maxIndex=i;
           }
           if(nums[nums.length-1]>nums[nums.length-2])
           return nums.length-1;
           else
           return maxIndex;
    }
}