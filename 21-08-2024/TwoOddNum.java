
import java.util.*;

public class TwoOddNum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
       

        int[] res1=findOdds(arr,n);
        System.out.println(Arrays.toString(res1));

        int[] res2=findOdds1(arr,n);
        System.out.println(Arrays.toString(res2));

        int[] res3=findOdds2(arr,n);
        System.out.println(Arrays.toString(res3));
    }

    private static int[] findOdds(int[] Arr, int N) {
       HashMap < Integer, Integer > mp = new HashMap < Integer, Integer > ();
    for (int i = 0; i < N; ++i) {
      if (mp.containsKey(Arr[i])) {
        mp.put(Arr[i], mp.get(Arr[i]) + 1);
      } else {
        mp.put(Arr[i], 1);
      }
    }

        int[] arr=new int[2];
        int k=0;
 
    for (Map.Entry < Integer, Integer > x: mp.entrySet()) {
      if (x.getValue() % 2 == 1 && k<2) {
        arr[k++]=x.getKey();
      }
    }
    int[] out=new int[2];
    out[0]=Math.max(arr[0],arr[1]);
    out[1]=Math.min(arr[0],arr[1]);
    return out;
    }

    private static int[] findOdds1(int[] arr, int n) {
         Arrays.sort(arr);
         int[] res=new int[2];
        int k=1;
         for(int i=0;i<n-1;i++) {
            if(arr[i]==arr[i+1])
            i++;
            else
            res[k--]=arr[i];
         }
         if(res[0]==0)
         res[0]=arr[n-1];

         return res;
    }

    public static int[] findOdds2(int nums[], int N) {

        int x = 0;
        for (int i = 0; i < N; ++i) {
          x ^= nums[i];
        }
        int set_bit;
        set_bit = x & ~(x - 1);
    
        int first = 0, second = 0;
        for (int i = 0; i < N; ++i) {
          if ((nums[i] & set_bit) > 0) {
            first ^= nums[i];
          } else second ^= nums[i];
        }
      

       return new int[]{first,second};
      
}
}