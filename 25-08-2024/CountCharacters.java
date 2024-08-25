import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharacters {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String:");
        String s=sc.next();

        System.out.println("Enter n:");
        int n=sc.nextInt();

        int res1=countChar1(s,n);
        System.out.println(res1);

        int res2=countChar2(s,n);
        System.out.println(res2);
    }

    private static int countChar1(String s, int N) {
        Map<Character,Integer> map=new HashMap<>();
       
       for(int i=0;i<s.length();i++)
       map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
       
       int count=0;
       for(Map.Entry<Character,Integer> mpp:map.entrySet()) {
           if(mpp.getValue()==N)
           count++;
       }
       
       return count;
    }

    private static int countChar2(String S, int N) {
        StringBuilder filteredString = new StringBuilder();
        int len = S.length();

        for (int i = 0; i < len; i++) {
            filteredString.append(S.charAt(i));
            while (i < len - 1 && S.charAt(i) == S.charAt(i + 1)) {
                i++;
            }
        }

        int[] occurrences = new int[256]; 
        for (char c : filteredString.toString().toCharArray()) {
            occurrences[c]++;
        }

        int count = 0;
        for (int occ : occurrences) {
            if (occ == N) {
                count++;
            }
        }
        return count;
    }

}

