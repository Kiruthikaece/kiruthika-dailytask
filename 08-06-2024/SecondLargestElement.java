import java.util.Scanner;
import java.util.*;
class SecondLargestElement  {

public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter array length:");
  int n=sc.nextInt();
  int[] arr=new int[n];
  System.out.println("Enter array:");
  for(int i=0;i<n;i++)
  arr[i]=sc.nextInt();
  int ans1=findSecondLargestElement1(arr);
  System.out.println("result:"+ans1);
  int ans2=findSecondLargestElement2(arr);
  System.out.println("result:"+ans2);
  int ans3=findSecondLargestElement3(arr);
  System.out.println("result:"+ans3);
}

// solution-1

public static int findSecondLargestElement1(int[] arr) {
	int first=arr[0],second=0;
	for(int i=1;i<arr.length;i++) {
		if(arr[i]>first) {
			second=first;
			first=arr[i];	
		}
		if(arr[i]!=first && arr[i]>second)
			second=arr[i];
	}
	return second;
}


// solution-2
public static int findSecondLargestElement2(int[] arr) {
     for(int i=0;i<arr.length;i++)
	 for(int j=0;j<arr.length-1;j++)
	 if(arr[j]<arr[j+1]) {
	 int t=arr[j];
	 arr[j]=arr[j+1];
	 arr[j+1]=t;
	 }
	 
	 return arr[1];
}

// solution-3

public static int findSecondLargestElement3(int[] arr) {
	List<Integer> list = new ArrayList<Integer>();
        for (int num : arr) {
            list.add(num);
        }
        Collections.sort(list);
        return list.get(list.size() - 2);
	
}
}