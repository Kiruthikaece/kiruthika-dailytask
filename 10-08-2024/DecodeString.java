import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          System.out.println("Enter String:");
          String s=sc.next();
          String res1=decodeString1(s);
          System.out.println(res1);
          String res2=decodeString2(s);
          System.out.println(res2);
    }

    private static String decodeString1(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                int currentK = countStack.pop();
                for (int i = 0; i < currentK; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static String decodeString2(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            queue.offer(ch);
        }
        return decode(queue);
    }

    private static String decode(Queue<Character> queue) {
        StringBuilder result = new StringBuilder();
        int k = 0;

        while (!queue.isEmpty()) {
            char ch = queue.poll();

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                String decodedString = decode(queue);
                for (int i = 0; i < k; i++) {
                    result.append(decodedString);
                }
                k = 0;
            } else if (ch == ']') {
                break;
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
