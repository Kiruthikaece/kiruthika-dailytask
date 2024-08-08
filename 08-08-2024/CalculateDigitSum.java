import java.util.Scanner;

public class CalculateDigitSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
	    System.out.println("Enter String:");
	    String s=sc.next();
        System.out.println("Enter k:");
	    int k=sc.nextInt();
        String res1=calculateSum1(s,k);
        System.out.println(res1);
        String res2=calculateSum2(s,k);
        System.out.println(res2);

    }

    private static String calculateSum1(String s, int k) {
        while(s.length()>k) {
            String t="";
            for(int i=0;i<s.length();i=i+k) {
                String str=s.substring(i,Math.min(i+k,s.length()));
                int sum=0;
                for(int j=0;j<str.length();j++)
                sum+=str.charAt(j)-'0';
    
                t+=sum;
            }
            s=t;
          }
          return s;
    }

    public static String calculateSum2(String s, int k) {
        StringBuilder sb = new StringBuilder();
        String intermediate = s;
        int interInt = 0;
        while (intermediate.length() > k) {
            for (int i = 0; i < intermediate.length(); i += k) {
                for (int j = i; j < i + k && j < intermediate.length(); j++) {
                    interInt += intermediate.charAt(j) - '0';
                }
                sb.append(interInt);
                interInt = 0;
            }
            intermediate = sb.toString();
            sb.setLength(0);
        }
        return intermediate;
    }
}
