import java.util.Scanner;

public class FindMaximumOnes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        int res1=findLength1(arr);
        System.out.println("Maximum 1's count:"+res1);
        int res2=findLength2(arr);
        System.out.println("Maximum 1's count:"+res2);
        int res3=findLength2(arr);
        System.out.println("Maximum 1's count:"+res3);
    }


    //soln-1

    private static int findLength1(int[] arr) {
        int count=0,maxlen=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]==1)
            count++;
            else 
                count=0;
                maxlen=Math.max(maxlen,count);  
        }

        return maxlen;
    }

    //  soln-2
    public static int findLength2(int[] arr) {
          int maxlen=0,start=0;
        while(start<arr.length) {
            if(arr[start]==1) {
                int end=start;
                while(end<arr.length && arr[end]==1 )
                end++;
                maxlen=Math.max(maxlen,end-start);
                start=end;
            }
            else
            start++;
        }
         
        return maxlen;
            
    }
    
    //soln-3 
    public static int findLength3(int[] arr) {
        int maxlen=0;
        int[] dp=new int[arr.length];
        dp[0]=arr[0]==1?1:0;
        for(int i=1;i<arr.length;i++) 
        if(arr[i]==1) {
            dp[i]=dp[i-1]+1;
            maxlen=Math.max(maxlen,dp[i]);
        }
        else
        dp[i]=0;

        return maxlen;
    }
}
