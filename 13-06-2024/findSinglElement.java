import java.util.Arrays;
import java.util.Scanner;

public class findSinglElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) 
        arr[i]=sc.nextInt();
        int res1=getSingleNo1(arr);
        System.out.println("answer:"+res1);
        int res2=getSingleNo2(arr);
        System.out.println("answer:"+res2);
        int res3=getSingleNo3(arr);
        System.out.println("answer:"+res3);
    }


    // soln-1
    public static int getSingleNo3(int[] arr) {
        int xor=0;
        for(int i=0;i<arr.length;i++)
        xor=xor^arr[i];

        return xor;
    }

    //soln-2
    public static int getSingleNo1(int[] arr) {
       int singleNo=-1;
       Arrays.sort(arr);
       if(arr.length==0)
       return singleNo;

       if(arr[0]!=arr[1])
       singleNo=arr[0];
       else if(arr[arr.length-1]!=arr[arr.length-2])
       singleNo=arr[arr.length-1];
       else {
        for(int i=1;i<arr.length-1;i++)
        if(arr[i]!=arr[i-1] && arr[i]!=arr[i+1])
        singleNo=arr[i];
       }

       return singleNo;
    }

    //soln-3
    public static int getSingleNo2(int[] nums) {
        int singleNo=-1;
        int max=nums[0];
        for(int i=1;i<nums.length;i++)
        if(max<nums[i])
        max=nums[i];

        int[] hash=new int[max+1];

        for(int i=0;i<nums.length;i++)
        hash[nums[i]]++;

        for(int i=0;i<hash.length;i++)
        if(hash[i]==1)
        singleNo=i;

        return singleNo;
    }

    

}
