import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class NextGreatestElement {
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
	for(int i=0;i<m;i++)
	arr2[i]=sc.nextInt();

	int[] res1=findGreatestElement1(arr1,arr2);
    for(int x:res1)
    System.err.print(x+" ");
    System.out.println();

	int[] res2=findGreatestElement2(arr1,arr2);
    for(int x:res2)
    System.err.print(x+" ");
    System.out.println();
}

    private static int[] findGreatestElement2(int[] arr1, int[] arr2) {
       Map<Integer,Integer> map=new HashMap<>();
       Stack<Integer> stack=new Stack<>();

       for(int i=0;i<arr2.length;i++) {
        if(!stack.isEmpty() && stack.peek()<arr2[i]) 
        map.put(stack.pop(),arr2[i]);
        stack.push(arr2[i]);
       }


       for(int i=0;i<arr1.length;i++)
       arr1[i]=map.getOrDefault(arr1[i],-1);

       return arr1;
       
    }

    private static int[] findGreatestElement1(int[] arr1, int[] arr2) {
         int[] res=new int[arr1.length];
         Arrays.fill(res,-1);

         for(int i=0;i<arr1.length;i++) {
            int num=arr1[i];
            for(int j=0;j<arr2.length;j++) {
                if(num==arr2[j]) {
                    for(int k=j+1;k<arr2.length;k++) 
                        if(arr2[k]>num) {
                            res[i]=arr2[k];
                            break;
                        }
                    
                }
            }
         }


         return res;
    }
}
