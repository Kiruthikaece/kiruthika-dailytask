import java.util.Scanner;

public class PivotIndex {
     public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	int res1=findPivot1(arr);
    System.err.println(res1);
    int res2=findPivot2(arr);
    System.err.println(res2);
    int res3=findPivot3(arr);
    System.err.println(res3);
}

public static int findPivot1(int[] nums) {
    int totalSum = 0;
    for (int num : nums) {
        totalSum += num;
    }

    int leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
        if (leftSum == totalSum - leftSum - nums[i]) {
            return i;
        }
        leftSum += nums[i];
    }

    return -1;
}

public static int findPivot2(int[] nums) {
    int n = nums.length;
    int[] prefixSum = new int[n + 1];
    
    for (int i = 0; i < n; i++) {
        prefixSum[i + 1] = prefixSum[i] + nums[i];
    }
    
    for (int i = 0; i < n; i++) {
        if (prefixSum[i] == prefixSum[n] - prefixSum[i + 1]) {
            return i;
        }
    }
    
    return -1;
}

public static int findPivot3(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        int leftSum = 0;
        for (int j = 0; j < i; j++) {
            leftSum += nums[j];
        }
        
        int rightSum = 0;
        for (int j = i + 1; j < nums.length; j++) {
            rightSum += nums[j];
        }
        
        if (leftSum == rightSum) {
            return i;
        }
    }
    
    return -1;
}
}
