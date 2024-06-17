import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        List<List<Integer>> li1= threeSum1(arr);
        System.out.println(li1);
        List<List<Integer>> li2= threeSum2(arr);
        System.out.println(li2);
        List<List<Integer>> li3= threeSum3(arr);
        System.out.println(li3);
    }

    private static List<List<Integer>> threeSum1(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length-2;i++) {
            if (i>0 && nums[i]==nums[i - 1])
             continue;
            
            int left = i+ 1;
            int right = nums.length-1;
            
            while (left<right) {
                int sum = nums[i] +nums[left]+nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; 
                    while (left < right && nums[right] == nums[right - 1]) right--; 
                    left++;
                    right--;
                }
                 else if (sum < 0)
                    left++;
                else 
                    right--;
                
            }
        }
        
        return result;
    }
      public static List<List<Integer>> threeSum2(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) 
            continue; 
            
            Set<Integer> seen = new HashSet<>();
            int target = -nums[i];
            
            for (int j = i + 1; j < nums.length; j++) {
                if (seen.contains(target - nums[j])) {
                    result.add(Arrays.asList(nums[i], target - nums[j], nums[j]));
                }
                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(result);
    }
   public static List<List<Integer>> threeSum3(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        triplet.sort(Integer::compareTo);
                        result.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }
}
