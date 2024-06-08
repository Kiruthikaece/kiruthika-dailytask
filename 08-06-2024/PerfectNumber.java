import java.util.Scanner;

class PerfectNumber  {
public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter number:");
  int n=sc.nextInt();
  boolean b1=isPerfectNo1(n);
  String res=b1?" is a perfect number":" is not a perfect number";
  System.out.println(n+res);
  
  boolean isPerfect = isPerfectNo2(n, 1,0);
    if (isPerfect) 
        System.out.println(n + " is a perfect number.");
     else 
        System.out.println(n + " is not a perfect number.");
    

   boolean b2=isPerfectNo3(n);
   if(b2)
	   System.out.println(n + " is a perfect number.");
   else 
    System.out.println(n + " is not a perfect number.");
    
}


// solution-1
public static boolean isPerfectNo1(int no) {
  
  int sum=0;
  for(int i=1;i<=no/2;i++) {
    if(no%i==0)
	sum+=i;
  }
  
  return sum==no;
}

// solution-2

public static boolean isPerfectNo2(int no, int i,int sum) {
     
    if (i<= no/2) {
        if (no%i == 0) {
            sum+= i;
		}
		if(sum==no)
		return true;
        i++;
        return isPerfectNo2(no,i,sum); 
    }
    
    return false;
}


// solution -3 

public static boolean isPerfectNo3(int no) {
	   int sum=1;
        for(int i=2;i<=Math.sqrt(no);i++) {
            if(no%i==0) {
             sum+=i;
             if(i!=no/i) 
              sum+=no/i;
    
            }
        
		}
		
		return sum==no;
		
		
}
}