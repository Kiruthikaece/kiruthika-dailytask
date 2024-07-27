import java.util.Scanner;

public class MaximumOperations {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
    int res1=maxOperation1(arr);
    System.err.println("maximum Operation:"+res1);

    int res2=maxOperation2(arr);
    System.err.println("maximum Operation:"+res2);


    int res3=maxOperation3(arr);
    System.err.println("maximum Operation:"+res3);

    }

    private static int maxOperation1(int[] nums) {
        int i=0,j=i+1;
        int sum=0;
        int count=0;

        while(j<nums.length) {
            int prevSum=sum;
            sum=nums[i]+nums[j];
            if(i!=0 && sum!=prevSum)
            return count;
            else
            count++;

            i=j+1;
            j=i+1;
        }

        return count;
    }

    private static int maxOperation2(int[] nums) {
         int count=0;
         int i=0;
         int sum=0;

         while(i+1<nums.length) {
            if(sum==0) {
                sum=nums[i]+nums[i+1];
                count++;
            }  else {
                if(nums[i]+nums[i+1]==sum)
                count++;
                else
                break;
            }
            i=i+2;
         }
         return count;
    }


    public static  int maxOperation3(int[] nums) {
        
        int count = 0;
        int score = nums[0] + nums[1];
        int i=0;
        
        while(i<nums.length-1)
        {
            if(nums[i] + nums[i+1]==score)
            {
                count++;
                i+=2;
            }
            else
            break;
            
        }
        
        return count;
        
    }
}