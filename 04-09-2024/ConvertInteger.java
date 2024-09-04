import java.util.Arrays;
import java.util.Scanner;

public class ConvertInteger {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();

        int[] res1=convertInteger1(n);
        System.out.println(Arrays.toString(res1));

        int[] res2=convertInteger2(n);
        System.out.println(Arrays.toString(res2));
    }

    private static int[] convertInteger1(int n) {
        for(int i=1;i<n;i++)
          if(nonZero(i) && nonZero(n-i))
          return new int[]{i,n-i};

          return new int[]{-1,-1};
    }

    public static boolean nonZero(int n) {
         while (n > 0) {
            if (n % 10 == 0) return false;
            n /= 10;
        }
        return true;
    }
    

    public static int[] convertInteger2(int n) {
        for (int a = 1;; ++a) {
            int b = n - a;
            if (!(a + "" + b).contains("0")) {
                return new int[] {a, b};
            }
        }
    }
}