import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GroupAnagaram {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length:");
        int n=sc.nextInt();
        String[] arr=new String[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.next();
        List<List<String>> li1=GroupAnagaram1(arr);
        System.out.println(li1);
        List<List<String>> li2=GroupAnagaram2(arr);
        System.out.println(li2);


    }


    public static List<List<String>> GroupAnagaram1(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append("#");
                sb.append(num);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }


    private static List<List<String>> GroupAnagaram2(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String k = String.valueOf(ca);
            if (!map.containsKey(k)) map.put(k, new ArrayList<>());
            map.get(k).add(s);
        }
        
        return new ArrayList<>(map.values());
    }


}
