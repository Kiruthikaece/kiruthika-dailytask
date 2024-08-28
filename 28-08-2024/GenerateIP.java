import java.util.*;

public class GenerateIP {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String:");
        String s=sc.next();
        List<String> res1=generateIP1(s);
        System.out.println(res1);
        List<String> res2=generateIP2(s);
        System.out.println(res2);
    }

    public static List<String> generateIP1(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() > 12 || s.length() < 4) return result;
        backtrack(result, s, 0, "", 0);
        return result;
    }

    private static void backtrack(List<String> result, String s, int index, String current, int segment) {
        if (segment == 4 && index == s.length()) {
            result.add(current);
            return;
        }
        if (segment == 4 || index == s.length()) return;

        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;
            String part = s.substring(index, index + len);
            if (isValid(part)) {
                backtrack(result, s, index + len, segment == 0 ? part : current + "." + part, segment + 1);
            }
        }
    }

    private static boolean isValid(String s) {
        if (s.length() > 1 && s.startsWith("0")) return false;
        int value = Integer.parseInt(s);
        return value >= 0 && value <= 255;
    }

    public static List<String> generateIP2(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        if (n < 4 || n > 12) return result;

        for (int i = 1; i < 4 && i < n - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < n - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < n; k++) {
                    String part1 = s.substring(0, i);
                    String part2 = s.substring(i, j);
                    String part3 = s.substring(j, k);
                    String part4 = s.substring(k);

                    if (isValid(part1) && isValid(part2) && isValid(part3) && isValid(part4)) {
                        result.add(part1 + "." + part2 + "." + part3 + "." + part4);
                    }
                }
            }
        }
        return result;
    }
}