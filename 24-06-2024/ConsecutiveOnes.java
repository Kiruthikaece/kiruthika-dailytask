import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsecutiveOnes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of bits:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter bits:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter consective k:");
        int k=sc.nextInt();
        List<Integer> li1=GetConsectiveSequence1(arr,k);
        System.out.println(li1);
        List<Integer> li2=GetConsectiveSequence2(arr,k);
        System.out.println(li2);
    }


    //soln-1
    public static List<Integer> GetConsectiveSequence1(int[] arr, int k) {
        List<Integer> list=new ArrayList<>();
        
        int j=0,count=0;
        while(j<arr.length) {

            list.add(arr[j]);
            if(j<arr.length && arr[j]==1) {
                count++;
                if(count==k) {
                    list.add(0);
                    count=0;
                }
            }
            else
            count=0;
            j++;
           
        }

        return list;
    }


    //soln-2
    public static List<Integer> GetConsectiveSequence2(int[] arr, int k) {
       StringBuilder str=new StringBuilder();
        int j=0,count=0;

        while(j<arr.length) {

            str.append(arr[j]);
            if(arr[j]==1 && j<arr.length) {
                count++;
                if(count==k) {
                    str.append(0);
                    count=0;
                }
            }
            else
            count=0;
           j++;
        }

        String[] strArr=str.toString().split("");
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<strArr.length;i++)
        list.add(Integer.parseInt(strArr[i]));

        
        return list;
    }
}