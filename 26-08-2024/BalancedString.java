import java.util.Scanner;

public class BalancedString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string:");
        String s=sc.next();
        int res1=countBalance1(s);
        System.out.println(res1);
        int res2=countBalance2(s);
        System.out.println(res2);
        
    }

    private static int countBalance1(String s) {

        int lchar=0,ans=0,r=0;
        for(int i=0;i<s.length();i++) {
               if(s.charAt(i)=='L')
                lchar++;
                else
                lchar--;

                if(lchar==0)
                ans++;
          }

          return ans;
    }

    private static int countBalance2(String s) {
        int l=0,ans=0,r=0;

        for(int i=0;i<s.length();i++) {
           if(s.charAt(i)=='L')
           l++;
           else
           r++;

           if(l==r) {
               ans++;
               l=0;r=0;
           }

        }

        return ans;
    }

}