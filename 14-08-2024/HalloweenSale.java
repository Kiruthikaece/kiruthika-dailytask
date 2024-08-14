import java.util.Scanner;

public class HalloweenSale {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter P");
    int p=sc.nextInt();
    System.out.println("Enter d");
    int d=sc.nextInt();
    System.out.println("Enter m");
    int m=sc.nextInt();
    System.out.println("Enter s");
    int s=sc.nextInt();
    int res1=findSale1(p,d,m,s);
    System.out.println(res1);

    int res2=findSale2(p,d,m,s);
    System.out.println(res2);

    int res3=findSale3(p,d,m,s);
    System.out.println(res3);
    }

    private static int findSale2(int p, int d, int m, int s) {
        int count = 0;
        int totalCost = 0;
        while (p > m && totalCost + p <= s) {
            totalCost += p;
            p -= d;
            count++;
        }
        while (totalCost + m <= s) {
            totalCost += m;
            count++;
        }

        return count;
    }

    private static int findSale1(int p, int d, int m, int s) {
        int count = 0;
        while (s >= p) {
            s -= p;
            count++;
            p = Math.max(p - d, m);  
        }
        return count;
    }

    public static int findSale3(int p, int d, int m, int s) {
        if (s < p) {
            return 0;  
        }
        return 1 + findSale3(Math.max(p - d, m), d, m, s - p);
    }

}
