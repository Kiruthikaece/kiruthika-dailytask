import java.util.Arrays;
import java.util.Scanner;

public class PrimesSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();

        String res1=isPrimesSum1(n);
        System.out.println(res1);

        String res2=isPrimesSum2(n);
        System.out.println(res2);
    }

    private static String isPrimesSum1(int N) {
        if(N<=2)return "No";
        for(int i=2;i<=N/2;i++)  {
            if(isPrime(i)&& isPrime(N-i)) 
               return "Yes";
            
          
        }
        
        return "No";
    }
    
    public static boolean isPrime(int n) {
        if(n<=1)return false;
        for(int i=2;i<=Math.sqrt(n);i++)
        if(n%i==0)
        return false;
        
        return true;
    
    }


    public static boolean[] findprime(int N) {
        boolean[] primes = new boolean[N + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= N; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }

    
    public static String isPrimesSum2(int N) {
        boolean[] primes = findprime(N);
        for (int i = 2; i <= N / 2; i++) {
            if (primes[i] && primes[N - i]) {
                return "Yes";
            }
        }
        return "No";
    }

}