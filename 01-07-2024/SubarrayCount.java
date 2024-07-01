import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarrayCount {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length:");
        int n=sc.nextInt();
        System.out.println("Enter array:");
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter sum:");
        int k=sc.nextInt();
        int ans1=findSubarrayCount1(arr,k);
        System.out.println("subarray count:"+ans1);
        int ans2=findSubarrayCount2(arr,k);
        System.out.println("subarray count:"+ans2);
        int ans3=findSubarrayCount3(arr,k);
        System.out.println("subarray count:"+ans3);
    }

    //soln-1
    public static int findSubarrayCount1(int[] nums,int k) {
        int count=0;
        for(int i=0;i<nums.length;i++) {
            int sum=0;
            for(int j=i;j<nums.length;j++) {
            sum+=nums[j];
            if(sum==k)
            count++;
            }
           
        }

        return count;
    }

    //soln-2
    public static int findSubarrayCount2(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    //soln-3 

    public static int findSubarrayCount3(int[] nums, int k) {
        int count=0;
        int prefixSum=0,removeSum=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++) {
            prefixSum+=nums[i];
            removeSum=prefixSum-k;
            if(map.containsKey(removeSum)) 
            count+=map.get(removeSum);

            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }

        return count;
    }
}