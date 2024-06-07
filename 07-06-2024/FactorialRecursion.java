import java.util.Scanner;

class FactorialRecursion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        int result=findFact(n);
        System.out.println("Factorial:"+result);
    }

    public static int findFact(int n) {
	
		if(n==1)
		return 1;
		
		return n*findFact(n-1);
    }
}