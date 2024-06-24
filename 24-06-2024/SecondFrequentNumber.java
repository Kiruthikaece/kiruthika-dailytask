import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class SecondFrequentNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length:");
        int len=sc.nextInt();
        System.out.println("Enter array:");
        int[] arr=new int[len];
        for(int i=0;i<len;i++)
        arr[i]=sc.nextInt();
       

        // int res1=findSecondFrequentNumber1(arr);
        // System.out.println("Second frequent Number:"+res1);

        // int res2=findSecondFrequentNumber2(arr);
        // System.out.println("Second frequent Number:"+res2);

        int res3=findSecondFrequentNumber3(arr);
        System.out.println("Second frequent Number:"+res3);
    }

//soln-1

    public static int findSecondFrequentNumber3(int[] arr) {
        
        int n=arr.length;

        int max=arr[0];
        for(int i=0;i<n;i++)
        if(max<arr[i])
        max=arr[i];
        
        int[] hash=new int[max+1];

        for(int i=0;i<arr.length;i++)
        hash[arr[i]]++;

        int first=hash[0],second=0;

        for(int i=1;i<hash.length;i++) {
           if(hash[i]>first) {
               second=first;
               first=hash[i];
           }
           if(hash[i] > second && hash[i] < first)
           second=hash[i];
           
        }

        for(int i=2;i<hash.length;i++)
        if(hash[i]==second)
        second=i;

        return second;
   }

//soln-2
   public static int findSecondFrequentNumber2(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        TreeSet<Integer> frequencySet = new TreeSet<>(frequencyMap.values());
        if (frequencySet.size() < 2) {
            return -1; 
        }

        frequencySet.pollLast(); 
        int secondHighestFrequency = frequencySet.last(); 

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == secondHighestFrequency) {
                return entry.getKey();
            }
        }

        return -1; 
    }


    //soln-3

    public static int findSecondFrequentNumber1(int[] arr) {

       HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        int firstKey = -1, secondKey = -1;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int key = entry.getKey();
            int frequency = entry.getValue();
            if (frequency > first) {
                second = first;
                secondKey = firstKey;
                first = frequency;
                firstKey = key;
            } else if (frequency > second && frequency < first) {
                second = frequency;
                secondKey = key;
            }
        }

        return secondKey;
    }

}
