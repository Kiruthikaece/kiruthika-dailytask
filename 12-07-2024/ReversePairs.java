import java.util.ArrayList;
import java.util.Scanner;

public class ReversePairs {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
    System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();

	int res1=reversePairs1(arr);
    System.out.println(res1);

    int res2=reversePairs2(arr,n);
    System.out.println(res2);
}

 
        public static int reversePairs1(int[] nums) {
            int count=0;
    
            for(int i=nums.length-1;i>=0;i--) {
                long mul=(long)nums[i]*2;
                for(int j=0;j<i;j++) {
                    if(nums[j]>mul) {
                     count++;
                    }
                 
                }
            }
    
            return count;
        }


        
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); 
        int left = low;     
        int right = mid + 1;  

        
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

       

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

       
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

       
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeSort(arr, low, mid); 
        cnt += mergeSort(arr, mid + 1, high); 
        cnt += countPairs(arr, low, mid, high); 
        merge(arr, low, mid, high); 
        return cnt;
    }

    public static int reversePairs2(int[] skill, int n) {
        return mergeSort(skill, 0, n - 1);
    }
    }


