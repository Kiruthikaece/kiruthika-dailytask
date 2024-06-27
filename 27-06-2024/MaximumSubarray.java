import java.util.Scanner;

public class MaximumSubarray {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        System.out.println("Enter array:");
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        int res1=findMaximumSubarray1(arr);
        System.out.println("Find Maximum Sum: "+res1);
        int res2=findMaximumSubarray2(arr);
        System.out.println("Find Maximum Sum: "+res2);
        int res3=findMaximumSubarray3(arr,0,0,0,0);
        System.out.println("Find Maximum Sum: "+res3);
    }

    //soln-1
    public static int findMaximumSubarray1(int[] arr) {
        int sum=0,maxlen=Integer.MIN_VALUE;
       for(int i=0;i<arr.length;i++) {
            sum+=arr[i];
            if(sum>maxlen)
            maxlen=sum;
            if(sum<0)
            sum=0;
       }

       return maxlen;
    }

 //soln-2
    public static int findMaximumSubarray2(int[] arr) {
       int maxLen=0;

       for(int i=0;i<arr.length;i++) {
        int sum=0;
        for(int j=i;j<arr.length;j++) {
            sum+=arr[j];
            maxLen=Math.max(sum,maxLen);
        }
       }

       return maxLen;
    }

     //soln-3
    public static int findMaximumSubarray3(int[] arr,int i,int j,int sum,int maxlen) {

        if(i>=arr.length)
        return maxlen;

        if(j>=arr.length) {
            i++;
            j=i;
            sum=0;
        }
        else
        sum+=arr[j];
     
        if(sum>maxlen)
        maxlen=sum;

        return findMaximumSubarray3(arr,i,j+1,sum,maxlen);
    }
}
