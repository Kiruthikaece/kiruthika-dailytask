import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyStrings {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter num1");
        String num1=sc.next();
        System.out.println("Enter num2");
        String num2=sc.next();

        String t1=multiplyString1(num1,num2);
        System.out.println("output:"+t1);

        String t2=multiplyString2(num1,num2);
        System.out.println("output:"+t2);

        String t3=multiplyString3(num1,num2);
        System.out.println("output:"+t3);

    }

    private static String multiplyString1(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }


     public static String multiplyString2(String num1, String num2) {
        BigInteger big1 = new BigInteger(num1);
        BigInteger big2 = new BigInteger(num2);
        BigInteger result = big1.multiply(big2);
        return result.toString();
    }


    public static String multiplyString3(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
       
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
    
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  
        
        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
