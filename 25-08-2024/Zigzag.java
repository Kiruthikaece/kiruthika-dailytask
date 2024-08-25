import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zigzag {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
        System.out.println("Enter String:");
        String s=sc.next();

        System.out.println("Enter n:");
        int n=sc.nextInt();

        zigzag1(s,n);
        zigzag2(s,n);
        
    }

    public static String zigzag1(String s, int numRows) {
       if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        int idx = 0, d = 1;
        List<Character>[] rows = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new ArrayList<>();
        }

        for (char c : s.toCharArray()) {
            rows[idx].add(c);
            if (idx == 0) {
                d = 1;
            } else if (idx == numRows - 1) {
                d = -1;
            }
            idx += d;
        }

        StringBuilder result = new StringBuilder();
        for (List<Character> row : rows) {
            for (char c : row) {
                result.append(c);
            }
        }

        return result.toString();        
    }

    public static String zigzag2(String s, int numRows) {
        if(numRows==1 || numRows>=s.length()) {
            return s;
        }

        StringBuilder str = new StringBuilder();
        for(int i=0; i<numRows; i++) {
            int one= (numRows*2)-2;
            int two= i*2;
            for(int j=i; j<s.length(); j+=one) {
                str.append(s.charAt(j));
                if(two>0 && two<one && (j+one)-two<s.length()) {
                    str.append(s.charAt((j+one)-two));
                }
            }
        }
        return str.toString();
    }
}
