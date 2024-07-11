import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SingleNumber {
     public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
    System.out.println("Enter array:");
	int[] arr=new int[n];
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	int res1=singleNumber1(arr);
    System.out.println("Single number:"+res1);
    int res2=singleNumber2(arr);
    System.out.println("Single number:"+res2);
    int res3=singleNumber3(arr);
    System.out.println("Single number:"+res3);
}

    private static int singleNumber3(int[] arr) {
          Map<Integer,Integer> map=new HashMap<>();
        int res=0;

          for(int i=0;i<arr.length;i++)
          map.put(arr[i],map.getOrDefault(arr[i],0)+1);

          for(Map.Entry<Integer,Integer> mpp:map.entrySet())
          if(mpp.getValue()==1)
          res=mpp.getKey();

          return res;
    }

    private static int singleNumber2(int[] arr) {
        int singleNo=0;
         for(int i=0;i<arr.length;i++) {
            int count=1;
            for(int j=i+1;j<arr.length;j++) 
            if(arr[i]==arr[j]) {
                arr[j]=Integer.MIN_VALUE;
                count++;
            }
           
            if(count==1 && arr[i]!=Integer.MIN_VALUE)
            singleNo=arr[i];
         }

         return singleNo;
    }

    private static int singleNumber1(int[] nums) {
        int xor=0;
          for(int i=0;i<nums.length;i++)
            xor^=nums[i];

            return xor;
    }
}