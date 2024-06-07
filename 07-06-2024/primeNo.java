import java.util.Scanner;

class primeNo {
  
  public static void main(String[] args) {
  
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter number");
	int n=sc.nextInt();
	boolean result=isPrimeNumber(n);
	if(result)
		System.out.println(n+" is prime number");
	else
		System.out.println(n+" is not a prime number");
  }
  public static boolean isPrimeNumber(int no) {
  
     for(int i=2;i<no/2;i++)
	 if(no%i==0)
	 return false;
	 
	 return true;
  }
}