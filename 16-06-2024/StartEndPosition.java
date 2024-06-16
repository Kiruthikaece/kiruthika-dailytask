import java.util.Scanner;

public class StartEndPosition {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter array:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter number:");
        int no=sc.nextInt();
        int[] res1=findPosition1(arr,no);
        System.out.println("\nstart and end position:");
        for(int x:res1)
        System.out.print(x+" ");
        System.out.println("\nstart and end position:");
        int[] res2=findPosition2(arr,no);
        for(int x:res2)
        System.out.print(x+" ");
        System.out.println("\nstart and end position:");
        int[] res3=findPosition3(arr,no);
        for(int x:res3)
        System.out.print(x+" ");
     

     }

    private static int[] findPosition1(int[] arr,int no) {
        int fPos=-1,lastPos=-1;

        for(int i=0;i<arr.length;i++) {
            if(arr[i]==no) {
                if(fPos==-1)
                fPos=i;
                else
                lastPos=i;
            }
        }

        if(lastPos==-1 && fPos!=-1)
        lastPos=fPos;
        
        return new int[]{fPos,lastPos};

    }

    private static int[] findPosition2(int[] arr, int no) {
        int start = -1, end = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == no) {
                start = i;
                end = i;
                while (end < arr.length && arr[end] == no) {
                    end++;
                }
                end--;
                break; 
            }
        }

        return new int[]{start, end};
    }


    public static int[] findPosition3(int[] arr,int no) {
        int[] res={-1,-1};
        int start=0,end=arr.length-1;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(arr[mid]==no) {
                res[0]=mid;
                end=mid-1;
            } else if(arr[mid]>no)
            end=mid-1;
            else
            start=mid+1;
        }
        start=0;
        end=arr.length-1;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(arr[mid]==no) {
                res[1]=mid;
                start=mid+1;
            } else if(arr[mid]>no)
            end=mid-1;
            else
            start=mid+1;
        }

        return res;
    }
}
