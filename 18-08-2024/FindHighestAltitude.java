import java.util.Arrays;
import java.util.Scanner;

public class FindHighestAltitude {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        int res1=findHighestAltitude1(arr);
        System.out.println(res1);

        int res2=findHighestAltitude2(arr);
        System.out.println(res2);

        int res3=findHighestAltitude3(arr);
        System.out.println(res3);
    }

    private static int findHighestAltitude1(int[] gain) {
        int n=gain.length;
        int[] prefix=new int[n+1];

        prefix[0]=0;
        int max=0;
        for(int i=1;i<n+1;i++) {
            prefix[i]=prefix[i-1]+gain[i-1];
        }

        for(int i=1;i<n+1;i++)
        if(prefix[i]>max)
        max=prefix[i];

        return max;
        
    }

    private static int findHighestAltitude2(int[] gain) {
       
            int n = gain.length;
            int prefixSum = 0;
            int[] res = new int[n+1];
            res[0]=prefixSum;
            for(int i=0;i<n;i++){
                prefixSum += gain[i];
                res[i+1] = prefixSum;
            }
            Arrays.sort(res);
            return res[n];
        
    }

    private static int findHighestAltitude3(int[] gain) {
    
    
        int sum=0;
        int max=0;
        for(int i=0;i<gain.length;i++)
        {
            sum+=gain[i];
            if(sum>max)
            {
                max=sum;
            }
        }
        return max;
    }
}

