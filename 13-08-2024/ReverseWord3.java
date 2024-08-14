
import java.util.Scanner;

public class ReverseWord3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string:");
        String str=sc.nextLine();
        String res1=reverseWord1(str);
        System.out.println("Reverse Word to given string:"+res1);

        String res2=reverseWord2(str);
        System.out.println("Reverse Word to given string:"+res2);

        String res3=reverseWord3(str);
        System.out.println("Reverse Word:"+res3);
    }

    private static String reverseWord1(String s) {
        String[] arr=s.split(" ");
       StringBuilder str=new StringBuilder();
       for(int i=0;i<arr.length;i++) {
        for(int j=arr[i].length()-1;j>=0;j--)
         str.append(arr[i].charAt(j));
         if(i!=arr.length-1)
         str.append(" ");
       }

       return str.toString();
    }

    private static String reverseWord2(String str) {
        char[] ch=str.toCharArray();
        int first=0,last=0,n=str.length();

        while(first<n) {
            while(last<n && ch[last]!=' ')
            last++;

            reverse(ch,first,last-1);
            last++;
            first=last;
        }

        return new String(ch);
    }

    
    public static void reverse(char[]a,int first,int last){
        while(first<last){
            char temp=a[last];
            a[last]=a[first];
            a[first]=temp;
            first++;
            last--;
        }
    }

    public static  String reverseWord3(String s) {
        String arr[] = s.split(" ");
        for(int i=0;i<arr.length;i++){
            arr[i] = new StringBuilder(arr[i]).reverse().toString();
        }
        return String.join(" ",arr);
    }
}