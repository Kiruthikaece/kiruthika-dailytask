import java.util.Scanner;

class FactorialUsingArr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        int result=findFact(n);
        System.out.println("Factorial:"+result);
    }

    public static int findFact(int n) {
        
		int[] fact=new int[n+1];
		fact[0]=1;
		for(int i=1;i<=n;i++)
		fact[i]=fact[i-1]*i;
		
		return fact[n];
    }
}