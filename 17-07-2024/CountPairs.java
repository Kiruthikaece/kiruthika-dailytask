
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountPairs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter k:");
        int k=sc.nextInt();

        long res1=countPairs1(arr,k);
        System.out.println(res1);

        long res2=countPairs2(arr,k);
        System.out.println(res2);
    }

    private static long countPairs1(int[] nums, int k) {
        long count=0;

        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) 
            if(((long)(nums[i]*nums[j]))%k==0)
            count++;
        }
        return count;
    }

    private static long countPairs2(int[] nums, int k) {
        Map<Integer, Integer> gcdCount = new HashMap<>();
        long count = 0;

        for (int num : nums) {
            int gcdVal = gcd(num, k);
            for (int key : gcdCount.keySet()) {
                if ((long) gcdVal * key % k == 0) {
                    count += gcdCount.get(key);
                }
            }
            gcdCount.put(gcdVal, gcdCount.getOrDefault(gcdVal, 0) + 1);
        }

        return count;
    }
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    }


