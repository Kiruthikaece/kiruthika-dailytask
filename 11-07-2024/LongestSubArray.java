import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubArray {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
    System.out.println("Enter array:");
	int[] arr=new int[n];
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	int res1=getLongestSubarray1(arr);
    System.out.println("Longest Subarray with sum:"+res1);
    int res2=getLongestSubarray2(arr);
    System.out.println("Longest Subarray with sum:"+res2);
}

private static int getLongestSubarray1(int[] arr) {
       Map<Integer,Integer> map=new HashMap<>();
       int sum=0,max=0;
       for(int i=0;i<arr.length;i++) {
        sum+=arr[i];
        if(sum==0)
        max=i+1;
        else {
            if(map.get(sum)!=null) 
            max=Math.max(max,i-map.get(sum));
            else
            map.put(sum,i);
        }
       }

       return max;
}


private static int getLongestSubarray2(int[] arr) {

    int maxCount=0;
     for(int i=0;i<arr.length;i++) {
        int sum=arr[i];
        for(int j=i;j<arr.length;j++) {
            sum+=arr[j];
            if(sum==0)
            maxCount=Math.max(maxCount,j-i+1);
        }
        
     }

     return maxCount;
}
}