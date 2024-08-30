public class UglyNumber3 {
    public static void main(String[] args) {
        int n = 3, a = 2, b = 3, c = 5;
        int res1= findUglyNo1(n,a,b,c);
        System.out.println(res1);
        int res2=findUglyNo2(n,a,b,c);
        System.out.println(res2);
        
    }

    private static int findUglyNo2(int n, int a, int b, int c) {
        long aa = Math.min(a,Math.min(b,c));
        long cc = Math.max(a,Math.max(b,c));
        long bb = a + b + c - aa - cc;
        long LCMabc = lcm( lcm(a,b), c);
        long LCMab = lcm(a,b);
        long LCMac = lcm(a,c);
        long LCMbc = lcm(b,c);
        
        long left = 1, right = n * aa;
        while(left < right){
            long mid = left + (right - left)/2;
            long count = mid/a + mid/b + mid/c - mid/LCMab - mid/LCMbc - mid/LCMac + mid/LCMabc;
    
            if(n > count)
                left = mid+1;
            else
                right = mid;
        }
        return Long.valueOf(left).intValue();
    }
    private  static long lcm(long a, long b){
        return (a*b)/gcd(a,b);
    }
    private static long gcd(long a, long b){
        if(b == 0)return a;
        return gcd(b, a%b);
    }
    

    private static int findUglyNo1(int n, int a, int b, int c) {
        int count=0,res=0;

        for(long i=1;i<Long.MAX_VALUE;i++) {
           if(i%a==0 || i%b==0 || i%c==0)
           count++;

           if(n==count) {
             res=(int)i;
             break;
           }
          
        }

        return res;
    }
}
