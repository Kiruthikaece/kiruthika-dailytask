
import java.util.Scanner;

public class MaxScore {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter String:");
    String s=sc.next();
    int res=maxScore1(s);
    System.out.println(res);
    int res2=maxScore2(s);
    System.out.println(res2);
  }
    
    public static int maxScore1(String s) {
        int i=0,j=i+1;
        int one=0,zero=0,max=0,sum=0;
        while(j<s.length()) {
            for(int o=0;o<=i;o++)
            if(s.charAt(o)=='0')
            zero++;

            for(int k=j;k<s.length();k++)
            if(s.charAt(k)=='1')
            one++;

           // System.out.println(zero+"zero"+one+"one");

            max=Math.max(max,one+zero);
            i++;
            j=i+1;
            zero=0;
            one=0;
        }
        return max;
    }

    public static int maxScore2(String s) {
        int score=0,ones=0,zeroes=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1')
                ones++;
        }
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)=='1')
                ones--;
            else
                zeroes++;
            score=Math.max(score, zeroes+ones);
        }
        return score;
    }
}

