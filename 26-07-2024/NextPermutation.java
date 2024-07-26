import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class NextPermutation {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	int[] res1=nextPermutation1(arr);
    System.err.println(Arrays.toString(res1));
    int[] res2=nextPermutation2(arr);
    System.err.println(Arrays.toString(res2));
	
}

public static int[] nextPermutation1(int[] nums) {
    int n = nums.length;
    int[] result = nums.clone(); 

    int i = n - 2;
    while (i >= 0 && result[i] >= result[i + 1]) {
        i--;
    }

    if (i >= 0) {
      
        int j = n - 1;
        while (j >= 0 && result[j] <= result[i]) {
            j--;
        }
        swap(result, i, j);
    }
    reverse(result, i + 1, n - 1);
    return result;
}

private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

private static void reverse(int[] nums, int start, int end) {
    while (start < end) {
        swap(nums, start, end);
        start++;
        end--;
    }
}

 public static int[] nextPermutation2(int[] nums) {
        List<List<Integer>> allPermutations = new ArrayList<>();
        permute(nums, 0, allPermutations);
        Collections.sort(allPermutations, (a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });

        for (int i = 0; i < allPermutations.size(); i++) {
            if (isEqual(allPermutations.get(i), nums)) {
                List<Integer> nextPerm = i == allPermutations.size() - 1 ? allPermutations.get(0) : allPermutations.get(i + 1);
                int[] result = new int[nums.length];
                for (int j = 0; j < nums.length; j++) {
                    result[j] = nextPerm.get(j);
                }
                return result;
            }
        }
        return nums; 
    }

    private static void permute(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) permutation.add(num);
            result.add(permutation);
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permute(nums, start + 1, result);
                swap(nums, start, i);
            }
        }
    }

    private static boolean isEqual(List<Integer> a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            if (!a.get(i).equals(b[i])) return false;
        }
        return true;
    }
}