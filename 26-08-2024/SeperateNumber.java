import java.util.Scanner;

public class SeperateNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string:");
        String s=sc.next();
        String res=seperateNumber1(s);
        System.out.println(res);
        String res1=seperateNumber2(s);
        System.out.println(res1);
    }

    private static String  seperateNumber1(String s) {
        
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            long firstNum = Long.parseLong(s.substring(0, i));
            StringBuilder expectedSequence = new StringBuilder();
            long currentNum = firstNum;
            
            while (expectedSequence.length() < n) {
                expectedSequence.append(currentNum);
                currentNum++;
            }
            
            if (expectedSequence.toString().equals(s)) {
               return "YES " + firstNum; 
            }
        }
         return "NO";
    }

    public static String seperateNumber2(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            long firstNum = Long.parseLong(s.substring(0, i));
            long currentNum = firstNum;
            int j = i;
            boolean valid = true;
            
            while (j < s.length()) {
                currentNum++;
                String nextNumStr = Long.toString(currentNum);
                if (s.startsWith(nextNumStr, j)) {
                    j += nextNumStr.length();
                } else {
                    valid = false;
                    break;
                }
            }
            
            if (valid) {
                 return "YES " + firstNum;
            }
        }
         return "NO";
    }
}
