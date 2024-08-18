
import java.util.Scanner;

public class MaximumAverageSubarray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter k:");
        int k=sc.nextInt();

       double res1=findMaximumSubarray1(arr,k);
        System.out.println(res1);

        double res2=findMaximumSubarray2(arr,k);
        System.out.println(res2);
}

    private static double findMaximumSubarray1(int[] nums, int k) {
         
        int left=0,right=0;
        double sum=0,max=Integer.MIN_VALUE;

        while(right<nums.length) {
            if(right<nums.length) 
            sum+=nums[right];

            
            if(right-left+1==k) {
                max=Math.max(max,sum/k);
                sum=sum-nums[left];
                left++;
            }
          right++;
        }

        return max;
    }

    private static double findMaximumSubarray2(int[] nums, int k) {

            int sum=0;
            int max=Integer.MIN_VALUE;
            for(int i=0;i<k;i++){
                sum+=nums[i];
            }
            max=Math.max(sum,max);
            for(int i=k;i<nums.length;i++) {
                System.out.println(sum);
                sum+=nums[i]-nums[i-k];
                max=Math.max(max,sum);
            }
            return (double)max/k;
        
    }
}