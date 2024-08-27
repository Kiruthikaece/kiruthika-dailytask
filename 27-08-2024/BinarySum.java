import java.util.Scanner;

public class BinarySum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter goal:");
        int goal=sc.nextInt();

        int res1=findSum1(arr,goal);
        System.out.println(res1);

        int res2=findSum2(arr,goal)-findSum2(arr,goal-1);
        System.out.println(res2);

        int res3=findSum3(arr,goal);
        System.out.println(res3);
    }

    public static int findSum3(int[] nums, int goal) {
        int totalCount = 0;
        int sum = 0;
        int prefixSum[] = new int[nums.length + 1];
        prefixSum[0] = 1;
        
        for (int num : nums) {
            sum += num;
            if (sum >= goal) {
                totalCount += prefixSum[sum - goal];
            }
            prefixSum[sum]++;
        }
        
        return totalCount;
    }

    private static int findSum2(int[] arr, int goal) {

        if(goal<0) 
        return 0;

        int c=0,left=0,right=0,sum=0;

        while(right<arr.length) {
          
            sum+=arr[right];

            while(sum>goal) {
                sum-=arr[left];
                left++;
                
            }
            c+=right-left+1;
            right++;
        }

        return c;
    }

    private static int findSum1(int[] arr, int goal) {
        int c=0;
        for(int i=0;i<arr.length;i++) {
            int sum=0;
            for(int j=i;j<arr.length;j++) {
                sum+=arr[j];
                if(sum==goal)
                c++;
            }
            
        }
        return c;
    }
}
