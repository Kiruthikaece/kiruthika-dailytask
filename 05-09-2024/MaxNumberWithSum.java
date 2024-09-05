
import java.util.Arrays;
import java.util.HashMap;

public class MaxNumberWithSum {
    public static void main(String[] args) {
       int[] arr={1,2,3,4};
       int k=5;

       int res1=maxOperation1(arr,k);
       System.out.println(res1);

       int res2=maxOperation2(arr,k);
       System.out.println(res2);
    }

    private static int maxOperation1(int[] nums, int k) {
        int ops=0;
        int i=0; 
        int j= nums.length-1;
        Arrays.sort(nums);
        while(i<j){
            if(nums[i]+nums[j]==k){
                ops++;
                i++; j--;
            } else if(nums[i]+nums[j]>k){
                j--;
            } else{
                i++;
            }
        }
        return ops;
    }

    private static int maxOperation2(int[] nums, int k) {
       int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(k-nums[i])){
                System.out.println(k-nums[i]);
                if (nums[i] == k-nums[i] && map.get(nums[i])<2){
                    System.out.println(map);
                    
                    map.remove(nums[i]);
                    continue;
                }
                if (nums[i] == k-nums[i] && map.get(k-nums[i])>1){
                    System.out.println(map);
                    max+=map.get(nums[i])/2;
                    map.remove(nums[i]);
                }else {
                max+=Math.min(map.get(nums[i]),map.get(k-nums[i]));
                map.remove(nums[i]);
                map.remove(k-nums[i]);
            }
            }
        }
        return max;
    }
}
