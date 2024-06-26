import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanToInteger {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Roman:");
        String roman=sc.next();
        int res1=getNumber1(roman);
        System.out.println("Intger to Roman:"+res1);
        int res2=getNumber2(roman);
        System.out.println("Intger to Roman:"+res2);
        int res3=getNumber3(roman);
        System.out.println("Intger to Roman:"+res3);
    }

    //soln-3
    private static int getNumber3(String s) {
        int[] values = new int[26];
        values['I' - 'A'] = 1;
        values['V' - 'A'] = 5;
        values['X' - 'A'] = 10;
        values['L' - 'A'] = 50;
        values['C' - 'A'] = 100;
        values['D' - 'A'] = 500;
        values['M' - 'A'] = 1000;

        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = values[s.charAt(i) - 'A'];
            if (i > 0 && current > values[s.charAt(i - 1) - 'A']) {
                total += current - 2 * values[s.charAt(i - 1) - 'A'];
            } else {
                total += current;
            }
        }
        return total;
    }

    //soln-2
    private static int getNumber2(String s) {
       Map<Character, Integer> m = new HashMap<>();
        
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        
        int ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                ans -= m.get(s.charAt(i));
            } else {
                ans += m.get(s.charAt(i));
            }
        }
        
        return ans;
    }

    //soln-1

    private static int getNumber1(String s) {
        int ans=0,num=0;
        for(int i=s.length()-1;i>=0;i--) {
            switch(s.charAt(i)) {
                case 'I': num=1;
                            break;
                case 'V': num=5;
                        break;
                        case 'X': num=10;
                        break;
                        case 'L': num=50;
                        break;
                        case 'C': num=100;
                        break;
                        case 'D': num=500;
                        break;
                        case 'M': num=1000;
                        break;
            }
            if(4*num<ans) 
            ans=ans-num;
            else
            ans=ans+num;
        }
        return ans;
    }
}
