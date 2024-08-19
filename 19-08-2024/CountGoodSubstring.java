import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountGoodSubstring {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string:");
        String s=sc.next();
        int res1=countGoodString1(s);
        System.out.println(res1);

        int res2=countGoodString2(s);
        System.out.println(res2);

        int res3=countGoodString3(s);
        System.out.println(res3);
    }

    private static int countGoodString3(String s) {
        if(s.length()<=2) return 0;
        int ans = 0;  
        for(int i=0; i<s.length()-2; i++){
            if(s.charAt(i)!=s.charAt(i+1) && s.charAt(i+1)!=s.charAt(i+2) && s.charAt(i)!=s.charAt(i+2)) 
            ans++;
        }
        return ans;
    }

    private static int countGoodString2(String s) {
        int left=0,right=0,count=0;
        Set<Character> str=new HashSet();
        while(right<s.length()-2) {

            if(right<s.length())
            str.add(s.charAt(right));
           
            if(str.size()==3) {
              
                count++;
                str.remove(s.charAt(left));
                left++;
            }
            right++;
           
        }
        return count;
    }

    private static int countGoodString1(String s) {
       
        if(s.length()==1)
        return 0;
        
        int count=s.length()-2;
        for(int i=0;i<s.length()-2;i++) {
            String str=new String();
            for(int j=i;j<i+3;j++) {
                if(str.indexOf(s.charAt(j))!=-1.
                ) {
                    count--;
                    break;
                } else
                str+=(s.charAt(j));
            }
        }

        return count;
    }
}