import java.util.Scanner;

public class WaterBottles2 {
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

    public int findBottles1(int numBottles, int numExchange) {
        int res = numBottles;
        int emptyBottles = numBottles;
        int fullBottles = 0;

        while (numExchange <= emptyBottles) {
            while (emptyBottles >= numExchange) {
                fullBottles++;
                emptyBottles -= numExchange;
                numExchange++;
            }

            res += fullBottles;
            emptyBottles += fullBottles;
            fullBottles = 0;
        }

        return res;
    }
    public static int findBottles2(int numBottles, int numExchange) {
        int total=numBottles,ans=numBottles;

        while(numExchange<=total) {
          total-=numExchange;
          total++;
          numExchange++;
          ans++;
        }
        return ans;
  }
}
