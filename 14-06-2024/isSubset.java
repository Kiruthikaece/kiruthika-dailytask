import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class isSubset {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length1:");
        int n=sc.nextInt();
        int[] arr1 = new int[n];
        for(int i=0;i<n;i++)
        arr1[i]=sc.nextInt();

        System.out.println("Enter array length2:");
        int m=sc.nextInt();
        int[] arr2 = new int[m];
        for(int i=0;i<m;i++)
        arr2[i]=sc.nextInt();

        boolean b1=isSubset1(arr1,arr2);
        if(b1)
        System.out.println("arr2 is a subset of arr1");
        else
        System.out.println("arr2 is not a subset of arr1");

        boolean b2=isSubset2(arr1,arr2);
        if(b2)
        System.out.println("arr2 is a subset of arr1");
        else
        System.out.println("arr2 is not a subset of arr1");

        boolean b3=isSubset3(arr1,arr2);
        if(b3)
        System.out.println("arr2 is a subset of arr1");
        else
        System.out.println("arr2 is not a subset of arr1");
    }

    //soln-1
    public static boolean isSubset3(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i=0,j=0;

       while(i<arr1.length && j<arr2.length) {
           if(arr1[i]<arr2[j])
           i++;
           else if(arr1[i]==arr2[j]) {
            i++;
            j++;
           }
           else if(arr1[i]>arr2[j])
           return false;

       }
       
       if(j<arr2.length)
       return false;
       else
       return true;
    }

      //soln-2
    public static boolean isSubset2(int[] arr1, int[] arr2) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<arr1.length;i++)
        if(!set.contains(arr1[i]))
        set.add(arr1[i]);

        for(int i=0;i<arr2.length;i++) {
            if(!set.contains(arr2[i]))
            return false;
        }

        return true;
    }

    //soln-3
    public static boolean isSubset1(int[] arr1, int[] arr2) {
        
        for(int i=0;i<arr2.length;i++) {
            boolean t=false;
            for(int j=0;j<arr1.length;j++) {
                if(arr2[i]==arr1[j]) {
                    t=true;
                    break;
                }
            }
            if(!t)
            return false;
        }

        return true;
    }
}
