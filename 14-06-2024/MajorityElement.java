import java.util.Arrays;
import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length:");
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

       int res1= majorityElement1(arr);
       System.err.println("Majority element:"+res1);
       int res2= majorityElement2(arr);
       System.err.println("Majority element:"+res2);
       int res3= majorityElement3(arr);
       System.err.println("Majority element:"+res3);
    }

    //soln-1
    public static int majorityElement2(int[] arr) {
        int count=0,element=0;
        for(int i=0;i<arr.length;i++) {
          if(count==0)
          element=arr[i];
          if(arr[i]==element)
          count++;
          else
          count--;
        }

        return element;
     }


    //soln-2
    public static int majorityElement1(int[] arr) {
       int count=1,maxNo=arr[0],maxCount=0;
       Arrays.sort(arr);
       
       for(int i=1;i<arr.length;i++) {
        if(arr[i]==arr[i-1])
        count++;
        else {
            if(maxCount<count) {
                maxCount=count;
                maxNo=arr[i];
                count=0;
            }
        }
       }

       return maxNo;
    }

    //soln-3
    
     public static int majorityElement3(int[] arr) {
        int max=arr[0];
         for(int i=1;i<arr.length;i++)
         if(max<arr[i])
         max=arr[i];

         int[] hash=new int[max+1];
         for(int i=0;i<arr.length;i++)
         hash[arr[i]]++;


         for(int x:hash)
         System.out.print(x+" ");

         int ans=hash[0],index=0;
         for(int i=1;i<hash.length;i++)
         if(ans<hash[i])  {
            ans=hash[i];
            index=i;
         }
         

         return index;

    }
}
