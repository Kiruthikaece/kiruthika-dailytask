import java.util.Scanner;

public class BuySellStock {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        System.out.println("Enter prices:");
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        int res1=findProfit1(arr);
        System.out.println("Maximum profit:"+res1);
        int res2=findProfit2(arr);
        System.out.println("Maximum profit:"+res2);
        int res3=findProfit3(arr);
        System.out.println("Maximum profit:"+res3);
    }

    //soln-1
    public static int findProfit1(int[] arr) {
        int buy=Integer.MAX_VALUE,sell=0;
        for(int i=0;i<arr.length;i++) {
            buy=Math.min(buy,arr[i]);
            sell=Math.max(sell,arr[i]-buy);
        }

        return sell;
    }

     //soln-2
    public static int findProfit2(int[] arr) {
        int maxLen=0;
        for(int i=0;i<arr.length;i++) {
            int sum=0;
            for(int j=i+1;j<arr.length;j++) 
                if(arr[j]>arr[i]) {
                    sum=arr[j]-arr[i];
                    maxLen=Math.max(maxLen,sum);
                }         
        }

        return maxLen;
    }


     //soln-3
    public static int findProfit3(int[] prices) {
        int buyprice = prices[0];
        int maxprofit = 0;

        for(int i=1; i<prices.length; i++) {   
            if( buyprice < prices[i] ) {
                int profit = prices[i] - buyprice;
                maxprofit = Math.max(profit, maxprofit);
            } else {
                buyprice = prices[i];
            }
        }
        return maxprofit;
    }
}