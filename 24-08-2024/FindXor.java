import java.util.Scanner;

public class FindXor {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter L");
        int l=sc.nextInt();
       
        System.out.println("Enter R:");
        int r=sc.nextInt();

        int res1=findXor1(l,r);
        System.out.println(res1);

        int res2=findXor2(l,r);
        System.out.println(res2);
    }

    private static int findXor1(int l, int r) {
         int xor=0;

         for(int i=l;i<=r;i++)
         xor^=i;

         return xor;
    }
    public static int findXor2(int l, int r) {
        return findXORHelper(l-1)^findXORHelper(r);
    }
    
    public static int findXORHelper(int n){
        if(n%4==0) return n;
        if(n%4==1) return 1;
        if(n%4==2) return n+1;
        return 0;
    }
}
