import java.util.Scanner;

public class BinaryRepresentation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number");
        int n=sc.nextInt();
        int res=printBinaryForm1(n);
        System.out.println("1's count: "+res);
        int res2=printBinaryForm2(n);
        System.out.println("\n1's count: "+res2);
        int res3=printBinaryForm2(n);
        System.out.println("\n1's count: "+res3);
    }

    //solution-1
    public static int printBinaryForm2(int n) {
        int oneCount=0;
        for(int i=9;i>=0;i--) {
            int binary=(int)Math.pow(2,i);
            if(binary<=n) {
                System.out.print(1);
                oneCount++;
                n=n-binary;
            }
            else 
                System.out.print(0);   
        }
        return oneCount;

    }

    //solution-2
    public static int printBinaryForm1(int n) {
        int count=0,sum=0,digitCount=0;
        while(n!=0) {
            int d=n%2;
            sum=(sum*10)+d;
            if(d==1)
            count++;
            n=n/2;
        }
        System.out.println("Binary form: "+sum);
        return count;
    }
    //solution-3
    public static int printBinaryForm3(int n) {
        StringBuilder str=new StringBuilder();
        int count=0,sum=0;
        for(int i=0;i<10;i++) {
          if(n%2==0)
          str.append("0");
          else {
            str.append("1");
            count++;
          }
        }
          System.out.println("Binary form:"+str.toString());
          return count;
    }

}