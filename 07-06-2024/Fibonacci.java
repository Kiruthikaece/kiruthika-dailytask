import java.util.Scanner;
class Fibonacci {
public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        int result=findFib(n);
		System.out.println("Ans:"+result);
}
public static int findFib(int n) {
    int[] fib=new int[n];
	fib[0]=1;
	fib[1]=1;
	for(int i=2;i<n;i++)
	fib[i]=fib[i-2]+fib[i-1];
        for(int i=0;i<n;i++)
	 System.out.print(fib[i]+" ");
   return fib[n-1];
	
}
}
