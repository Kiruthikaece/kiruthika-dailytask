import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CommonCharacters {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("ENter array length:");
        int n=sc.nextInt();
        System.out.println("Enter String array:");
        String[] arr=new String[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.next();
        List<String> li1=findCommonCharacter1(arr);
        System.out.println(li1);
        List<String> li2=findCommonCharacter2(arr);
        System.out.println(li2);
        List<String> li3=findCommonCharacter3(arr);
        System.out.println(li3);
    }

    //soln-1
    public static List<String> findCommonCharacter1(String[] arr) {
        int[] minFreq = new int[26];
        for (int i = 0; i < 26; i++) {
            minFreq[i] = Integer.MAX_VALUE;
        }
        
        for (String word : arr) {
            int[] charFreq = new int[26];
            for (char c : word.toCharArray()) {
                charFreq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], charFreq[i]);
            }
        }
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(String.valueOf((char)(i + 'a')));
                minFreq[i]--;
            }
        }
        return result;
    }

     //soln-2

public static List<String> findCommonCharacter2(String[] words) {
        HashMap<Character, Integer> minFreqMap = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            minFreqMap.put(c, Integer.MAX_VALUE);
        }
        
        for (String word : words) {
            HashMap<Character, Integer> charFreqMap = new HashMap<>();
            for (char c : word.toCharArray()) {
                charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
            }
            for (char c = 'a'; c <= 'z'; c++) {
                if (charFreqMap.containsKey(c)) {
                    minFreqMap.put(c, Math.min(minFreqMap.get(c), charFreqMap.get(c)));
                } else {
                    minFreqMap.put(c, 0);
                }
            }
        }
        
        List<String> result = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            int freq = minFreqMap.get(c);
            for (int i = 0; i < freq; i++) {
                result.add(String.valueOf(c));
            }
        }
        return result;
    }

 //soln-3
    public static List<String> findCommonCharacter3(String[] words) {
        List<HashMap<Character, Integer>> charFreqList = new ArrayList<>();
        
        for (String word : words) {
            HashMap<Character, Integer> charFreqMap = new HashMap<>();
            for (char c : word.toCharArray()) {
                charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
            }
            charFreqList.add(charFreqMap);
        }
        
        List<String> result = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            int minFreq = Integer.MAX_VALUE;
            for (HashMap<Character, Integer> charFreqMap : charFreqList) {
                minFreq = Math.min(minFreq, charFreqMap.getOrDefault(c, 0));
            }
            for (int i = 0; i < minFreq; i++) {
                result.add(String.valueOf(c));
            }
        }
        return result;
    }
    }
