import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindTwoSum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter array length:");
        int len=scanner.nextInt();
        int[] arr=new int[len];
        for(int i=0;i<len;i++)
        arr[i]=scanner.nextInt();
        System.out.println("Enter Sum:");
        int k=scanner.nextInt();
        int[] res1=findTwoSum1(arr,k);
        for(int x:res1)
        System.out.print(x+" ");
        System.out.println(" ");
        int[] res2=findTwoSum2(arr,k);
        for(int x:res2)
        System.out.print(x+" ");
        System.out.println(" ");
        int[] res3=findTwoSum3(arr,k,0,1);
        for(int x:res3)
        System.out.print(x+" ");
    }

    private static int[] findTwoSum3(int[] arr, int k,int i,int j) {
           if(i>=arr.length-1)
           return new int[]{-1,-1};

           if(j>=arr.length) {
            return findTwoSum3(arr, k, i + 1, i + 2);
           }
          

           if(arr[i]+arr[j]==k) {
            
            return new int[]{i,j};
           }
          
           return findTwoSum3(arr,k,i,j+1);
    }

    private static int[] findTwoSum1(int[] arr, int k) {
        int first=-1,last=-1;
         for(int i=0;i<arr.length;i++) {
            int sum=0;
            for(int j=i+1;j<arr.length;j++) {
                sum=arr[i]+arr[j];
                if(sum==k) {
                    first=i;
                    last=j;
                }
            }
            
         }

         return  new int[]{first,last};
    }

    public static int[] findTwoSum2(int[] arr,int k) {
        int[] res={-1,-1};
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            int rem=k-arr[i];
            if(map.containsKey(rem)) {
                res[0]=map.get(rem);
                res[1]=i;
                return res;
            }
            map.put(arr[i],i);
        
        }
        return res;
        
    }
}