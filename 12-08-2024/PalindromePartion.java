import java.util.*;

public class PalindromePartion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string:");
        String str=sc.next();
        List<List<String>> s1=new ArrayList<>();
        palindromePartition(str,new ArrayList<>(),s1,0);
        System.out.println(s1);

        List<List<String>> s2=palindromePartion2(str);
        System.out.println(s2);
    }

    private static void palindromePartition(String s,List<String> list, List<List<String>> res, int index) {
        if(index==s.length()) {
           res.add(new ArrayList<>(list));
           return;
        }

        for(int i=index;i<s.length();i++) {
           if(isPalindrome(s,index,i)) {
               list.add(s.substring(index,i+1));
               palindromePartition(s,list,res,i+1);
               list.remove(list.size()-1);
           }
        }
   }

   private static boolean isPalindrome(String s, int start, int end) {
      while(start<end) {
       if(s.charAt(start++)!=s.charAt(end--))
       return false;
      }
      return true;
   }


   public static List<List<String>> palindromePartion2(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    List<List<String>> result = new ArrayList<>();
    List<String> currentList = new ArrayList<>();

    for (int i = n - 1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
            dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i + 1][j - 1]);
        }
    }

    backtrack(s, 0, currentList, result, dp);
    return result;
}

private static void backtrack(String s, int start, List<String> currentList, List<List<String>> result, boolean[][] dp) {
    if (start == s.length()) {
        result.add(new ArrayList<>(currentList));
        return;
    }

    for (int end = start; end < s.length(); end++) {
        if (dp[start][end]) {
            currentList.add(s.substring(start, end + 1));
            backtrack(s, end + 1, currentList, result, dp);
            currentList.remove(currentList.size() - 1);
        }
    }
}
}
