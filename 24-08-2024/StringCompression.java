import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length");
        int n=sc.nextInt();
        char[] arr=new char[n];
        System.out.println("Enter array:");
        for(int i=0;i<n;i++)
        arr[i]=sc.next().charAt(0);

        int res1=stringCompression1(arr);
        System.out.println(res1);

        // int res2=isUniqueOccutrance2(arr);
        // System.out.println(res2);

    }

   
    private static int isUniqueOccutrance2(char[] chars) {
        if (chars.length <= 1) {
            return chars.length;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length;i++) {
            char currChar = chars[i];
            int currCount = 0;
            while (i+1 < chars.length && chars[i+1] == currChar) {
                i++;
                currCount++;
            }
            sb.append(currChar);
            if (currCount > 1)
                sb.append(currCount);
        }

        String str = sb.toString();

        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        
        System.out.println(str);
        return str.length();
    }

    private static int stringCompression1(char[] chars) {
        if(chars.length==1)
         return 1;

         String s="";
         int k=0;
         for(int i=0;i<chars.length;i++) {
              char ch=chars[i];
              int count=1;

              while(i+1<chars.length && ch==chars[i+1]) {
                count++;
                i++;
              }
              s+=ch;
              if(count!=1)
              s+=count;
         }


                for(int i=0;i<s.length();i++)
                chars[i]=s.charAt(i);
      
                return s.length();
    }
}
