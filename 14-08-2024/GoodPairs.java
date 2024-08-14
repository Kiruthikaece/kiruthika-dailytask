import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GoodPairs {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array1 length:");
	int n=sc.nextInt();
	int[] arr1=new int[n];
	System.out.println("Enter array1:");
	for(int i=0;i<n;i++)
	arr1[i]=sc.nextInt();

    System.out.println("Enter array2 length:");
	int m=sc.nextInt();
	int[] arr2=new int[m];
	System.out.println("Enter array2:");
	for(int i=0;i<n;i++)
	arr2[i]=sc.nextInt();

    System.out.println("Enter k:");
	int k=sc.nextInt();


	    long res1=findGoodPairs1(arr1,arr2,k);
        System.out.println(res1);

        long res2=findGoodPairs2(arr1,arr2,k);
        System.out.println(res2);

        
}

    public static long findGoodPairs2(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            map.put(num * k, map.getOrDefault(num * k, 0) + 1);
        }

        long count = 0;
        for (int num : nums1) {
            for (int i = 1; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    int complement = num / i;
                    if (map.containsKey(i)) {
                        count += map.get(i);
                    }
                    if (complement != i && map.containsKey(complement)) {
                        count += map.get(complement);
                    }
                }
            }
        }

        return count;

    }

    private static long findGoodPairs1(int[] nums1, int[] nums2, int k) {
          
        int count=0;

        for(int i=0;i<nums1.length;i++) {
          for(int j=0;j<nums2.length;j++) {
              int div=nums2[j]*k;
              if(nums1[i]%div==0)
              count++;
          }
        }

        return count;
    }
}
