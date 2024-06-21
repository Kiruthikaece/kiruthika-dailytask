import java.util.Scanner;

public class CountingBits {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number:");
        int n=sc.nextInt();
        int[] res1=countBits1(n);
        for(int x:res1)
        System.out.print(x+" ");
        System.out.println();

        int[] res2=countBits2(n);
        for(int x:res2)
        System.out.print(x+" ");
        System.out.println();

        int[] res3=countBits3(n);
        for(int x:res3)
        System.out.print(x+" ");
        System.out.println();

    }

    //soln-1
    public static int[] countBits3(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }

     //soln-2
    public static int[] countBits2(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

     //soln-3
    private static int[] countBits1(int n) {
        int[] res=new int[n+1];
        for(int i=0;i<=n;i++) {
            String x=Integer.toBinaryString(i);
            int count=0;
            for(int j=0;j<x.length();j++)
            if(x.charAt(j)=='1')
            count++;

            res[i]=count;
        }

        return res;
    }
}
