import java.util.ArrayList;
import java.util.Collections;

public class PrintAllDivisor {
    public static void main(String[] args) {
        int n=20;
        printAllDivisors1(n);
        System.out.println();
        printAllDivisors2(n);
        System.out.println();
        printAllDivisors3(n,1);
    }

    private static void printAllDivisors3(int n,int i) {
      if(i>n/2) {
        System.out.print(n+" ");
        return;
      }
    
      if(n%i==0)
      System.out.print(i+" ");
      i++;
      printAllDivisors3(n,i);
    }

    private static void printAllDivisors1(int n) {
        for(int i=1;i<=n/2;i++) {
            if(n%i==0)
            System.out.print(i+" ");
        }
         System.out.print(n+" ");
    }

    public static void printAllDivisors2(int n) {
        ArrayList<Integer>ans=new ArrayList<>();
       for(int i=1;i*i<=n;i++){
           if(n%i==0){
               ans.add(i);
          
           if(n/i!=i){
               ans.add(n/i);
           }
           }
       }
       Collections.sort(ans);
       for(int i=0;i<ans.size();i++){
           System.out.print(ans.get(i)+" ");
       }
    }
}
