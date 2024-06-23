import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length");
        int n=sc.nextInt();
        System.out.println("Enter array");
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter distance");
        int k=sc.nextInt();
        boolean res1=isContainDuplicate1(arr,k);
        System.out.println(res1);
        boolean res2=isContainDuplicate2(arr,k);
        System.out.println(res2);
        boolean res3=isContainDuplicate3(arr,k);
        System.out.println(res3);

    }

    public static boolean isContainDuplicate3(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length && j <= i + k; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

     public static  boolean isContainDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
 }
    private static boolean isContainDuplicate1(int[] nums, int k) {
         HashMap<Integer, Integer> valueIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (valueIndexMap.containsKey(nums[i])) {
                int j = valueIndexMap.get(nums[i]);
             
                if (Math.abs(i - j) <= k) {
                    return true; 
                }
            }
            valueIndexMap.put(nums[i], i);
        }
        return false;
    }
}
