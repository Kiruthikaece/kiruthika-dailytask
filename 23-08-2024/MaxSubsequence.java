import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class MaxSubsequence {
    public static void main(String[] args) {
        int[] arr={-1,-2,3,3};
        int k=2;
        int[] res1=maxSubsequence1(arr,k);
        System.out.println(Arrays.toString(res1));
        int[] res2=maxSubsequence2(arr,k);
        System.out.println(Arrays.toString(res2));
    }

    public static int[] maxSubsequence1(int[] nums, int k) {
        int[][] indexedNums = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            indexedNums[i][0] = nums[i];
            indexedNums[i][1] = i;
        }
        Arrays.sort(indexedNums, (a, b) -> Integer.compare(b[0], a[0]));
        int[][] selected = Arrays.copyOfRange(indexedNums, 0, k);
        Arrays.sort(selected, Comparator.comparingInt(a -> a[1]));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = selected[i][0];
        }

        return result;
    }

    public static int[] maxSubsequence2(int[] nums, int k) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        Set<Integer> largestK = new HashSet<>();
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            largestK.add(sorted[i]);
        }
        int[] result = new int[k];
        int index = 0;
        for (int num : nums) {
            if (largestK.contains(num)) {
                result[index++] = num;
                largestK.remove(num); 
            }
            if (index == k) break;
        }

        return result;
    }


}