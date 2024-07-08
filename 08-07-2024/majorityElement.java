import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class majorityElement {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter arr:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        List<Integer> li1=majorityElement1(arr);
        System.out.println(li1);
        List<Integer> li2=majorityElement2(arr);
        System.out.println(li2);
        List<Integer> li3=majorityElement3(arr);
        System.out.println(li3);

    }

    //soln-1
    private static List<Integer> majorityElement1(int[] arr) {
        int n = arr.length;
        int element = 0, count = 0;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                element = arr[i];
                count = 1;
            } else if (element == arr[i]) {
                count++;
            } else {
                if (count > n / 3 && !list.contains(element)) {
                    list.add(element);
                }
                element = arr[i];
                count = 1;
            }
        }


        if (count > n / 3 && !list.contains(element)) {
            list.add(element);
        }

        return list;
    }

    public static List<Integer> majorityElement2(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);

            for(int i=0;i<n;) {
                int j=i+1;
                int count=1;
                while(j<n && nums[i]==nums[j]) {
                    count++;
                    j++;
                }
                if(count>n/3)
                list.add(nums[i]);

                i=j;
            }

            return list;
    }

     public static List<Integer> majorityElement3(int[] nums) {
        int n = nums.length;
       
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++) 
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        

        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            int element=entry.getKey();
            int count=entry.getValue();
            if(count>n/3)
            list.add(element);
        }


        return list;
           
    }
}
