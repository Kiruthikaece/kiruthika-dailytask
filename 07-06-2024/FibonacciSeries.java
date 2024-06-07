import java.util.Scanner;
class FibonacciSeries {
public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        int result=findFib(n);  
		System.out.println("Ans:"+result);
}
public static int findFib(int n) {
     int a=0,b=1,c=1;
	 
	 if(n==0)
	 return a;
	 for(int i=2;i<=n;i++) {
	   c=a+b;
	   a=b;
	   b=c;
	 }
	 
	 return b;
}
}