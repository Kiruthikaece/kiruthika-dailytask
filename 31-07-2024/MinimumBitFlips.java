
import java.util.Scanner;

public class MinimumBitFlips {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter start:");
        int start=sc.nextInt();
        System.out.println("Enter goal:");
        int goal=sc.nextInt();
        int res1=bitMainpulation1(start,goal);
        System.out.println(res1);
        int res2=bitMainpulation2(start,goal);
        System.out.println(res2);
        int res3=bitMainpulation3(start,goal);
        System.out.println(res3);
    }

    private static int bitMainpulation1(int start, int goal) {
        int ans=start ^ goal;
        int count=0;
        for(int i=0;i<32;i++){
            if ((ans & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    public static int bitMainpulation2(int start, int goal) {
        int res = 0;
        while (start != 0 || goal != 0) {
            if ((start & 1) != (goal & 1))
                res++;
            start = start >> 1;
            goal = goal >> 1;
        }

        return res;
    }

    public static int bitMainpulation3(int start, int goal) {
        return Integer.bitCount(start^goal);
}
}
