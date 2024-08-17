import java.util.Scanner;

public class CountingWordsWithPrefix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter word array length");
        int n=sc.nextInt();
        String[] arr=new String[n];
        System.out.println("Enter array:");
        for(int i=0;i<n;i++)
        arr[i]=sc.next();
        System.out.println("Enter prefix:");
        String prefix=sc.next();
        int res1=findCommonPrefix1(arr,prefix);
        System.out.println(res1);

        int res2=findCommonPrefix2(arr,prefix);
        System.out.println(res2);

        int res3=findCommonPrefix3(arr,prefix);
        System.out.println(res3);
    }

    private static int findCommonPrefix2(String[] arr, String prefix) {
          int n=prefix.length();

          int count=arr.length;
          for(String x:arr) {
            for(int i=0;i<n;i++)
            if(x.charAt(i)!=prefix.charAt(i)) {
                
                count--;
                break;
            }
            
          }

          return count;
    }

    private static int findCommonPrefix1(String[] words, String prefix) {
        int count=0;
        for(String word:words) {
            if(word.startsWith(prefix))
            count++;
        }

        return count;
    }

    private static int findCommonPrefix3(String[] arr, String prefix) {
        
        int n=prefix.length();
        int count=0;

        for(String x:arr)
        if(x.substring(0,n).equals(prefix))
        count++;

        return count;
    }
}