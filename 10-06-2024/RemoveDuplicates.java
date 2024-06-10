import java.util.*;

class RemoveDuplicates {
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	RemoveDuplicateElement1(arr);
	RemoveDuplicateElement2(arr);
	RemoveDuplicateElement3(arr);
}

//soln-1
public static void RemoveDuplicateElement1(int[] arr) {
   int i=0;
   for(int j=1;j<arr.length;j++)
   if(arr[i]!=arr[j]) {
    arr[i+1]=arr[j];
	i++;
   }
   
   
   for(int k=0;k<i+1;k++)
   System.out.print(arr[k]+" ");
   System.out.println();

}


//soln-2
public static void RemoveDuplicateElement2(int[] arr) {
   Set<Integer> set=new HashSet<>();

    for(int i=0;i<arr.length;i++)
    set.add(arr[i]);

    for(Integer s:set)
    System.out.print(s+" ");
    System.out.println();
    
}


//soln-3
public static void RemoveDuplicateElement3(int[] arr) {
	
	int k=0;
    for(int i=0;i<arr.length;i++) {	
	for(int j=i+1;j<arr.length;j++)
		if(arr[i]==arr[j]) 
			arr[j]=-1;
		if(arr[i]!=-1)
			arr[k++]=arr[i];
	     
	}

	for(int i=0;i<k;i++)
	System.out.print(arr[i]+" ");
}

}