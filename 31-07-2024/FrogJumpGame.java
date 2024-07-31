import java.util.Arrays;
import java.util.Scanner;

public class FrogJumpGame {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter n:");
    int n=sc.nextInt();
    System.out.println("Enter l:");
    int l=sc.nextInt();
	System.out.println("Enter array length:");
	int x=sc.nextInt();
	int[] arr=new int[x];
	System.out.println("Enter array:");
	for(int i=0;i<x;i++)
	arr[i]=sc.nextInt();

   int res1= jumpGame1(n,l,arr);
   System.out.println(res1);

   int res2= jumpGame2(n,l,arr);
   System.out.println(res2);

    }

    private static int jumpGame1(int n, int l, int[] arr) {

         Arrays.sort(arr);
        boolean[] visit=new boolean[l+1];
           
           for(int i=0;i<n;i++) {
               int frog=arr[i];
               for(int j=0;j<=l;j++) 
                   if(j%frog==0) {
                    visit[j]=true;
                   }
                  
        
           }
           
           int count=0;
           for(int i=0;i<visit.length;i++)
           if(!visit[i])
           count++;
           
           return count;
    }

    private static int jumpGame2(int n, int l, int[] arr) {

        boolean[] visit=new boolean[l+1];
        int count=l;
           
            for(int i=0;i<n;i++) {
              int frog=arr[i];

              if(frog==1)
              return 0;

              if(frog>l)
              continue;

              if(visit[frog])
              continue;

              for(int j=frog;j<=l;j=j+frog) {
                if(!visit[j])
                count--;
                visit[j]=true;
              }
           }

           
          
          


           return count;

    }



}
