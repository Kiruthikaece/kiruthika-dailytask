import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutation {
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	List<List<Integer>> res1=permutation1(arr);
    System.out.println(res1);
    List<List<Integer>> res2=permutation2(arr);
    System.out.println(res2);
}

    private static List<List<Integer>> permutation2(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        getPermutation2(res, new ArrayList<Integer>(), arr);
        return res;
}

    private static List<List<Integer>> permutation1(int[] arr) {
          List<List<Integer>> res=new ArrayList<>();
          boolean[] pick=new boolean[arr.length];
          getPermutation1(arr,res,new ArrayList<>(),pick);
          return res;
    }

    private static void getPermutation2(List<List<Integer>> res, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp)); 
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!temp.contains(nums[i])) {
                temp.add(nums[i]);
                getPermutation2(res, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static void getPermutation1(int[] arr, List<List<Integer>> res, ArrayList<Integer> list, boolean[] pick) {
      if(list.size()==arr.length) {
        res.add(new ArrayList<>(list));
        return;
      }

      for(int i=0;i<arr.length;i++) {
        if(!pick[i]) {
            list.add(arr[i]);
            pick[i]=true;
            getPermutation1(arr,res,list,pick);
            list.remove(list.size()-1);
            pick[i]=false;
        }
      }

     

    
    }


}