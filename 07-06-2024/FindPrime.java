import java.util.Scanner;

class FindPrime {
  
  public static void main(String[] args) {
  
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter number");
	int n=sc.nextInt();
	isPrime(n);
  }
  
   public static void isPrime(int n) {
      
	  boolean[] prime=new boolean[n+1];
	  
	  for(int i=2;i<=n;i++)
	  prime[i]=true;
	  
	  for(int i=2;i*i<=n;i++)
	  {
	  if(isPrime[i])
	   for(int j=i*i;j<=n;j=i+j)
	   Prime[j]=false;
	  }
       
	  if(prime[n])
	  System.out.println(n+" is a prime number");
	  else
	  System.out.println(n+" is a not prime number");
	  
   }
  
}