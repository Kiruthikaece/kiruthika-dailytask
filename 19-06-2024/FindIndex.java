import java.util.Scanner;

public class FindIndex {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string1:");
        String str1=sc.next();
        System.out.println("Enter string2:");
        String str2=sc.next();
        int res1=findIndex1(str1,str2);
        System.out.println("Index:"+res1);
        int res2=findIndex2(str1,str2);
        System.out.println("Index:"+res2);
        int res3=findIndex3(str1,str2);
        System.out.println("Index:"+res3);
    }

//soln-1
    public static int findIndex3(String str1, String str2) {
       for(int i=0,j=str2.length();i<str1.length();i++,j++)
       if(str1.substring(i,j).equals(str2))
       return i;

       return -1;
        
    }

//soln-2
    public static int findIndex2(String str1, String str2) {
        if(!str1.contains(str2)) 
        return -1;

        for(int i=0;i<str1.length();i++) {
            if(str1.substring(i,i+str2.length()).equals(str2))
            return i;
        }

        return -1;
        
    }
//soln-3
    private static int findIndex1(String str1, String str2) {
        if(str1.contains(str2))
            return str1.indexOf(str2);
     

        return -1;
    }
}