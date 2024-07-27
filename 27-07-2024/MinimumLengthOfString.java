import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class MinimumLengthOfString {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter String:");
	String s=sc.next();
	

    int res2=maxOperation2(s);
    System.err.println(res2);


    // int res3=maxOperation3(s);
    // System.err.println(res3);
}


    private static int maxOperation2(String s) {
         Stack<Character> stack = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.size();
    }

    private static int maxOperation3(String s) {

         int n = s.length(), del = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            int f = entry.getValue();
            del += (f % 2 == 1) ? f - 1 : f - 2;
        }

        return n - del;
    }
}
