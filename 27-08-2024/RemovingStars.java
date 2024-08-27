import java.util.Scanner;
import java.util.Stack;

public class RemovingStars {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter string:");
            String s=sc.next();
            String res1=removeStars1(s);
            System.out.println(res1);

            String res2=removeStars2(s);
            System.out.println(res2);
           
        }

        private static String removeStars2(String s) {
             
            StringBuilder str=new StringBuilder();

            for(int i=0;i<s.length();i++) {
                if(s.charAt(i)=='*' && i!=0 && str.length()>0) {
                    str.deleteCharAt(str.length()-1);
                } else
                  str.append(s.charAt(i));
            }
            return str.toString();
        }

        private static String removeStars1(String s) {
           Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='*' && !stack.isEmpty())
            stack.pop();
            else
            stack.push(s.charAt(i));
        }

        String str="";
        while(!stack.isEmpty())
        str=stack.pop()+str;

        return str;
        }
}