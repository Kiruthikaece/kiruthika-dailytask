import java.util.*;

class StrongNo {
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
System.out.println("Enter number:");
int n=sc.nextInt();
isStrongNo1(n);
int ans=isStrongNo2(n);
   if(ans==n)
	System.out.println(n+" is a strong number");
	else
	System.out.println(n+" is not a strong number");
isStrongNo3(n);
}

public static void isStrongNo1(int n) {
    
	int sum=0;
	
	int number=n;
	
	while(n!=0) {
	  int d=n%10;
	  int fact=1;
	  for(int i=1;i<=d;i++)
	  fact=fact*i;
	  sum+=fact;
      n=n/10;
	}
	
	if(sum==number)
	System.out.println(number+" is a strong number");
	else
	System.out.println(number+" is not a strong number");
}

 public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

public static int isStrongNo2(int n) {
	if(n==0)
	 return 0;
    else {
		return factorial(n % 10) + isStrongNo2(n / 10);
	}
}



public static void isStrongNo3(int n) {
	int[] arr={0,1,2,6,24,120,720,5040,40320,362880};
	int number=n;
	int sum=0;
	while(n!=0) {
		int d=n%10;
		sum+=arr[d];
		n=n/10;	
	}
	
	if(sum==number)
	System.out.println(number+" is a strong number");
	else
	System.out.println(number+" is not a strong number");
}
}