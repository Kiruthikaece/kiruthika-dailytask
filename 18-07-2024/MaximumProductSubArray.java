import java.util.Scanner;

public class MaximumProductSubArray {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	int res1=maximumSubArr1(arr);
    System.out.println("Maximum Product Subarray:"+res1);
    int res2=maximumSubArr2(arr);
    System.out.println("Maximum Product Subarray:"+res2);
}

    private static int maximumSubArr1(int[] arr) {
        int maxProduct=0;
       for(int i=0;i<arr.length;i++) {
        int product=arr[i];
        for(int j=i+1;j<arr.length;j++) {
            maxProduct=Math.max(maxProduct,product);
            product*=arr[j];
        }
        maxProduct=Math.max(maxProduct,product);
       }

       return maxProduct;
    }

    private static int maximumSubArr2(int[] arr) {
        int pre=1,suff=1,res=0;
        for(int i=0;i<arr.length;i++) {
            if(pre==0) pre=1;
            if(suff==0) suff=1;
            pre*=arr[i];
            suff*=arr[arr.length-i-1];
            res=Math.max(res,Math.max(pre,suff));

        }
        return res;
    }
}
