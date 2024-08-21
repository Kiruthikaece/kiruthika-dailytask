
import java.util.Scanner;

public class MinimumFlips {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a");
        int a=sc.nextInt();
        System.out.println("Enter b");
        int b=sc.nextInt();
        System.out.println("Enter c");
        int c=sc.nextInt();
        int res1=minimumOperation(a,b,c);
        System.out.println(res1);

        int res2=minimumOperation1(a,b,c);
        System.out.println(res2);
    }

    private static int minimumOperation(int a, int b, int c) {
        String f=Integer.toBinaryString(a);
        String s=Integer.toBinaryString(b);
        String cc=Integer.toBinaryString(c);

        int max=Math.max(f.length(),Math.max(s.length(),cc.length()));

         f = String.format("%" + max + "s", f).replace(' ', '0');
         s = String.format("%" + max + "s", s).replace(' ', '0');
         cc = String.format("%" + max + "s", cc).replace(' ', '0');


       int count=0;

           for(int i=0;i<max;i++) {
           char fc = f.charAt(i);
           char sc = s.charAt(i);
           char ccChar = cc.charAt(i);

           if (ccChar == '1') {
              
               if (fc != '1' && sc != '1') {
                   count++;
               }
           } else {
               
               if (fc == '1') {
                   count++;
               }
               if (sc == '1') {
                   count++;
               }
           }
           }

           return count;
    }

    public static int minimumOperation1(int a, int b, int c) {
        int flip = 0;
        while (a != 0 || b != 0 || c != 0) {
            int aBit = a & 1;
            int bBit = b & 1;
            int cBit = c & 1;
            
            if (cBit == 1) {
                if (aBit == 0 && bBit == 0) {
                    flip++;
                }
            } else {
                flip += aBit + bBit; 
            }
            
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return flip;
    }
}
