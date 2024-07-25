
import java.util.*;

public class GenerateParenthesis {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        List<String> res1=generateParenthesis1(n);
        System.out.println(res1);
        List<String> res2=generateParenthesis2(n);
        System.out.println(res2);
    }

    private static List<String> generateParenthesis1(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static List<String> generateParenthesis2(int n) {
        List<List<String>> dp = new ArrayList<>();
        dp.add(Collections.singletonList(""));

        for (int i = 1; i <= n; i++) {
            List<String> currentList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String first : dp.get(j)) {
                    for (String second : dp.get(i - 1 - j)) {
                        currentList.add("(" + first + ")" + second);
                    }
                }
            }
            dp.add(currentList);
        }

        return dp.get(n);
    }
}

