import java.util.Scanner;

public class WaterBottles1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of bottels:");
        int bottles=sc.nextInt();
        System.out.println("Enter exchange bottles");
        int exchange=sc.nextInt();
        // int res1=findBottles1(bottles,exchange);
        // System.out.println(res1);

        int res2=findBottles2(bottles,exchange);
        System.out.println(res2);

    }

    private static int findBottles2(int bottles, int exchange) {
        return bottles + (bottles - 1) / (exchange - 1);

    }

    private static int findBottles1(int bottles, int exchange) {
      int totalBottles=0;
      while(bottles>=exchange) {
        totalBottles+=bottles;
        bottles=(bottles%exchange)+(bottles/exchange);
      }
      return totalBottles;
    }
}