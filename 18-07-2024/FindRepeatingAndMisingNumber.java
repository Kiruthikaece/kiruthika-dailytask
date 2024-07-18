


import java.util.Arrays;
import java.util.Scanner;

public class FindRepeatingAndMisingNumber {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	int[] res1=getRepeatAndMissingNo1(arr);
    System.out.println(Arrays.toString(res1));
    int[] res2=getRepeatAndMissingNo2(arr);
    System.out.println(Arrays.toString(res2));
    int[] res3=getRepeatAndMissingNo3(arr);
    System.out.println(Arrays.toString(res3));
}

//soln-1

    private static int[] getRepeatAndMissingNo1(int[] arr) {
        int[] res=new int[2];
       int max=arr[0];
       for(int i=1;i<arr.length;i++)
       if(arr[i]>max)
       max=arr[i];

       int[] hash=new int[max+1];

       for(int i=0;i<arr.length;i++)
       hash[arr[i]]++;

       for(int i=1;i<arr.length;i++) {
        if(hash[i]==2)
        res[0]=i;
        if(hash[i]==0)
        res[1]=i;
       }

       if(res[1]==0)
       res[1]=arr.length;
       
       return res;

    }

    //soln-2
    private static int[] getRepeatAndMissingNo2(int[] arr) {
      int n=arr.length;

      int sn=n*(n+1)/2;
      int sn2=(n*(n+1)*(2*n+1))/6;

      int sum1=0,sum2=0;

      for(int i=0;i<arr.length;i++) {
        sum1+=arr[i];
        sum2+=arr[i]*arr[i];
      }

      int val1=sum1-sn;
      int val2=sum2-sn2;

      val2=val2/val1;

      int x=(val1+val2)/2;
      int y= x-val1;

      return new int[]{x,y};
    }

    //soln-3

    public static int[] getRepeatAndMissingNo3(int[] arr) {
        int[] res=new int[2];
        for(int i=1;i<arr.length;i++) {
            int count=0;
            for(int j=0;j<arr.length;j++)
            if(arr[j]==i)
            count++;


            if(count==2) 
                res[0]=i;
         
            else if(count==0)
            res[1]=i;
        }

        if(res[1]==0)
        res[1]=arr.length;

        return res;
    }
}
