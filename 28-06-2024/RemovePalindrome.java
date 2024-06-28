import java.util.Scanner;

public class RemovePalindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String:");
        String s=sc.nextLine();
        String res1=removePalindrome1(s);
        System.out.println("After remove palindrome:"+res1);

         String res2=removePalindrome2(s);
        System.out.println("After remove palindrome:"+res2);

        String res3=removePalindrome3(s);
        System.out.println("After remove palindrome:"+res3);
       
       
    }

    //soln-1
    public static String removePalindrome2(String s) { 
        String[] res=s.split(" ");
        String ans=s;
        for(String x:res) {
            if(isPalindrome(x))
            ans=ans.replaceAll(x,"").trim();
        }
        return ans;
    }

    //soln-2
    public static String removePalindrome1(String s) {
        String[] str=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(String x:str) {
            if(!isPalindrome(x)) {
                sb.append(x);
                sb.append(" ");
            }
            
        }
        return sb.toString();
    }

    private static boolean isPalindrome(String x) {
        int n=x.length();
        for(int i=0,j=n-1;i<n/2;i++,j--) {
            if(x.charAt(i)!=x.charAt(j))
            return false;
        }

        return true;
    } 

    //soln-3

    public static String removePalindrome3(String s) { 
        String[] res=s.split(" ");
        String ans=s;
        for(String x:res) {
            boolean isPalindrome=true;
            int first=0,last=x.length()-1;
            while(first<last) {
                if(x.charAt(first)!=x.charAt(last)) {
                    isPalindrome=false;
                    break;
                }
               
                first++;
                last--;
            }
            if(isPalindrome)
            ans=ans.replaceAll(x,"").trim();
        }
        return ans;
    }

}
