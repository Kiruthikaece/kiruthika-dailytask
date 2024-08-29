import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HarmoniousSubsequence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
       
        int res1=findSubsequence1(arr);
        System.out.println(res1);

        long res2=findSubsequence2(arr);
        System.out.println(res2);
    }

    private static int findSubsequence1(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        int res=0;
        for(int key:map.keySet()) {
            if(map.containsKey(key+1)) 
            res=Math.max(res,map.get(key)+map.get(key+1));
        }

        return res;
    }

    private static int findSubsequence2(int[] nums) {
        Arrays.sort(nums);
        int maxLength = 0;
        int i = 0;
        int j = 0;
        int equal = 0;
        int greater = 0;

        while (j < nums.length) {
            if (nums[j] == nums[i]) {
                equal++;
                j++;
            }
            else if (nums[j] - nums[i] == 1) {
                greater++;
                j++;
            }
            if (j == nums.length || nums[j] - nums[i] > 1) {
                if (greater == 0) {
                    i = i + equal;
                    equal = 0;
                }
                                else {
                    maxLength = Math.max(maxLength, equal + greater);
                    i = i + equal;
                    equal = greater;
                    greater = 0;
                }
                
            }

        }

        return maxLength;
    }
}