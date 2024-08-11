import java.util.Arrays;
import java.util.Scanner;

public class PickNumber {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	int res1=pickNumber1(arr);
    System.out.println(res1);
	int res2=pickNumber2(arr);
    System.out.println(res2);
    int res3=pickNumber3(arr);
    System.out.println(res3);
}

    private static int pickNumber1(int[] a) {
        int maxLength = 0;
        for (int i = 0; i < a.length; i++) {
            int currentLength = 0;
            for (int j = 0; j < a.length; j++) {
                if (Math.abs(a[i] - a[j]) <= 1) {
                    currentLength++;
                }
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }

    private static int pickNumber2(int[] a) {
        int[] frequency = new int[101];
        for (int num : a) {
            frequency[num]++;
        }

        int maxLength = 0;
        for (int i = 1; i < frequency.length; i++) {
            maxLength = Math.max(maxLength, frequency[i] + frequency[i - 1]);
        }

        return maxLength;
    }

    public static int pickNumber3(int[] a) {
        Arrays.sort(a);
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < a.length; right++) {
            while (a[right] - a[left] > 1) {
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
