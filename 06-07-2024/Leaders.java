import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Leaders {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter arr:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        List<Integer> list1=printLeaders1(arr);
        System.out.println(list1);
        List<Integer> list2=printLeaders2(arr);
        System.out.println(list2);
    }

    //soln-1
    private static List<Integer> printLeaders1(int[] arr) {
        List<Integer> list=new ArrayList<>();
        int max=arr[arr.length-1];
        list.add(max);
        for(int i=arr.length-2;i>=0;i--) {
            if(arr[i]>max) {
                list.add(arr[i]);
                max=arr[i];
            }
        }
        Collections.sort(list,Collections.reverseOrder());
        return list;
    }

    //soln-2
    private static List<Integer> printLeaders2(int[] arr) {
        List<Integer> list=new ArrayList<>();
         for(int i=0;i<arr.length;i++) {
            boolean leader=true;
            for(int j=i+1;j<arr.length;j++)
             if(arr[j]>arr[i]) {
                leader=false;
                break;
             }
             if(leader)
             list.add(arr[i]);
         }
         return list;
    }
}
