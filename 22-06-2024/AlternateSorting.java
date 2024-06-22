import java.util.Arrays;
import java.util.Scanner;

public class AlternateSorting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        AlternateSorting obj=new AlternateSorting();
        obj.alternateSort1(arr);
        obj.alternateSort2(arr);
        obj.alternateSort3(arr);
    }

    //soln-1
    public  void alternateSort1(int[] arr) {
            int n=arr.length;
            Arrays.sort(arr);
            int left=0,right=n-1,index=0;
            int[] res=new int[n];

            while(left<=right) {
                if(index%2==0) {
                    res[index]=arr[right];
                    right--;
                }
                else {
                    res[index]=arr[left];
                    left++;
                }
                index++;
            }

            for(int i=0;i<n;i++)
            System.out.print(res[i]+" ");
            System.out.println();
    }

    //soln-2
    public void alternateSort2(int[] arr) {
        int n=arr.length;
        int[] desc=arr.clone();
        int[] res=new int[n];
     

        for(int i=0;i<n;i++) {
        for(int j=i+1;j<n;j++) 
            if(desc[i]<desc[j]) {
                int t=desc[i];
                desc[i]=desc[j];
                desc[j]=t;
            } 
        }

        int k=0;
        for(int i=0;i<n/2;i++)
        if(k<n) {
            res[k++]=desc[i];
            res[k++]=arr[i];
           
        }
        res[k++]=arr[n/2];
       
        for(int x:res)
        System.out.print(x+" ");
        System.out.println();
    }

    //soln-3

    public void alternateSort3(int[] arr) {
        int left=0,right=arr.length-1;
        while(left<right) {
            System.out.print(arr[right--] +" ");
            System.out.print(arr[left++] +" ");
        }
        if(arr.length%2!=0)
        System.out.print(arr[left]);

    }
}