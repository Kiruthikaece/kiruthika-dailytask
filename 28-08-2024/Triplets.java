import java.util.Scanner;

public class Triplets {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array1 length");
        int n=sc.nextInt();
        int[] arr1=new int[n];
        System.out.println("Enter array1:");
        for(int i=0;i<n;i++)
        arr1[i]=sc.nextInt();

        boolean res1=findTriplets1(arr1);
        System.out.println(res1);

        boolean res2=findTriplets2(arr1);
        System.out.println(res2);
    }

    private static boolean findTriplets1(int[] nums) {
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++) {
            if(nums[i]<=a)
            a=nums[i];
            else if(nums[i]<=b)
            b=nums[i];
            else
            return true;
        }
        return false;
    }

    private static boolean findTriplets2(int[] nums) {
        if(nums.length<3) 
        return false;
        
     int prev1=Integer.MAX_VALUE;
     int prev2=Integer.MAX_VALUE;

         for(int i=0;i<nums.length;i++){
            if(nums[i]>prev2 && prev2>prev1){
                   return true;
            }
            if(nums[i]>prev1){
                prev2=nums[i];
            }
            else{
                prev1=nums[i];
            }
         }
         return false;
    }
}
