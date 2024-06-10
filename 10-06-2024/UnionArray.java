import java.util.*;

public class UnionArray {
    public static void main(String[] args) {
    
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter array length1:");
	int m=sc.nextInt();
	System.out.println("Enter array:");
	int[] arr1=new int[m];
	for(int i=0;i<m;i++)
	arr1[i]=sc.nextInt();
	
	System.out.println("Enter array length2:");
	int n=sc.nextInt();
	System.out.println("Enter array2:");
	int[] arr2=new int[n];
	for(int i=0;i<n;i++)
	arr2[i]=sc.nextInt();
	
	findUnion1(arr1,arr2);
	findUnion2(arr1,arr2);
	findUnion3(arr1,arr2);
  
    }
	
	//soln-1
	public static void findUnion1(int[] arr1, int[] arr2) {
	   List<Integer> union=new ArrayList<>();
	   int i=0,j=0;
	  
	  while(i<arr1.length && j<arr2.length) {
            if(arr1[i]<arr2[j])
            {
                if(union.size()==0 || union.get(union.size()-1)!=arr1[i])
                union.add(arr1[i]);
                i++;
            }
            else {
                if(union.size()==0 || union.get(union.size()-1)!=arr2[j])
                union.add(arr2[j]);
                j++;
            }
        }
	   
	   while(i<arr1.length) {
	   if(union.get(union.size()-1)!=arr1[i])
	    union.add(arr1[i]);
		i++;
	   }
	   
	   while(j<arr2.length) {
	   if(union.get(union.size()-1)!=arr2[j])
	    union.add(arr2[j]);
		j++;
	   }
	   
	   for(Integer x:union)
		   System.out.print(x+" ");
	   System.out.println();
	   
	}
	
	//soln-2
	
	public static void findUnion2(int[] arr1, int[] arr2) {
        int[] res=new int[arr1.length+arr2.length];
        int k=0;
        for(int i=0;i<arr1.length;i++)
        res[k++]=arr1[i];
        for(int i=0;i<arr2.length;i++)
        res[k++]=arr2[i];
        sortArr(res);
        int first=0;
        for(int i=1;i<res.length;i++) 
         if(res[first]!=res[i])  {
         res[first+1]=res[i];
         first++;
         }
        
         for(int i=0;i<first+1;i++)
         System.out.print(res[i]+" ");
	     System.out.println();
    }

    private static void sortArr(int[] res) {
       for(int i=0;i<res.length;i++) 
        for(int j=0;j<res.length-1;j++)
        if(res[j]>res[j+1]) {
            int temp=res[j];
            res[j]=res[j+1];
            res[j+1]=temp;
        }
       
    }
	
	//soln-3
	
	public static void findUnion3(int[] arr1, int[] arr2) {
		
    HashMap <Integer,Integer > freq=new HashMap<>();
    ArrayList<Integer> Union=new ArrayList<>();
    for (int i = 0; i < arr1.length; i++)
    freq.put(arr1[i],freq.getOrDefault(arr1[i],0)+1);
    
    for (int i = 0; i < arr2.length; i++)
    freq.put(arr2[i],freq.getOrDefault(arr2[i],0)+1);
    for (int it: freq.keySet())
    Union.add(it);
  
    for(Integer x:Union)
    System.out.print(x+" ");
	}

}