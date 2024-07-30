import java.util.Arrays;
import java.util.Scanner;

public class FindSpecialNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
	    System.out.println("Enter l:");
	    int l=sc.nextInt();
        System.out.println("Enter r:");
	    int r=sc.nextInt();
        int res1=FindSpecialNumber1(l,r);
        System.out.println(res1);
        int res2=FindSpecialNumber2(l,r);
        System.out.println(res2);
    }

    private static int FindSpecialNumber1(int l, int r) {
        int num = (int)Math.sqrt(r);
        int special=0;
        while(num*num>=l && num*num<=r){
            boolean flag = true;
            for(int i=2; i<=(int)Math.sqrt(num); i++){
                if(num%i==0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                special++;
            }
            num--;
        }
        int ans = r-l+1-special;
        if(l==1){
            ans++;
        }
        return ans;
    }


   

    public static int FindSpecialNumber2(int l, int r) {
       
        int maxLimit = (int) Math.sqrt(r);
        boolean[] isPrime = new boolean[maxLimit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= maxLimit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxLimit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

  
        int specialCount = 0;
        for (int i = 2; i <= maxLimit; i++) {
            if (isPrime[i]) {
                long square = (long) i * i;
                if (square >= l && square <= r) {
                    specialCount++;
                }
            }
        }

       
        return (r - l + 1) - specialCount;
    }
}
