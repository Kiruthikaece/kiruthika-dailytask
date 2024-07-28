import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SortByFreq {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter String:");
	String s=sc.next();
    String res1=sortByFreq1(s);
    System.out.println(res1);
    String res2=sortByFreq2(s);
    System.out.println(res2);
}

    private static String sortByFreq1(String s) {
       
    int[] frequency = new int[128];
        for (char c : s.toCharArray()) 
            frequency[c]++;
        
        List<Character> characters = new ArrayList<>();
        for (char c : s.toCharArray()) {
            characters.add(c);
        }

        characters.sort((a, b) -> frequency[b] - frequency[a]);

        StringBuilder result = new StringBuilder();
        for (char c : characters) {
            result.append(c);
        }

        return result.toString();

}

public static String sortByFreq2(String s) {
       
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        List<Character>[] buckets = new List[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            char c = entry.getKey();
            int freq = entry.getValue();
            buckets[freq].add(c);
        }

        StringBuilder result = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            for (char c : buckets[i]) {
                for (int j = 0; j < i; j++) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}
