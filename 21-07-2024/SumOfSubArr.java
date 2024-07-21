import java.util.Scanner;
import java.util.Stack;

public class SumOfSubArr {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	int res1= sumOfSubArray1(arr);
    System.out.println(res1);
    int res2= sumOfSubArray2(arr);
    System.out.println(res2);
}

    private static int sumOfSubArray1(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length;i++) {
            for(int j=i;j<arr.length;j++) {
                int min=arr[i];
                for(int k=i;k<=j;k++)
                 if(arr[k]<min) {
                    min=arr[k];
                 }
                
                sum+=min;
            }
           
        }
        return sum;
    }

      
        public static int sumOfSubArray2(int[] arr) {
            int MOD = 1000000007;
            int n = arr.length;
            long sum = 0;
    
            int[] dp = new int[n];
            Stack<Integer> stack = new Stack<>();
    
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }
    
                if (stack.isEmpty()) {
                    dp[i] = arr[i] * (i + 1);
                } else {
                    int j = stack.peek();
                    dp[i] = dp[j] + arr[i] * (i - j);
                }
    
                stack.push(i);
                sum = (sum + dp[i]) % MOD;
            }
    
            return (int) sum;
        
    
    }
}
