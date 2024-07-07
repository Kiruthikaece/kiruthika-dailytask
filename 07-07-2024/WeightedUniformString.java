import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WeightedUniformString {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = scanner.nextInt();   
            weightedUniformString1(s,arr);
            weightedUniformString2(s,arr);
            weightedUniformString3(s,arr); 
    }

    //soln-1
    private static void weightedUniformString3(String s, int[] arr) {
        int[] maxWeights = new int[26];
        int currentWeight = 0;
        char prevChar = ' ';

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int weight = currentChar - 'a' + 1;
            if (currentChar == prevChar) {
                currentWeight += weight;
            } else {
                currentWeight = weight;
            }
            maxWeights[currentChar - 'a'] = Math.max(maxWeights[currentChar - 'a'], currentWeight);
            prevChar = currentChar;
        }

        for (int query : arr) {
            boolean found = false;
            for (int weight = 1; weight <= maxWeights.length; weight++) {
                if (query % weight == 0 && query / weight <= maxWeights[weight - 1]) {
                    found = true;
                    break;
                }
            }
            System.out.println(found ? "Yes" : "No");
    }
}

//soln-2
    private static void weightedUniformString2(String s, int[] arr) {
       Map<Integer, Boolean> weightMap = new HashMap<>();
        int currentWeight = 0;
        char prevChar = ' ';

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == prevChar) {
                currentWeight += currentChar - 'a' + 1;
            } else {
                currentWeight = currentChar - 'a' + 1;
            }
            weightMap.put(currentWeight, true);
            prevChar = currentChar;
        }

        for (int query : arr) {
            System.out.println(weightMap.getOrDefault(query, false) ? "Yes" : "No");
        }

    }

    //soln-3
    private static void weightedUniformString1(String s, int[] arr) {
         Set<Integer> weights = new HashSet<>();
        int currentWeight = 0;
        char prevChar = ' ';

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == prevChar) {
                currentWeight += currentChar - 'a' + 1;
            } else {
                currentWeight = currentChar - 'a' + 1;
            }
            weights.add(currentWeight);
            prevChar = currentChar;
        }

        for (int query : arr) {
            System.out.println(weights.contains(query) ? "Yes" : "No");
        }
    }
}
