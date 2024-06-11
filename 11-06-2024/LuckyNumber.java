import java.util.Scanner;

public class LuckyNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Lucky Number:");
        int n=sc.nextInt();
        findAllLuckyNo1(n);
        System.out.println();
        findAllLuckyNo2(n);
        findAllLuckyNo3(n);
    }

    //soln-1
    public static void findAllLuckyNo3(int n) {
        System.out.println("\nPrint lucky number using recursion");
       for(int i=0;i<100;i++) {
        if(containsDigit(i,n))
        System.out.print(i+" ");
       }
    }

    private static boolean containsDigit(int number, int digit) {
        if (number == 0) {
            return false;
        }
        if (number % 10 == digit) {
            return true;
        }
        return containsDigit(number / 10, digit);
    }

    //soln-2
    public static void findAllLuckyNo2(int n) {
       String num=String.valueOf(n);
       System.out.println("Lucky number using String");
       for(int i=1;i<=100;i++) {
        if(String.valueOf(i).contains(num))
        System.out.print(i+" ");
       }
    }

    //soln-3
    public static void findAllLuckyNo1(int n) {
        System.out.println("Lucky number using loop");
       for(int i=1;i<=100;i++) {
        int temp=i;
        while(temp!=0) {
            int d=temp%10;
            if(d==n) {
                System.out.print(i+" ");
                break;
            }
            temp=temp/10;
        }
       }
    }
}
