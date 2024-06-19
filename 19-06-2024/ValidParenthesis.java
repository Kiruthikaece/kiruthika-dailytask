import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string1:");
        String str=sc.next();
        boolean res1=isValid1(str);
        if(res1)
        System.out.println("valid");
        else
        System.out.println("Not valid");
    }

    //soln-1
    private static boolean isValid1(String str) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{')
            stack.push(str.charAt(i));
            else {
                if(stack.isEmpty())
                return false;
                char top=stack.pop();
                if(str.charAt(i)==')' && top!='(' || str.charAt(i)==']' && top!='[' || str.charAt(i)=='}' && top!='{' )
                return false;
            }
        }

        return stack.isEmpty();

    }

     //soln-2
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>(); 
        for (char c : s.toCharArray()) { 
            if (c == '(') 
                stack.push(')');
            else if (c == '{') 
                stack.push('}');
            else if (c == '[') 
                stack.push(']'); 
            else if (stack.isEmpty() || stack.pop() != c) 
                return false;
        }
        return stack.isEmpty();
    }
}
