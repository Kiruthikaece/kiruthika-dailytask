import java.util.*;

public class FindAllSubsets {
    public static void main(String[] srgs) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter arr:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        findAllSubsets1(arr,0,new ArrayList<>());
        findAllSubsets2(arr);
        findAllSubsets3(arr);
    }

    private static void findAllSubsets1(int[] arr, int i, List<Integer>list) {
         if(i>=arr.length) {
            System.out.println(list);
            return;
         }

         list.add(arr[i]);
         findAllSubsets1(arr,i+1,list);
         list.remove(list.size()-1);
         findAllSubsets1(arr,i+1,list);
    }

    private static void findAllSubsets2(int[] arr) {
        int n = arr.length;
        int totalSubsets = 1 << n;

        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }
            System.out.println(subset);
        }
    }


    private static void findAllSubsets3(int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>()); 

        for (int num : arr) {
            int size = subsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(subsets.get(i));
                newSubset.add(num);
                subsets.add(newSubset);
            }
        }

        System.out.println(subsets);
    }
}