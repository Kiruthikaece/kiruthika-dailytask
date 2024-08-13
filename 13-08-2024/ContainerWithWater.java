import java.util.Scanner;

public class ContainerWithWater {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	int res=maxArea1(arr);
    System.out.println(res);
	int res1=maxArea2(arr);
    System.out.println(res1);
}
public static int maxArea1(int[] height) {
    int left=0,right=height.length-1,max=0,temp=0;

    while(left<right) {
    
      if(height[left]<height[right]) {
        temp=height[left]*(right-left);
        left++;
      }
      else if(height[left]>height[right]){
         temp=height[right]*(right-left);
         right--;
      }
      else {              
     temp=height[right]*(right-left);
     left++;
     right--;
     }
     
      if(temp>max) 
      max=temp;
    }

    return max;
 }

 public static int maxArea2(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int maxArea = 0;

    while (left < right) {
        int currentArea = Math.min(height[left], height[right]) * (right - left);
        maxArea = Math.max(maxArea, currentArea);

        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }

    return maxArea;
}
}
