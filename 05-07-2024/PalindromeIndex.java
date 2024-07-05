import java.util.Scanner;

public class PalindromeIndex {
    public static void main(String[] args ) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string:");
        String s=sc.next();
        int res1=CheckPalindrome1(s);
        System.out.println(res1);
        int res2=CheckPalindrome2(s);
        System.out.println(res2);
        int res3=CheckPalindrome3(s);
        System.out.println(res3);
    }

    //soln-1
    public static int CheckPalindrome1(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isPalindrome(s, left + 1, right)) {
                    return left;
                } else if (isPalindrome(s, left, right - 1)) {
                    return right;
                } else {
                    return -1;
                }
            }
            left++;
            right--;
        }
        return -1;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //soln-2
    public static int CheckPalindrome2(String s) {
        return findIndex(s, 0, s.length() - 1);
    }

    private static int findIndex(String s, int left, int right) {
        if (left >= right) {
            return -1;
        }

        if (s.charAt(left) == s.charAt(right)) {
            return findIndex(s, left + 1, right - 1);
        } else {
            if (isPalindrome(s, left + 1, right)) {
                return left;
            } else if (isPalindrome(s, left, right - 1)) {
                return right;
            } else {
                return -1;
            }
        }
    }

    //soln-3
    public static int CheckPalindrome3(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isPalindrome(new StringBuilder(s).deleteCharAt(left).toString())) {
                    return left;
                } else if (isPalindrome(new StringBuilder(s).deleteCharAt(right).toString())) {
                    return right;
                } else {
                    return -1;
                }
            }
            left++;
            right--;
        }
        return -1;
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}