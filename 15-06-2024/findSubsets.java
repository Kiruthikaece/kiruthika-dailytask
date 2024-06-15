import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class findSubsets {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length:");
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        List<List<Integer>> li1=findAllSubset1(arr);
        System.out.println(li1);

        List<List<Integer>> li2=findAllSubset2(arr);
        System.out.println(li2);

        List<List<Integer>> li3=findAllSubset3(arr);
        System.out.println(li3);
    }


    //soln-1

    public static List<List<Integer>> findAllSubset1(int[] arr) {
         List<List<Integer>> subset=new ArrayList<>();
         for(int i=0;i<arr.length;i++) {
            for(int j=i;j<arr.length;j++) {
                List<Integer> li=new ArrayList<>();
                for(int k=i;k<=j;k++)
                li.add(arr[k]);
               subset.add(li);
            }   
         }

         subset.add(new ArrayList());
         return subset;
    }

    //slon-2 
    public static List<List<Integer>> findAllSubset2(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        findAllSubset(arr, list, li, 0);
        return list;
    }

    public static void findAllSubset(int[] arr, List<List<Integer>> list, List<Integer> li, int index) {
      
        list.add(new ArrayList<>(li));

        for (int i = index; i < arr.length; i++) {
            li.add(arr[i]);
            findAllSubset(arr, list, li, i + 1);
            li.remove(li.size() - 1);
        }
    }


    //soln-3
    
    public static List<List<Integer>> findAllSubset3(int[] arr) {
       
        List<List<Integer>> list = new ArrayList<>();
        
        
        int n = arr.length;

        for (int i = 0; i < (1 << n); i++) {
            List<Integer> li = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                   li.add(arr[j]);
                }
                
            }
            list.add(li);
        }

        return list;
    }

}
