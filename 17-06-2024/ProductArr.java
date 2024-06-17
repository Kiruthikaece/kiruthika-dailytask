import java.util.Scanner;

public class ProductArr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        productSum1(arr);
        System.out.println(" ");
        int[] res=productSum2(arr,0,0,new int[arr.length],1);
        for(int x:res)
        System.out.print(x+" ");
        System.out.println(" ");
        int[] res2=productSum3(arr);
        for(int x:res2)
        System.out.print(x+" ");
    }

    private static int[] productSum3(int[] nums) {
        int[] arr1=new int[nums.length];
        int[] arr2=new int[nums.length];
        arr1[0]=1;arr2[nums.length-1]=1;
         for(int i=1;i<nums.length;i++)
            arr1[i]=arr1[i-1]*nums[i-1];

            for(int j=nums.length-2;j>=0;j--)
            arr2[j]=arr2[j+1]*nums[j+1];

            for(int i=0;i<nums.length;i++)
            nums[i]=arr1[i]*arr2[i];

            return nums;
    }

    private static int[] productSum2(int[] arr, int i, int j,int[] res,int temp) {
        if (i >= arr.length) 
        return res;
        
        if (j==0) 
        temp=1;
        
        if (i!=j) 
        temp*=arr[j];
        
        j++;

        if (j>=arr.length) {
            res[i]=temp;
            return productSum2(arr, i + 1, 0, res, 1); 
        } else 
            return productSum2(arr, i, j, res, temp);
    }

    private static void productSum1(int[] arr) {
        int[] res=new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            int temp=1;
            for(int j=0;j<arr.length;j++)
            if(i==j)
            continue;
            else
            temp*=arr[j];
            res[i]=temp;
        }

        for(int x:res)
        System.out.print(x+" ");
    }
}