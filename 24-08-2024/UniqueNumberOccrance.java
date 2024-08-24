import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UniqueNumberOccrance {
    public static void main(String[] ars) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        boolean res1=isUniqueOccutrance1(arr);
        System.out.println(res1);

        boolean res2=isUniqueOccutrance2(arr);
        System.out.println(res2);

        boolean res3=isUniqueOccutrance3(arr);
        System.out.println(res3);
    }


    private static boolean isUniqueOccutrance3(int[] arr) {
        Arrays.sort(arr);
        int[] res=new int[arr.length];
        int k=0;
         for(int i=0;i<arr.length;i++) {
            int count=1;
            while(i+1<arr.length && arr[i]==arr[i+1]) {
                    count++;
                    i++;
            }
            res[k++]=count;
         }

         Arrays.sort(res);
        
         for(int i=1;i<res.length;i++) {
            if(res[i]==res[i-1])
            return false;
         }
         return true;
    }


    private static boolean isUniqueOccutrance2(int[] arr) {
        Arrays.sort(arr);
        List<Integer> list=new ArrayList<>();
         for(int i=0;i<arr.length;i++) {
            int count=1;
            while(i+1<arr.length && arr[i]==arr[i+1]) {
                    count++;
                    i++;
            }
            list.add(count);
         }

         Collections.sort(list);

         for(int i=1;i<list.size();i++) {
            if(list.get(i).equals(list.get(i-1)))
            return false;
         }
         return true;
    }

    private static boolean isUniqueOccutrance1(int[] arr) {
          Map<Integer,Integer> map=new HashMap<>();
         for(int i=0;i<arr.length;i++)
         map.put(arr[i],map.getOrDefault(arr[i],0)+1);

        Set<Integer> set=new HashSet<>();

         for(int x:map.values()) {
           if(!set.add(x))
           return false;
         }

        return true; 
    }
}