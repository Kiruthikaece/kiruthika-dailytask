import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string:");
        String s=sc.next();
        System.out.println("Enter k:");
        int k=sc.nextInt();
        int res1=findDigits1(s,k);
        System.out.println(res1);

        int res2=findDigits2(s,k);
        System.out.println(res2);

       
    }

    private static int findDigits1(String s, int k) {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++) {
            str.append(s.charAt(i)-'a'+1);
        }

        while(k>0) {
            int temp=0;
            for(char x:str.toString().toCharArray())
            temp+=x-'0';

            str=new StringBuilder(String.valueOf(temp));
            k--;
        }

        return Integer.parseInt(str.toString());
    }

    public static int findDigits2(String s, int k) {
        String sum="";
        for(int i=0;i<s.length();i++)
            sum+=s.charAt(i)-'a'+1;
        
        int ans=0;
        while(k-->0)
        {
            for(int i=0;i<sum.length();i++)
                ans+=sum.charAt(i)-'0';

            
            sum=Integer.toString(ans); 
            ans=0;
        }

        return Integer.valueOf(sum);
    }
}

