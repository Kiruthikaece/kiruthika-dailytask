import java.util.Scanner;

public class SearchArr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter target:");
        int target=sc.nextInt();
        int res1=rotataionArr1(arr,target);
        System.out.println("target index:"+res1);
      
    }
    //soln-1
    public static int rotataionArr1(int[] arr,int target) {
        if(arr[0]==target)
        return 0;
        int count=0;
         
        while(arr[0]!=target) {
           int temp=arr[0];
           for(int i=0;i<arr.length-1;i++)
           arr[i]=arr[i+1];

           arr[arr.length-1]=temp;
           count++;
        }

        if(count==arr.length)
        return -1;
        else
        return count;
    }
}
