import java.util.Scanner;
import java.util.Stack;

public class RemoveOuterParenthesis {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter String:");
	String str=sc.next();
	
	String res1=RemoveDuplicateElement1(str);
    System.out.println(res1);
	String res2=RemoveDuplicateElement2(str);
    System.out.println(res2);
    String res3=RemoveDuplicateElement3(str);
    System.out.println(res3);
}

    private static String RemoveDuplicateElement1(String s) {
        Stack<Character> bracket = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(bracket.size()>0){
                    sb.append(s.charAt(i));
                }
                bracket.push(s.charAt(i));
            }else{
                bracket.pop();
                if(bracket.size()>0){
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }

    private static String RemoveDuplicateElement2(String s) {
        if(s=="")
        return s;
        int x=0;
        StringBuilder sb=new StringBuilder();
        StringBuilder str=new StringBuilder(s);
        int n=s.length();
        for(int i=0;i<n;i++){
           if(str.charAt(i) == '('){
            if(x>0)
                sb.append("(");
                x++;
            
           }
            else if(str.charAt(i) == ')'){
            x--;
            if(x>0)
            sb.append(")");

           }
        
        }
        return sb.toString();
    }

    private static String RemoveDuplicateElement3(String s) {
        if(s=="")
        return s;
        int x=0;
        StringBuilder sb=new StringBuilder();
        StringBuilder str=new StringBuilder(s);
        int n=s.length();
        for(int i=0;i<n;i++){
           if(str.charAt(i) == '('){
            if(x>0)
                sb.append("(");
                x++;
            
           }
            else if(str.charAt(i) == ')'){
            x--;
            if(x>0)
            sb.append(")");

           }
        
        }
        return sb.toString();

    }
}
