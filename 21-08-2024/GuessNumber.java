
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n");
        int n=sc.nextInt();

        System.out.println("Enter pick");
        int pick=sc.nextInt();

        int res1=findNumber1(n,pick);
        System.out.println(res1);

        int res2=findNumber2(n,pick);
        System.out.println(res2);
    }

    private static int findNumber1(int n, int pick) {
        int start=1,end=n;

        while(start<=end) {
           int mid=start+(end-start)/2;
           if(mid>pick) 
           end=mid-1;
           else if(mid<pick)
           start=mid+1;
           else
           return mid;
        }

        return -1;
    }

    public static int findNumber2(int n,int pick) {
        return binarySearch(1, n,pick);
    }

    private static  int binarySearch(int start, int end,int pick) {
        int mid = start + (end - start) / 2;

        if ( mid== pick) {
            return mid;
        } else if (mid>pick) {
            return binarySearch(start, mid - 1,pick);
        } else {
            return binarySearch(mid + 1, end,pick);
        }
    }
}
