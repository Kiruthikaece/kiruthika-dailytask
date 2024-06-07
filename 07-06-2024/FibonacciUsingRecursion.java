import java.util.Scanner;
class FibonacciUsingRecursion {
public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        int result=findFib(n);  
		System.out.println("Ans:"+result);
}
public static int findFib(int n) {
        if(n<=1)
		return n;
		
		return findFib(n-1)+findFib(n-2);
}
}