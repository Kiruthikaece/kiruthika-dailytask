import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
    System.out.println("Enter target:");
    int target=sc.nextInt();
	List<List<Integer>> res1=combinationSum1(arr,target);
    System.err.println(res1);
    List<List<Integer>> res2=combinationSum2(arr,target);
    System.err.println(res2);
    List<List<Integer>> res3=combinationSum3(arr,target);
    System.err.println(res3);
}

    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        printCombination(candidates,target,0,new ArrayList<>(),result);
        return result;
    }

    public static void printCombination(int[] arr,int target,int index,List<Integer> li,List<List<Integer>> result) {
        if(index==arr.length) {
            if(target==0)
            result.add(new ArrayList<>(li));
            return;
        }

        if(arr[index]<=target) {
            li.add(arr[index]);
            printCombination(arr,target-arr[index],index,li,result);
            li.remove(li.size()-1);
        }
        printCombination(arr,target,index+1,li,result);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>[] dp = new ArrayList[target + 1];
        for (int i = 0; i <= target; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add(new ArrayList<>());

        for (int num : candidates) {
            for (int i = num; i <= target; i++) {
                for (List<Integer> list : dp[i - num]) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(num);
                    dp[i].add(newList);
                }
            }
        }
        return dp[target];
    }

    public static List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                current.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}