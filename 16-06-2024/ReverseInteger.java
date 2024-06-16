import java.util.Scanner;

public class ReverseInteger {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number:");
        int n=sc.nextInt();
        int res1=findReverse1(n);
        System.out.println("reverse number:"+res1);
        int res2=findReverse2(n);
        System.out.println("reverse number:"+res2);
        int res3=findReverse3(n);
        System.out.println("reverse number:"+res3);
    }

    private static int findReverse1(int n) {
        if(n==0)
        return 0;
      int sum=0,rev=0;
      while(n!=0) {
        int d=n%10;
        sum=sum*10+d;
        rev=sum;
        n=n/10;
      }
      return rev;
    }

    private static int findReverse2(int n) {

        if(n==0)
        return 0;
        int sum=0;
        int num=Math.abs(n);
        while(num!=0) {
          int d=num%10;
          sum=sum*10+d;
          num=num/10;
        }
        return (n<0) ? (-sum):sum;
      }

      private static int findReverse3(int n) {

        if(n==0)
        return 0;
        String s=String.valueOf(n);
        StringBuilder str=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--) {
           str.append(s.charAt(i));
        }

        if(n<0) {
            int ans=Integer.parseInt(str.substring(0,str.length()-1).toString());
            return (-ans);
        }
       
        else
        return Integer.parseInt(str.toString());
      }


}
