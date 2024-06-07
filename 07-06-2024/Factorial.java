import java.util.Scanner;

class Factorial {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        int result=findFact(n);
        System.out.println("Factorial:"+result);
    }

    public static int  findFact(int n) {
        int fact=1;
        for(int i=1;i<=n;i++)
        fact=fact*i;

        return fact;
    }
}