
import java.util.*;

public class IntersectionArr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array1 length");
        int n=sc.nextInt();
        int[] arr1=new int[n];
        System.out.println("Enter array1:");
        for(int i=0;i<n;i++)
        arr1[i]=sc.nextInt();

        System.out.println("Enter array2 length");
        int m=sc.nextInt();
        int[] arr2=new int[m];
        System.out.println("Enter array2:");
        for(int i=0;i<m;i++)
        arr2[i]=sc.nextInt();

        int res1=intersectionArr1(arr1,arr2);
        System.out.println(res1);

        int res2=intersectionArr2(arr1,arr2);
        System.out.println(res2);
    }

    private static int intersectionArr1(int[] a, int[] b) {
        int count=0;
       
       Arrays.sort(a);
       Arrays.sort(b);

       int n=a.length;
       int m=b.length;
       
       int i=0,j=0,x=-1;
       
       while(i<n && j<m) {
           if(a[i]==b[j] && x!=a[i]) {
               x=a[i];
               count++;
               i++;
               j++;
           }
           else if(a[i]<b[j]) {
               i++;
           }
           else
           j++;
       }
       
       return count;
    }

    private static int intersectionArr2(int[] arr1, int[] arr2) {
         Set<Integer> set=new HashSet<>();

         for(int i=0;i<arr1.length;i++)
         set.add(arr1[i]);

         int count=0;
         for(int j=0;j<arr2.length;j++) {
            if(set.contains(arr2[j]))
            count++;
         }

         return count;
    }
}