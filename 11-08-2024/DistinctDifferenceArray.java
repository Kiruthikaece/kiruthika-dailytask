import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DistinctDifferenceArray {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	int[] res1=findDifferenceArray1(arr);
    System.out.println(Arrays.toString(res1));

    int[] res2=findDifferenceArray2(arr);
    System.out.println(Arrays.toString(res2));
}

    private static int[] findDifferenceArray1(int[] nums) {
      
            int[] arr=new int[nums.length];
            for(int i=0;i<nums.length;i++)
            arr[i]=findPrefix(i,nums)-findSuffix(i,nums);

            return arr;   
    }

    public static int findPrefix(int index,int[]  nums) {
      Set<Integer> set=new HashSet<>();

      for(int i=index;i>=0;i--)
      set.add(nums[i]);

      return set.size();

    }

    public static int findSuffix(int index,int[]  nums) {
      Set<Integer> set=new HashSet<>();

      for(int i=index+1;i<nums.length;i++)
      set.add(nums[i]);

  
      return set.size();
      
    }


     public static int[] findDifferenceArray2(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> prefix = new HashMap<>();
        HashMap<Integer,Integer> suffix = new HashMap<>();
        int[] ans = new int[nums.length];
        

        int k =0;
        for(int i=0; i<nums.length; i++){
            for(int j =0; j<=i; j++){
                if(!prefix.containsKey(nums[j])){
                    prefix.put(nums[j],1);
                }
            }
            int pref_val = prefix.size();
            k++;
            
            int count = 0;
            for(int j = i+1; j<n; j++){
                
                if(!suffix.containsKey(nums[j])){
                    suffix.put(nums[j],1);
                }
                
            }
            int suff_val = suffix.size();
            suffix.clear();

            ans[i] = pref_val - suff_val;
        }
        
        return ans;
    }
}
