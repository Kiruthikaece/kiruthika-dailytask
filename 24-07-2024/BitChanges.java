
import java.util.Scanner;

public class BitChanges {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.err.println("Enter n:");
        int n=sc.nextInt();
        System.err.println("Enter k:");
        int k=sc.nextInt();
        int res1=bitManipulation1(n,k);
        System.err.println(res1);
        int res2=bitManipulation2(n,k);
        System.err.println(res2);
        int res3=bitManipulation3(n,k);
        System.err.println(res3);
    }

    //soln-1
    private static int bitManipulation1(int n, int k) {
       
        if((n|k)!=n)
        return -1;
        
        if(n==k)
        return 0;

        String t1="";
        String t2="";

        while(n!=0) {
            if(n%2==0)
            t1+='0';
            else
            t1+='1';
            n=n/2;
        }

        
        while(k!=0) {
            if(k%2==0)
            t2+='0';
            else
            t2+='1';
            k=k/2;
        }

        int count=0;
        for(int i=0;i<t1.length();i++)
        if(t1.charAt(i)=='1')
        count++;

        for(int i=0;i<t2.length();i++)
        if(t1.charAt(i)=='1' && t2.charAt(i)=='1')
        count--;


        return count;
    }

    //soln-2
    public static int bitManipulation2(int n, int k) {
            String binaryn = Integer.toBinaryString(n);
            String binaryk = Integer.toBinaryString(k);
        
            if (binaryk.length() > binaryn.length()) {
                return -1;
            }
        
            int maxLength = Math.max(binaryn.length(), binaryk.length());
            binaryn = String.format("%" + maxLength + "s", binaryn).replace(' ', '0');
            binaryk = String.format("%" + maxLength + "s", binaryk).replace(' ', '0');
        
            int changes = 0;
            for (int i = 0; i < maxLength; i++) {
                char bn = binaryn.charAt(i);
                char bk = binaryk.charAt(i);
        
                if (bk == '1' && bn == '0') {
                    return -1;
                } else if (bn == '1' && bk == '0') {
                    changes++;
                }
            }
        
            return changes;
        }

        //soln-3
        public static int bitManipulation3(int n, int k) {
            if ((n | k) != n) {
                return -1;
            }
            int changes = 0;
            while (n > 0) {
                if ((n & 1) == 1 && (k & 1) == 0) {
                    changes++;
                }
                n >>= 1;
                k >>= 1;
            }
            return changes;
        }
}
