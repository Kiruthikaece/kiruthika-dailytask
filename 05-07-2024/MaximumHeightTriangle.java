import java.util.Scanner;

public class MaximumHeightTriangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter red balls:");
        int red=sc.nextInt();
        System.out.println("Enter blue balls:");
        int blue=sc.nextInt();
        int res1=findMaximumHeight1(red,blue);
        System.out.println(res1);
        int res2=findMaximumHeight2(red,blue);
        System.out.println(res2);
    }

    private static int findMaximumHeight1(int red, int blue) {
        return Math.max(count(red, blue), count(blue, red));
       
    }

    private static int count(int v1, int v2) {
        int ct=1;
        boolean flag = true;
        while(true) {
            if(flag) {
                if(ct <= v1) v1 -= ct;
                else break;
            } else {
                if(ct <= v2) v2 -= ct;
                else break;
            }
            ct++;
            flag = !flag;
        }
        return ct-1;
    }


    public static int findMaximumHeight2(int red, int blue) {
        int count1=0,count2=0;
        int r1=red,b1=blue;
        int r2=red,b2=blue;
        boolean bl=true;
        while(r1>=0 && b1>=0) {
            count1++;
            if (bl) {
                if(b1>= count1) {
                    b1-= count1;
                } 
                else{
                    break;
                }
            } 
            else{
                if(r1 >= count1) {
                    r1 -= count1;
                } 
                else{
                    break;
                }
            }
            bl = !bl;
        }
        boolean re=true;
        while (r2 >= 0 && b2 >= 0) {
            count2++;
            if (re) {
                if(r2>=count2) {
                    r2-=count2;
                } 
                else{
                    break;
                }
            } 
            else{
                if(b2 >= count2) {
                    b2 -= count2;
                } 
                else{
                    break;
                }
            }
            re = !re;
        }
        return Math.max(count1-1,count2-1); 
    }

}
