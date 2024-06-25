import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        System.out.println("Enter array:");
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter target:");
        int k=sc.nextInt();
        int res1=findSum1(arr,k);
        System.out.println("closest sum:"+res1);
        int res2=findSum2(arr,k);
        System.out.println("closest sum:"+res2);
    }

    private static int findSum1(int[] arr,int k) {
         Arrays.sort(arr);
         int closestSum = arr[0] + arr[1] + arr[2];  

    for (int i = 0; i < arr.length - 2; i++) {
        int left = i + 1;
        int right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[i] + arr[left] + arr[right];
            if (Math.abs(currentSum - k) < Math.abs(closestSum - k)) {
                closestSum = currentSum;  
            }

            if (currentSum < k) {
                left++;
            } else if (currentSum > k) {
                right--;
            } else {
                return currentSum;  
            }
        }
    }

    return closestSum;
    }


    public static int findSum2(int[] nums, int target) {
        int closestSum = nums[0] + nums[1] + nums[2];
        int n = nums.length;
    
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int currentSum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                        closestSum = currentSum;
                    }
                }
            }
        }
    
        return closestSum;
    }
}
