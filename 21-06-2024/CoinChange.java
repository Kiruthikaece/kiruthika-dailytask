import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoinChange {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter Amount:");
        int amount=sc.nextInt();
        int res1=coinChange1(arr,amount);
        System.out.println("Minimum coins:"+res1);

        int res2=coinChange2(arr,amount);
        System.out.println("Minimum coins:"+res2);
    }

    //soln-2
    private static int coinChange2(int[] coins, int amount) {
         if (amount == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int result = coinChangeRecursion(coins, amount, map);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int coinChangeRecursion(int[] coins, int amount, Map<Integer, Integer> map) {
        if (amount < 0) return Integer.MAX_VALUE;
        if (amount == 0) return 0;
        if (map.containsKey(amount)) return map.get(amount);

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeRecursion(coins, amount - coin, map);
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, res + 1);
            }
        }

        map.put(amount, minCoins);
        return minCoins;
    }

//soln-1
    private static int coinChange1(int[] coins, int amount) {
             int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, amount + 1);
        minCoins[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coins[j]]);
                }
            }
        }

        return minCoins[amount] != amount + 1 ? minCoins[amount] : -1;        
    }
}
