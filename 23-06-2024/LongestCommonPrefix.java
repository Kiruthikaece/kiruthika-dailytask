import java.util.Scanner;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length:");
        int n = sc.nextInt();
        sc.nextLine();  
        System.out.println("Enter array:");
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        String res1 = findCommonPrefix1(strs);
        System.out.println("Common Prefix: " + res1);
        
        String res2 = findCommonPrefix2(strs);
        System.out.println("Common Prefix: " + res2);
    }

    private static String findCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) 
            return "";
        
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static String findCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) 
            return "";
        
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }
    
    private static String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        } else {
            int mid = (left + right) / 2;
            String lcpLeft = longestCommonPrefix(strs, left, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, right);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }
    
    private static String commonPrefix(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        for (int i = 0; i < minLength; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, minLength);
    }
}
