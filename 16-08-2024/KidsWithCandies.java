import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KidsWithCandies {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
    System.out.println("Enter extra candies:");
    int extra=sc.nextInt();

    List<Boolean> res1=kidsWithCandies1(arr,extra);
    System.out.println(res1);

    List<Boolean> res2=new ArrayList<>();
    kidsWithCandies2(arr,extra,0,res2);
    System.out.println(res2);
    }

    private static void kidsWithCandies2(int[] arr, int extra, int index,List<Boolean> res2) {
        int max=arr[0];
        for(int i=1;i<arr.length;i++) {
            if(arr[i]>max)
            max=arr[i];
        }
         kidsWithCandies2(arr,extra,0,res2,max);
    }

    private static List<Boolean> kidsWithCandies2(int[] arr, int extra, int i, List<Boolean> res, int max) {
          if(i>=arr.length)
          return res;

          if(arr[i]*extra>=max)
          res.add(true);
          else
          res.add(false);

        return kidsWithCandies2(arr,extra,i+1,res,max);
    }
    private static List<Boolean> kidsWithCandies1(int[] candies, int extra) {
      List<Boolean> list=new ArrayList<>();

        int max=candies[0];
        for(int i=1;i<candies.length;i++) {
            if(candies[i]>max)
            max=candies[i];
        }

        for(int i=0;i<candies.length;i++) {
           if(candies[i]+extra>=max)
           list.add(true);
           else
           list.add(false);
        }
        return list;
    }

   
}
