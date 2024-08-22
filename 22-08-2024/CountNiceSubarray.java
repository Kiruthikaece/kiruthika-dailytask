import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountNiceSubarray {
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
        int res1=countArr1(arr,k);
        System.out.println(res1);

        int res2=countArr2(arr,k);
        System.out.println(res2);
    }

    private static int countArr1(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int prefSum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        for (int i = 0; i < n; i++) {
            prefSum += (nums[i] % 2 == 1) ? 1 : 0;
            ans += freq.getOrDefault(prefSum - k, 0);
            freq.put(prefSum, freq.getOrDefault(prefSum, 0) + 1);
        }
        return ans;
    }

    private static int numSubarrays(int[] nums, int goal) {
        int i = 0, j = 0, n = nums.length, count = 0, ans = 0;

        while (j < n) {
            if (nums[j] % 2 == 1) count++;
            while (i <= j && count > goal) {
                if (nums[i] % 2 == 1) count--;
                i++;
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }

    public static int countArr2(int[] nums, int k) {
        return numSubarrays(nums, k) - 
               numSubarrays(nums, k - 1);
    }
    
}


