import java.util.Scanner;

class primeNoRecusrion {
  
  public static void main(String[] args) {
  
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter number");
	int n=sc.nextInt();
	int result=isPrime(n,2);
	if(result==0)
	System.out.println(n+" is prime number");
	else
     System.out.println(n+" is not a prime number");
  }
  public static int isPrime(int n,int st) {
    if(st<n) {
	   if(n%st!=0)
	   return (isPrime(n,++st));
	   else
	   return 1;
	}
	return 0;
  }
  }