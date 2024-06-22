import java.util.Scanner;
import java.util.Stack;

public class ChangeOrder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter input string:");
        String str=sc.nextLine();
        String res1=changeOrder1(str);
        System.out.println("order of string:"+res1);
        String res2=changeOrder2(str);
        System.out.println("order of string:"+res2);
        String res3=changeOrder3(str);
        System.out.println("order of string:"+res3);
    }

     //soln-1
     public static String changeOrder1(String str) {
        String[] arr=str.split(" ");

        StringBuilder s=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--)
        s.append(arr[i]+" ");

        return s.toString();
   }
    

    //soln-2
    private static String changeOrder2(String str) {
        StringBuilder s = new StringBuilder();
        int count = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ' || i == 0) {
                int start = (i == 0) ? i : i + 1; 
                 count = (i==0) ?count+1:count;
                for (int j = start; j < start + count; j++) {
                    s.append(str.charAt(j));
                }
                s.append(" ");
                count = 0;
            } else {
                count++;
            }
        }
        return s.toString().trim();
    }

   //soln-3
    private static String changeOrder3(String str) {
        Stack<String> stack = new Stack<>();
        StringBuilder s = new StringBuilder();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' || i == str.length() - 1) {              
                if (i == str.length() - 1 && str.charAt(i) != ' ') 
                    count++;
                for (int j = i - count; j < i; j++) 
                    s.append(str.charAt(j));
                
                
                if (i == str.length() - 1 && str.charAt(i) != ' ') 
                    s.append(str.charAt(i));
                
                stack.push(s.toString());
                s.setLength(0);
                count = 0;
            } else {
                count++;
            }
        }

        while (!stack.isEmpty()) {
            s.append(stack.pop());
            if (!stack.isEmpty()) 
                s.append(' ');
        }

        return s.toString();
    }



}
