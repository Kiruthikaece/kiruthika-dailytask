import java.util.Scanner;

public class LoveLetterMystry {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String:");
        String s=sc.next();
        int res=findOperation1(s);
        System.out.println(res);

        int res2=findOperation2(s);
        System.out.println(res2);
    }

    private static int findOperation1(String s) {
        int j=s.length()-1;
        int x;
        int y;
        int count=0;
        for(int i=0;i<s.length()/2;i++){
         if(s.charAt(i)!=s.charAt(j)){

        x=s.charAt(i);
        y=s.charAt(j);
        count +=Math.abs(x-y);
        j--;

        }else{
        j--;
        }
        }
      return count;
    }

    public static int findOperation2(String s) {
       
          int first=0,last=s.length();
          int count=0;
          int half=(last%2==0)?((last/2)-1):(last/2);
         
          while(first<=half) {
              if(s.charAt(first)!=s.charAt(last-1-first))
              count+=Math.abs(s.charAt(first)-s.charAt(last-1-first));
              first++;
          }
          
          return count;

    }
}
