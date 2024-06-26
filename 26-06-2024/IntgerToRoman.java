import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class IntgerToRoman {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number:");
        int n=sc.nextInt();
        String res1=getRoman1(n);
        System.out.println("Intger to Roman"+res1);
        String res2=getRoman2(n);
        System.out.println("Intger to Roman"+res2);
        String res3=getRoman3(n);
        System.out.println("Intger to Roman"+res3);
    }

     //soln-1
     public static String getRoman1(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
        }
    

    //soln-2
    private static String getRoman2(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        int i = 0;
    
        while (num > 0) {
            if (num >= values[i]) {
                
                sb.append(romanNumerals[i]);
                num -= values[i];
            } else {
                i++;
            }
        }

        return sb.toString();
    }

   
    
    //soln-3
    private static String getRoman3(int num) {
        TreeMap<Integer, String> map = new TreeMap<>();
          map.put(1, "I");
          map.put(4, "IV");
          map.put(5, "V");
          map.put(9, "IX");
          map.put(10, "X");
          map.put(40, "XL");
          map.put(50, "L");
          map.put(90, "XC");
          map.put(100, "C");
          map.put(400, "CD");
          map.put(500, "D");
          map.put(900, "CM");
          map.put(1000, "M");
          
          StringBuilder result = new StringBuilder();
          while (num > 0) {
              Map.Entry<Integer, String> entry = map.floorEntry(num);
              result.append(entry.getValue());
              num -= entry.getKey();
          }
          return result.toString();
      }
      
}
