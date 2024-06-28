import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class MaximumNestingParaenthesis {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("EnterString:");
        String s=sc.next();
        int res1=findMaximumNestingParenthesis1(s);
        System.out.println("Maximum Nesting Parenthesis:"+res1);

        int res2=findMaximumNestingParenthesis2(s);
        System.out.println("Maximum Nesting Parenthesis:"+res2);
       
        int res3=findMaximumNestingParenthesis3(s);
        System.out.println("Maximum Nesting Parenthesis:"+res3);
    }

    //soln-1
    public static int findMaximumNestingParenthesis1(String s) {
            int count=0,maxCount=0;
            for(int i=0;i<s.length();i++) {
                if(s.charAt(i)=='(')
                count++;
                else if(s.charAt(i)==')')
                count--;
                maxCount=Math.max(maxCount,count);
            }

            return maxCount;
    }

    //soln-2
    public static int findMaximumNestingParenthesis2(String s) {
       int maxCount=0;
       Stack<Character> stack=new Stack<>();
       for(int i=0;i<s.length();i++) {
        if(s.charAt(i)=='(')
        stack.push(s.charAt(i));
        else if(s.charAt(i)==')' && !stack.isEmpty()) {
            maxCount=Math.max(maxCount,stack.size());
                stack.pop();
        }
       }

       return maxCount;
    }

    //soln-3
    public static int findMaximumNestingParenthesis3(String s) {
     ArrayDeque<Character> st = new ArrayDeque<>();
     int ans = 0;
 
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            } else if (s.charAt(i) == ')') {
                ans = Math.max(ans, st.size());
                st.pop();
            }
        }
        return ans;
    }
        
}
