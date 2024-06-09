import java.util.Scanner;

class MissingNumber {
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
System.out.println("Enter array length:");
int n=sc.nextInt();

int[] arr=new int[n];

for(int i=0;i<n;i++)
arr[i]=sc.nextInt();

int res1=findMissingElement1(arr);
System.out.println("missing Element:"+res1);
int res2=findMissingElement2(arr);
System.out.println("missing Element:"+res2);
int res3=findMissingElement3(arr);
System.out.println("missing Element:"+res3);
}

public static int findMissingElement1(int[] arr) {
         int no=arr.length;
         int sum=no*(no+1)/2;                
         int s1=0;
         for(int i=0;i<arr.length;i++) 
         s1+=arr[i];
		 
         return sum-s1;
}

public static int findMissingElement2(int[] arr) {

int no=arr.length;

int[] hash=new int[no+1];
        
for(int i=0;i<no-1;i++) {
 hash[arr[i]]++;
}

for(int i=1;i<=no;i++)
if(hash[i]==0)
return i;

return -1;

}

public static int findMissingElement3(int[] arr) {
int no=arr.length;
int k=1;      
while(k<=no) {
    boolean ispre=false;
    for(int i=0;i<arr.length;i++) {
        if(arr[i]==k)
        ispre=true;
    }
    if(!ispre) 
      return k;  
    k++;
}
return -1;
}
}