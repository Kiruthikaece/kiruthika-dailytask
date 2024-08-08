import java.util.Scanner;
import java.util.Stack;

public class ClearDigits {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string:");
        String str=sc.next();
        String res1=clearDigits1(str);
        System.out.println(res1);
        String res2=clearDigits2(str);
        System.out.println(res2);
        String res3=clearDigits3(str);
        System.out.println(res3);
    }

    private static String clearDigits1(String s) {
       
        StringBuilder str=new StringBuilder();
        int i=0;
      while(i<s.length()) {
        if(s.charAt(i)>='0' && s.charAt(i)<='9' && i>0) 
             str.deleteCharAt(str.length()-1);    
        else
         str.append(s.charAt(i));
         i++;
      }

      return str.toString();
    }

    private static String clearDigits2(String str) {
        Stack<Character> stack=new Stack<>();
        StringBuilder s=new StringBuilder();
        int i=0;
        while(i<str.length()) {
            if(!stack.isEmpty() && Character.isDigit(str.charAt(i)))
            stack.pop();
            else
            stack.push(str.charAt(i));
            i++;
        }

        while(!stack.isEmpty()) {
                s.append(stack.pop());
        }
        
        return s.reverse().toString();
    }


    public static String clearDigits3(String s) {
        String result = "";
		StringBuilder sb = new StringBuilder(s);
		for(int i=0; i<s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				result = result.substring(0, result.length() - 1);
			}else {
				result = result + s.charAt(i);
			}
		}
		return result;
    }

}