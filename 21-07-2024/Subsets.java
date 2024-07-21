
import java.util.*;

public class Subsets {
    
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
    List<List<Integer>> res1=subsetsWithDup1(arr);
    System.err.println(res1);
    List<List<Integer>> res2=subsetsWithDup2(arr);
    System.err.println(res2);
    List<List<Integer>> res3=subsetsWithDup3(arr); 
    System.err.println(res3);
}


    public static List<List<Integer>> subsetsWithDup1(int[] nums) {
       
        Set<List<Integer>> set=new HashSet<>();
        Arrays.sort(nums);
        subsetsDup(nums,0,new ArrayList<>(),set);
         List<List<Integer>> res=new ArrayList<>(set);
        return res;
    }

     public static  void subsetsDup(int[] nums,int index,List<Integer> li,Set<List<Integer>> res) {
           if(index==nums.length) {
            if(!res.contains(li)) 
            res.add(new ArrayList<>(li));
            return;
           }
           li.add(nums[index]);
           subsetsDup(nums,index+1,li,res);
           li.remove(li.size()-1);
           subsetsDup(nums,index+1,li,res);
     }

     public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        int n = nums.length;
        int numSubsets = 1 << n;

        for (int i = 0; i < numSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            res.add(subset);
        }

        return new ArrayList<>(res);
    }

    public static List<List<Integer>> subsetsWithDup3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int start = 0,end=0;

        for (int i = 0; i < nums.length; i++) {
            start = 0;
            if (i > 0 && nums[i] == nums[i - 1]) {
                start = end;
            }
            end = res.size();
            for (int j = start; j < end; j++) {
                List<Integer> subset = new ArrayList<>(res.get(j));
                subset.add(nums[i]);
                res.add(subset);
            }
        }

        return res;
    }
}
