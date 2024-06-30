import java.util.Scanner;

public class IsSubstring {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string1:");
        String str1=sc.next();
        System.out.println("Enter string2:");
        String str2=sc.next();
        int res1=findIsSubstring1(str1,str2);
        System.out.println("substring index:"+res1);
        int res2=findIsSubstring2(str1,str2);
        System.out.println("substring index:"+res2);
        int res3=findIsSubstring3(str1,str2);
        System.out.println("substring index:"+res3);
    }

    //soln-1
    public static int findIsSubstring1(String str1, String str2) {
         if(str1.contains(str2)) {
            return str1.indexOf(str2);
         }

         return -1;
    }


    //soln-2 
    public static int findIsSubstring2(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (str1.charAt(i + j) != str2.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    //sol-3
    public static int findIsSubstring3(String str1, String str2) {
        if(str1.matches(".*" + str2 + ".*"))
        return str1.indexOf(str2);

        return -1;
   }
}