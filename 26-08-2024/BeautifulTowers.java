import java.util.Scanner;

public class BeautifulTowers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter arr:");
       for(int i=0;i<n;i++)
       arr[i]=sc.nextInt();
       long res1=maximumSumOfHeights1(arr);
        System.out.println(res1);
        long res2=maximumSumOfHeights2(arr);
        System.out.println(res2);
    }

    private static long maximumSumOfHeights2(int[] arr) {
        long ans = 0;
        int n =arr.length;
        for(int i = 0 ;i<arr.length ;i++){
            ans=Math.max(ans,helper(i,arr));
        }
        
        return ans;
    }


    public static long helper(int ind , int[] arr){
         int n =arr.length;
        int [] heights = new int [n];
        heights[ind]=arr[ind];
        int i = ind-1;
        while(i>=0){
            if(heights[i+1]<arr[i]){
                heights[i]=heights[i+1];
            }else{
                 heights[i]=arr[i];
            }
            i--;
        }
         i=ind+1;
        while(i<n){
            if(heights[i-1]<arr[i]){
                heights[i]=heights[i-1];
            }else{
                 heights[i]=arr[i];
            }
            i++;
        }
        long ans = 0;
        for(int p = 0 ;p<n ;p++){
            ans+=heights[p];
        }
        return ans;
    }
    private static long maximumSumOfHeights1(int[] arr) {
        int n=arr.length; long max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            long sum=arr[i], left=arr[i], right=arr[i];
            for(int j=i+1;j<n;j++) {
                left=Math.min(left, arr[j]);
                sum+=left;
            }
            for(int j=i-1; j>=0; j--) {
                right=Math.min(right, arr[j]);
                sum+=right;
            }
            max=Math.max(max, sum);
        }
        return max;
    }
     
}
