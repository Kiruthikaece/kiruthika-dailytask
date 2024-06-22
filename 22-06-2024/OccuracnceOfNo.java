import java.util.Arrays;
import java.util.Scanner;

public class OccuracnceOfNo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        findOccurance1(arr);
        //findOccurance2(arr);
        //findOccurance3(arr);
    }

    //soln-1
    public static void findOccurance1(int[] arr) {
        int n=arr.length;
        int[] countArr=new int[n];
        int k=0;
        for(int i=0;i<n;i++) {
           
            int count=1;
            if(arr[i]==-1)
            continue;
            for(int j=i+1;j<n;j++) {
                if(arr[i]==arr[j]) {
                    count++;
                    arr[j]=-1;
                }
            }
           
            countArr[k++]=count;
        }

    int m=0;
    for(int i=0;i<n;i++)
    if(arr[i]!=-1)
    System.out.print(arr[i]+" -> "+countArr[m++]+" ");
System.out.println();
}

//soln-2
public static void findOccurance2(int[] arr) {
    int max = arr[0];
        for (int i = 1; i < arr.length; i++) 
        if (arr[i] > max) 
        max = arr[i];
        
        
       
        int[] hash = new int[max + 1];
        for (int i = 0; i < arr.length; i++) 
        if (arr[i] >= 0)
        hash[arr[i]]++;
      
        for (int i = 0; i < hash.length; i++) 
            if (hash[i] > 0)
                System.out.print( i + "  ->  " + hash[i]+" ");
            
       System.out.println();
    }
        

    //soln-3 
    public static void findOccurance3(int[] arr) {
        Arrays.sort(arr);
        int i=0,j=0;
        int count=1;

        while(j<arr.length) {
            j++;
            if(j<arr.length && arr[i]==arr[j])
            count++;
            else {
                System.out.print(arr[i]+" -> "+count+" ");
                count=1;
                i=j;
            }
        }
    }
}
