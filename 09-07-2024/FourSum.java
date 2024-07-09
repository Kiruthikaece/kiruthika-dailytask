import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FourSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        System.out.println("Enter arr:");
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter target:");
        int target=sc.nextInt();
        List<List<Integer>> x=fourSum1(arr,target);
        System.out.println(x);
        List<List<Integer>> y=fourSum2(arr,target);
        System.out.println(y);
    }

    //soln-1
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;  
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;  
                        while (left < right && nums[right] == nums[right - 1]) right--;  
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return result;
    }


    //soln-2
    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        
        Arrays.sort(nums);
        Map<Integer, List<int[]>> twoSumMap = new HashMap<>();
        int n = nums.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                if (!twoSumMap.containsKey(sum)) {
                    twoSumMap.put(sum, new ArrayList<>());
                }
                twoSumMap.get(sum).add(new int[]{i, j});
            }
        }
        
        Set<List<Integer>> quadruplets = new HashSet<>();
        
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int remaining = target - nums[i] - nums[j];
                if (twoSumMap.containsKey(remaining)) {
                    for (int[] pair : twoSumMap.get(remaining)) {
                        int k = pair[0];
                        int l = pair[1];
                        if (j < k) {
                            List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            quadruplets.add(quadruplet);
                        }
                    }
                }
            }
        }
        
        result.addAll(quadruplets);
        return result;
    }
}
