import java.util.Scanner;
import java.util.StringTokenizer;

public class ValidateIp {
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter string:");
            String s=sc.next();
            boolean res1=validateIP1(s);
            System.out.println(res1);

            boolean res2=validateIP2(s);
            System.out.println(res2);
    }

    private static boolean validateIP2(String str) {

            StringTokenizer tokenizer = new StringTokenizer(str, ".");
            if (tokenizer.countTokens() != 4) {
                return false;
            }
            while (tokenizer.hasMoreTokens()) {
                String part = tokenizer.nextToken();
                if (part.length() == 0 || part.length() > 3) {
                    return false;
                }
                if (part.charAt(0) == '0' && part.length() > 1) {
                    return false;
                }
                for (char c : part.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        return false;
                    }
                }
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return false;
                }
            }
            return true;
        }

    private static boolean validateIP1(String str) {
        String[] s=str.split("\\.");
       
        if(s.length!=4)
        return false;
        
        for(String st:s) {
            if(st.length()==0 || st.length()>3)
            return false;
            
            if(st.charAt(0)=='0' && st.length()>1)
            return false;
            
            for(int i=0;i<st.length();i++)
            if(!Character.isDigit(st.charAt(i)))
            return false;
            
            int num=Integer.parseInt(st);
            if(num<0 || num>255)
            return false;
            
        }
        
         return true;
    }
}
