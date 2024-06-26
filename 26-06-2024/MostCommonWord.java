import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MostCommonWord {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter paragraph:");
        String para=sc.nextLine();
       
        System.out.println("Enter length:");
        int n=sc.nextInt();
        sc.nextLine();
        String[] arr=new String[n];
        System.out.println("Enter banned words:");
        for(int i=0;i<n;i++)
        arr[i]=sc.next();
        String res1=getMostCommonWord1(para,arr);
        System.out.println("Most common word:"+res1);

        String res2=getMostCommonWord2(para,arr);
        System.out.println("Most common word:"+res2);

        String res3=getMostCommonWord3(para,arr);
        System.out.println("Most common word:"+res3);
    }


    //soln-1
    public static String getMostCommonWord1(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        String[] words = paragraph.split("\\s+");

        
        String[] uniqueWords = new String[words.length];
        int[] counts = new int[words.length];
        int uniqueWordCount = 0;

       
        for (String word : words) {
            if (!word.isEmpty() && isNotBanned(word, banned)) {
                boolean found = false;
                for (int i = 0; i < uniqueWordCount; i++) {
                    if (uniqueWords[i].equals(word)) {
                        counts[i]++;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    uniqueWords[uniqueWordCount] = word;
                    counts[uniqueWordCount] = 1;
                    uniqueWordCount++;
                }
            }
        }

        String res = "";
        int maxCount = 0;
        for (int i = 0; i < uniqueWordCount; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                res = uniqueWords[i];
            }
        }

        return res;
    }

    private static boolean isNotBanned(String word, String[] banned) {
        for (String bannedWord : banned) {
            if (bannedWord.equals(word)) {
                return false;
            }
        }
        return true;
    }


    //soln-2

    public static String getMostCommonWord2(String paragraph, String[] banned) {

         paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
          String[] words = paragraph.split(" ");
        
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty() && !bannedSet.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
      
        String res = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                res = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        
        return res;
    }

    //soln-3
    public static String getMostCommonWord3(String paragraph,String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        String[] words = paragraph.split("\\s+");
        Arrays.sort(words);

        String mostCommonWord = "";
        int maxCount = 0;
        String currentWord = "";
        int currentCount = 0;

        for (String word : words) {
            if (word.isEmpty() || !isNotBanned(word, banned)) {
                continue;
            }

            if (word.equals(currentWord)) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    mostCommonWord = currentWord;
                    maxCount = currentCount;
                }
                currentWord = word;
                currentCount = 1;
            }
        }

        
        if (currentCount > maxCount && isNotBanned(currentWord, banned)) {
            mostCommonWord = currentWord;
        }

        return mostCommonWord;
    }
}